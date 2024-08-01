package org.NARA.PROYECTO_1.servicios.Implementaciones;

import org.NARA.PROYECTO_1.modelos.MarcaNARA;
import org.NARA.PROYECTO_1.repositorios.IMarcaNARARepository;
import org.NARA.PROYECTO_1.servicios.Interfaces.IMarcaNARAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaNARAService implements IMarcaNARAService
{

    @Autowired
    private IMarcaNARARepository marcaNARARepository;

    @Override
    public Page<MarcaNARA> buscarTodosPaginados(Pageable pageable)
    {
        return marcaNARARepository.findAll(pageable);
    }

    @Override
    public List<MarcaNARA> obtenerTodos()
    {
        return marcaNARARepository.findAll();
    }

    @Override
    public Optional<MarcaNARA> buscarPorId(Integer id) {
        return marcaNARARepository.findById(id);
    }

    @Override
    public MarcaNARA crearOEditar(MarcaNARA marcaNARA) {
        return marcaNARARepository.save(marcaNARA);
    }

    @Override
    public void eliminarPorId(Integer id)
    {
        marcaNARARepository.deleteById(id);
    }
}
