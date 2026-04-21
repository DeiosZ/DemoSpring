package com.tareas.demo.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tag")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "project_id",nullable = true)
    private Proyecto proyecto;

    @ManyToMany(mappedBy = "tags")
    private List<Tarea> tareas;
}