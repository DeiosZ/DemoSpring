package com.tareas.demo.repository;

import com.tareas.demo.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag,Long> {
    List<Tag> findByIdInAndProyectoId(List<Long> ids, Long proyectoId);
    List<Tag> findByProyectoId(Long proyectoId);


    List<Tag> findByProyectoIsNull(); //si no añadimos ningun tag al proyecto
    Optional<Tag> findByNameAndProyectoId(String name, Long proyectoId);
    Optional<Tag> findByNameAndProyectoIsNull(String name);

    List<Tag> findByIdIn(List<Long> ids);
}
