package com.tareas.demo.entity;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "priority")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor @Builder
public class Prioridad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String color;
    private String image;

    @OneToMany(mappedBy = "prioridad")
    private List<Tarea> tareas;
}
