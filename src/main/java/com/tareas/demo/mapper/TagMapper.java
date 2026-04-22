package com.tareas.demo.mapper;

import com.tareas.demo.DTO.TagDTO;
import com.tareas.demo.entity.Tag;

import java.util.List;

public class TagMapper {
    public static TagDTO toDTO(Tag t){
        return TagDTO.builder()
                .id(t.getId())
                .name(t.getName())
                .createdAt(t.getCreatedAt())
                .proyectoId(
                        t.getProyecto() != null
                                ? t.getProyecto().getId()
                                : null
                )
                .build();
    }
    public static List<TagDTO> toDTOList(List<Tag> tags) {
        return tags.stream()
                .map(TagMapper::toDTO)
                .toList();
    }
}
