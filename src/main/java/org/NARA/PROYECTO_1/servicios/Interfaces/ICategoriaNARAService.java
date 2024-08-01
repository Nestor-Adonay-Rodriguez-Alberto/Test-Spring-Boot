package org.NARA.PROYECTO_1.servicios.Interfaces;

import org.NARA.PROYECTO_1.modelos.CategoriaNARA;
import org.NARA.PROYECTO_1.modelos.MarcaNARA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICategoriaNARAService
{
    Page<CategoriaNARA> buscarTodosPaginados(Pageable pageable);

    List<CategoriaNARA> obtenerTodos();

    Optional<CategoriaNARA> buscarPorId(Integer id);

    CategoriaNARA crearOEditar(CategoriaNARA categoriaNARA);

    void eliminarPorId(Integer id);
}
