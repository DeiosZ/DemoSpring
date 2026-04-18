package com.tareas.demo.service;

import com.tareas.demo.DTO.TareaCreateDTO;
import com.tareas.demo.DTO.TareaDTO;
import com.tareas.demo.entity.*;
import com.tareas.demo.mapper.TareaMapper;
import com.tareas.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {
    @Autowired
    private ProyectoRepository proyectoRepo;
    @Autowired
    private PrioridadRepository prioridadRepo;
    @Autowired
    private TagRepository tagRepo;
    @Autowired
    private  TareaRepository tareaRepo;


    //listar tareas
    public List<TareaDTO> listarPorProyecto(Long proyectoId) {
        return tareaRepo.findByProyectoId(proyectoId)
                .stream()
                .map(TareaMapper::toDTO)
                .toList();
    }

    public TareaDTO crearTarea(TareaCreateDTO dto) {

        if (dto.getTagIds() == null || dto.getTagIds().isEmpty()) {
            throw new RuntimeException("Debe enviar tagIds");
        }

        Proyecto proyecto = proyectoRepo.findById(dto.getProyectoId())
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        Prioridad prioridad = prioridadRepo.findById(dto.getPrioridadId())
                .orElseThrow(() -> new RuntimeException("Prioridad no encontrada"));

        List<Tag> tags = tagRepo.findByIdInAndProyectoId(
                dto.getTagIds(),
                dto.getProyectoId()
        );

        if (tags.size() != dto.getTagIds().size()) {
            throw new RuntimeException("Uno o más tags no pertenecen al proyecto");
        }

        Tarea tarea = TareaMapper.toEntity(dto, proyecto, prioridad, tags);

        return TareaMapper.toDTO(tareaRepo.save(tarea));
    }

}
