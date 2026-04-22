package com.tareas.demo.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PrioridadDTO {

    private Long id;
    private String name;
    private String color;
}