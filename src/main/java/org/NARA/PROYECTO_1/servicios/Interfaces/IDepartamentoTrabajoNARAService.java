package org.NARA.PROYECTO_1.servicios.Interfaces;

import org.NARA.PROYECTO_1.modelos.CategoriaNARA;
import org.NARA.PROYECTO_1.modelos.DepartamentoTrabajoNARA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoTrabajoNARAService
{
    Page<DepartamentoTrabajoNARA> buscarTodosPaginados(Pageable pageable);

    List<DepartamentoTrabajoNARA> obtenerTodos();

    Optional<DepartamentoTrabajoNARA> buscarPorId(Integer id);

    DepartamentoTrabajoNARA crearOEditar(DepartamentoTrabajoNARA departamentoTrabajoNARA);

    void eliminarPorId(Integer id);
}
