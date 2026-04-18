package com.tareas.demo.service;
import com.tareas.demo.DTO.TagDTO;
import com.tareas.demo.entity.Proyecto;
import com.tareas.demo.entity.Tag;
import com.tareas.demo.mapper.TagMapper;
import com.tareas.demo.repository.ProyectoRepository;
import com.tareas.demo.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepo;
    private final ProyectoRepository proyectoRepo;

    public Tag crearTag(Long proyectoId, Tag tag) {

        Proyecto proyecto = proyectoRepo.findById(proyectoId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        tag.setProyecto(proyecto);
        tag.setCreatedAt(LocalDateTime.now());

        return tagRepo.save(tag);
    }

    public List<TagDTO> listarPorProyecto(Long proyectoId) {

        // opcional: validar que el proyecto exista
        proyectoRepo.findById(proyectoId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        List<Tag> tags = tagRepo.findByProyectoId(proyectoId);

        return TagMapper.toDTOList(tags);
    }
}