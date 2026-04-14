package com.tareas.demo.mapper;

import com.tareas.demo.DTO.TareaDTO;
import com.tareas.demo.entity.Tag;
import com.tareas.demo.entity.Tarea;

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
                        .map(Tag::getId).toList()
                )
                .build();
    }
}
