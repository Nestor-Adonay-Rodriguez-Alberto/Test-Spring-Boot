package org.NARA.PROYECTO_1.controladores;


import org.NARA.PROYECTO_1.modelos.DepartamentoTrabajoNARA;
import org.NARA.PROYECTO_1.servicios.Interfaces.IDepartamentoTrabajoNARAService;
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
@RequestMapping("/Departamentos")
public class DepartamentoTrabajoNARAController
{
    @Autowired
    private IDepartamentoTrabajoNARAService departamentoTrabajoNARAService;

    // Metodo Para Mostrar Todos Los Registros:
    @GetMapping
    public String Index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1) - 1; // si no está seteado se asigna 0
        int pageSize = size.orElse(5); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<DepartamentoTrabajoNARA> Listado_Departamentos = departamentoTrabajoNARAService.buscarTodosPaginados(pageable);
        model.addAttribute("Listado_Departamentos", Listado_Departamentos);

        int totalPages = Listado_Departamentos.getTotalPages();

        if (totalPages > 0)
        {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());

            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "Departamento/Index";
    }

    // Metodo Crear Vista
    @GetMapping("/Create")
    public String Create(DepartamentoTrabajoNARA departamentoTrabajoNARA){
        return "Departamento/Create";
    }

    // Metodo Guarda El Objeto En La DB:
    @PostMapping("/save")
    public String save(DepartamentoTrabajoNARA departamentoTrabajoNARA, BindingResult result, Model model, RedirectAttributes attributes){
        if(result.hasErrors()){
            model.addAttribute(departamentoTrabajoNARA);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "Departamentos/Create";
        }

        departamentoTrabajoNARAService.crearOEditar(departamentoTrabajoNARA);
        attributes.addFlashAttribute("msg", "Departamento Creado correctamente");
        return "redirect:/Departamentos";
    }

    // Nos Manda A La Vista Un Registro Encontrado:
    @GetMapping("/Details/{id}")
    public String details(@PathVariable("id") Integer id, Model model){
        DepartamentoTrabajoNARA departamentoTrabajoNARA = departamentoTrabajoNARAService.buscarPorId(id).get();
        model.addAttribute("departamentoTrabajoNARA", departamentoTrabajoNARA);
        return "Departamento/Details";
    }


    // Nos Manda A La Vista Editar Con Un Registro Encontrado
    @GetMapping("/Edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        DepartamentoTrabajoNARA departamentoTrabajoNARA = departamentoTrabajoNARAService.buscarPorId(id).get();
        model.addAttribute("departamentoTrabajoNARA", departamentoTrabajoNARA);
        return "Departamento/Edit";
    }

    // Nos Manda A La Vista Eliminar Con Un Registro Encontrado
    @GetMapping("/Remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model){
        DepartamentoTrabajoNARA departamentoTrabajoNARA = departamentoTrabajoNARAService.buscarPorId(id).get();
        model.addAttribute("departamentoTrabajoNARA", departamentoTrabajoNARA);
        return "Departamento/Delete";
    }

    // Busca El Registro Y Lo Elimina De La DB:
    @PostMapping("/Delete")
    public String delete(DepartamentoTrabajoNARA departamentoTrabajoNARA, RedirectAttributes attributes){
        departamentoTrabajoNARAService.eliminarPorId(departamentoTrabajoNARA.getId());
        attributes.addFlashAttribute("msg", "Departamento Eliminado correctamente");
        return "redirect:/Departamentos";
    }
}
