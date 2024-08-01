package org.NARA.PROYECTO_1.controladores;

import org.NARA.PROYECTO_1.modelos.MarcaNARA;
import org.NARA.PROYECTO_1.servicios.Implementaciones.MarcaNARAService;
import org.NARA.PROYECTO_1.servicios.Interfaces.IMarcaNARAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/Marca")
public class MarcaNARAController
{
    @Autowired
    private IMarcaNARAService marcaNARAService;


    // Metodo Para Mostrar Todos Los Registros:
    @GetMapping
    public String Index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1) - 1; // si no está seteado se asigna 0
        int pageSize = size.orElse(5); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<MarcaNARA> Listado_Marcas = marcaNARAService.buscarTodosPaginados(pageable);
        model.addAttribute("Listado_Marcas", Listado_Marcas);

        int totalPages = Listado_Marcas.getTotalPages();

        if (totalPages > 0)
        {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());

            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "Marca/Index";
    }



    // Metodo Crear Vista
    @GetMapping("/Create")
    public String Create(MarcaNARA marcaNARA){
        return "Marca/Create";
    }

    // Metodo Guarda El Objeto En La DB:
    @PostMapping("/save")
    public String save(MarcaNARA marcaNARA, BindingResult result, Model model, RedirectAttributes attributes){
        if(result.hasErrors()){
            model.addAttribute(marcaNARA);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "Marca/Create";
        }

        marcaNARAService.crearOEditar(marcaNARA);
        attributes.addFlashAttribute("msg", "Grupo creado correctamente");
        return "redirect:/Marca";
    }


    // Nos Manda A La Vista Un Registro Encontrado:
    @GetMapping("/Details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        MarcaNARA marcaNARA = marcaNARAService.buscarPorId(id).get();
        model.addAttribute("marcaNARA", marcaNARA);
        return "Marca/Details";
    }


    // Nos Manda A La Vista Editar Con Un Registro Encontrado
    @GetMapping("/Edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        MarcaNARA marcaNARA = marcaNARAService.buscarPorId(id).get();
        model.addAttribute("marcaNARA", marcaNARA);
        return "Marca/Edit";
    }

    // Nos Manda A La Vista Eliminar Con Un Registro Encontrado
    @GetMapping("/Remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        MarcaNARA marcaNARA = marcaNARAService.buscarPorId(id).get();
        model.addAttribute("marcaNARA", marcaNARA);
        return "Marca/Delete";
    }

    // Busca El Registro Y Lo Elimina De La DB:
    @PostMapping("/Delete")
    public String delete(MarcaNARA marcaNARA, RedirectAttributes attributes){
        marcaNARAService.eliminarPorId(marcaNARA.getId());
        attributes.addFlashAttribute("msg", "Marca Eliminada correctamente");
        return "redirect:/Marca";
    }



}
