package com.tareas.demo.mapper;

import com.tareas.demo.DTO.PrioridadDTO;
import com.tareas.demo.entity.Prioridad;

public class PrioridadMapper {

    public static PrioridadDTO toDTO(Prioridad p) {
        return PrioridadDTO.builder()
                .id(p.getId())
                .name(p.getName())
                .color(p.getColor())
                .build();
    }
}