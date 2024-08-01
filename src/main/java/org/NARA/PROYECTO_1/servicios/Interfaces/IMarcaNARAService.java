package org.NARA.PROYECTO_1.servicios.Interfaces;


import org.NARA.PROYECTO_1.modelos.MarcaNARA;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IMarcaNARAService
{
    Page<MarcaNARA> buscarTodosPaginados(Pageable pageable);

    List<MarcaNARA> obtenerTodos();

    Optional<MarcaNARA> buscarPorId(Integer id);

    MarcaNARA crearOEditar(MarcaNARA marcaNARA);

    void eliminarPorId(Integer id);
}
