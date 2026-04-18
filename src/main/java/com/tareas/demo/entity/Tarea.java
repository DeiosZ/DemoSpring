package com.tareas.demo.entity;
import jakarta.persistence.*;
import lombok.*;

import javax.net.ssl.SSLSession;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "task")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    private LocalDateTime startAt;
    private LocalDateTime finishAt;

    private Boolean isFinish;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Proyecto proyecto;

    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Prioridad prioridad;

    @ManyToMany
    @JoinTable(
            name = "task_tag",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
}
