package com.tareas.demo.DTO;
import lombok.*;

@Getter
@Setter
@Builder
public class UsuarioDTO {
    private Long id;
    private String name;
    private String email;
}
