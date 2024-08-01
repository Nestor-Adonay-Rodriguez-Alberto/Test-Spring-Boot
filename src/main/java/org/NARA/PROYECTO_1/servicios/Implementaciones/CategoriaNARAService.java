package org.NARA.PROYECTO_1.servicios.Implementaciones;

import org.NARA.PROYECTO_1.modelos.CategoriaNARA;
import org.NARA.PROYECTO_1.modelos.MarcaNARA;
import org.NARA.PROYECTO_1.repositorios.ICategoriaNARARepository;
import org.NARA.PROYECTO_1.repositorios.IMarcaNARARepository;
import org.NARA.PROYECTO_1.servicios.Interfaces.ICategoriaNARAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaNARAService implements ICategoriaNARAService
{
    @Autowired
    private ICategoriaNARARepository categoriaNARARepository;

    @Override
    public Page<CategoriaNARA> buscarTodosPaginados(Pageable pageable)
    {
        return categoriaNARARepository.findAll(pageable);
    }

    @Override
    public List<CategoriaNARA> obtenerTodos()
    {
        return categoriaNARARepository.findAll();
    }

    @Override
    public Optional<CategoriaNARA> buscarPorId(Integer id) {
        return categoriaNARARepository.findById(id);
    }

    @Override
    public CategoriaNARA crearOEditar(CategoriaNARA categoriaNARA) {
        return categoriaNARARepository.save(categoriaNARA);
    }

    @Override
    public void eliminarPorId(Integer id)
    {
        categoriaNARARepository.deleteById(id);
    }
}
