package com.tareas.demo.DTO;
import lombok.*;

@Getter
@Setter
@Builder
public class UsuarioDTO {
    private Integer id;
    private String name;
    private String email;
}
