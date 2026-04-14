package com.tareas.demo.DTO;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TareaDTO {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime startAt;
    private LocalDateTime finishAt;
    private Boolean isFinish;

    private Long projectId;
    private Long priorityId;
    private List<Long> tagIds;
}