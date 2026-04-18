package com.tareas.demo.DTO;

import lombok.Builder;
import lombok.*;

@Getter
@Setter
@Builder
public class UsuarioCreateDTO {
    private String name;
    private String lastname;
    private String email;
    private String password;
}
