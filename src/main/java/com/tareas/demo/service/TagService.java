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
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepo;
    private final ProyectoRepository proyectoRepo;

    public Tag crearTag(Long proyectoId, Tag tag) {
        // evitar duplicados
        String nombre = tag.getName().trim();

        // VALIDAR TAG GLOBAL
        if (proyectoId == null) {
            if (tagRepo.findByNameAndProyectoIsNull(nombre).isPresent()) {
                throw new RuntimeException("Tag global ya existe");
            }
            tag.setProyecto(null);
        }
        // VALIDAR TAG POR PROYECTO
        else {
            Proyecto proyecto = proyectoRepo.findById(proyectoId)
                    .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

            if (tagRepo.findByNameAndProyectoId(nombre, proyectoId).isPresent()) {
                throw new RuntimeException("Tag ya existe en el proyecto");
            }

            tag.setProyecto(proyecto);
        }

        tag.setName(nombre);
        tag.setCreatedAt(LocalDateTime.now());

        return tagRepo.save(tag);
    }

    public List<TagDTO> listarTagsPorProyecto(Long proyectoId) {

        proyectoRepo.findById(proyectoId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        List<Tag> resultado = new ArrayList<>();

        resultado.addAll(tagRepo.findByProyectoIsNull());

        resultado.addAll(tagRepo.findByProyectoId(proyectoId));

        return TagMapper.toDTOList(resultado);
    }

    public List<TagDTO> listarTags() {
        return  TagMapper.toDTOList(tagRepo.findAll());
    }
}