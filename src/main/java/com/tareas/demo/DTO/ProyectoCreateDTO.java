package com.tareas.demo.DTO;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoCreateDTO {
    private String name;
    private String description;
    private String color;
    private String image;

    private Long userId;
}
