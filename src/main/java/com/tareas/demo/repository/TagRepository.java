package com.tareas.demo.repository;

import com.tareas.demo.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag,Long> {
    List<Tag> findByIdInAndProyectoId(List<Long> ids, Long proyectoId);
    List<Tag> findByProyectoId(Long proyectoId);
}
