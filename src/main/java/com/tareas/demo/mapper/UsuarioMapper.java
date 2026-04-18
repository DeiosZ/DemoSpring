package com.tareas.demo.mapper;

import com.tareas.demo.DTO.UsuarioCreateDTO;
import com.tareas.demo.DTO.UsuarioDTO;
import com.tareas.demo.entity.Usuario;

import java.time.LocalDateTime;

public class UsuarioMapper {
    public static Usuario toEntity(UsuarioCreateDTO dto){
        return  Usuario.builder()
                .name(dto.getName())
                .lastname(dto.getLastname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .isAdmin(false) // valor por defecto
                .isActive(true) //valor por defecto
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static UsuarioDTO toDTO(Usuario usuario){
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .name(usuario.getName())
                .email(usuario.getEmail())
                .build();
    }
}
