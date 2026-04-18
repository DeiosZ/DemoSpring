package com.tareas.demo.mapper;

import com.tareas.demo.DTO.TareaCreateDTO;
import com.tareas.demo.DTO.TareaDTO;
import com.tareas.demo.entity.Prioridad;
import com.tareas.demo.entity.Proyecto;
import com.tareas.demo.entity.Tag;
import com.tareas.demo.entity.Tarea;

import java.time.LocalDateTime;
import java.util.List;

public class TareaMapper {
    public static TareaDTO toDTO(Tarea t){
        return TareaDTO.builder()
                .id(t.getId())
                .name(t.getName())
                .description(t.getDescription())
                .startAt(t.getStartAt())
                .finishAt(t.getFinishAt())
                .isFinish(t.getIsFinish())
                .projectId(t.getProyecto().getId())
                .priorityId(t.getPrioridad().getId())
                .tagIds(t.getTags()
                        .stream()
                        .map(tag -> tag.getId())
                        .toList()
                )
                .build();
    }

    public static Tarea toEntity(TareaCreateDTO dto,
                                 Proyecto proyecto,
                                 Prioridad prioridad,
                                 List<Tag> tags) {

        return Tarea.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .startAt(dto.getStartAt())
                .isFinish(false)
                .createdAt(LocalDateTime.now())
                .proyecto(proyecto)
                .prioridad(prioridad)
                .tags(tags)
                .build();
    }
}
