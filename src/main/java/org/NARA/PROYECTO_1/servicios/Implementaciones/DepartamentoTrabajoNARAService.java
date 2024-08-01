package org.NARA.PROYECTO_1.servicios.Implementaciones;


import org.NARA.PROYECTO_1.modelos.DepartamentoTrabajoNARA;
import org.NARA.PROYECTO_1.repositorios.IDepartamentoTrabajoNARARepository;
import org.NARA.PROYECTO_1.servicios.Interfaces.IDepartamentoTrabajoNARAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoTrabajoNARAService implements IDepartamentoTrabajoNARAService
{
    @Autowired
    private IDepartamentoTrabajoNARARepository departamentoTrabajoNARARepository;

    @Override
    public Page<DepartamentoTrabajoNARA> buscarTodosPaginados(Pageable pageable)
    {
        return departamentoTrabajoNARARepository.findAll(pageable);
    }

    @Override
    public List<DepartamentoTrabajoNARA> obtenerTodos()
    {
        return departamentoTrabajoNARARepository.findAll();
    }

    @Override
    public Optional<DepartamentoTrabajoNARA> buscarPorId(Integer id) {
        return departamentoTrabajoNARARepository.findById(id);
    }

    @Override
    public DepartamentoTrabajoNARA crearOEditar(DepartamentoTrabajoNARA departamentoTrabajoNARA) {
        return departamentoTrabajoNARARepository.save(departamentoTrabajoNARA);
    }

    @Override
    public void eliminarPorId(Integer id)
    {
        departamentoTrabajoNARARepository.deleteById(id);
    }
}
