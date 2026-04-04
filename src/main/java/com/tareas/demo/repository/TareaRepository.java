package com.tareas.demo.repository;

import com.tareas.demo.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea,Integer> {
    List<Tarea> findByUsuarioId(Integer usuarioId);
}
