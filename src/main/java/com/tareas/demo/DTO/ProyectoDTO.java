package com.tareas.demo.DTO;
import lombok.*;

@Getter
@Setter
@Builder
public class ProyectoDTO {
    private Long id;
    private String name;
    private String description;
    private Long userId;
}
