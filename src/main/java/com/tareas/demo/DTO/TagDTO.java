package com.tareas.demo.DTO;
import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter
@Builder
public class TagDTO {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private Long proyectoId;
}
