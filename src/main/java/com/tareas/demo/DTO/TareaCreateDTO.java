package com.tareas.demo.DTO;
import lombok.*;
import java.util.List;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TareaCreateDTO {
    private String name;
    private String description;
    private LocalDateTime startAt;
    private Long proyectoId;
    private Long prioridadId;
    private List<Long> tagIds;
}
