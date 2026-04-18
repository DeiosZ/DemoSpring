package com.tareas.demo.mapper;

import com.tareas.demo.DTO.ProyectoCreateDTO;
import com.tareas.demo.DTO.ProyectoDTO;
import com.tareas.demo.entity.Proyecto;
import com.tareas.demo.entity.Usuario;

import java.time.LocalDateTime;

public class ProyectoMapper {
    public static Proyecto toEntity(ProyectoCreateDTO dto , Usuario u){
        return Proyecto.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .color(dto.getColor())
                .image(dto.getImage())
                .createdAt(LocalDateTime.now()) //valor por defecto
                .usuario(u)
                .build();
    }

    public static ProyectoDTO toDTO(Proyecto proyecto){
        return ProyectoDTO.builder()
                .id(proyecto.getId())
                .name(proyecto.getName())
                .description(proyecto.getDescription())
                .userId(proyecto.getUsuario().getId())
                .build();
    }
}
