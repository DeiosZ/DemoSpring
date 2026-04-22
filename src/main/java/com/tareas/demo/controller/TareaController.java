package com.tareas.demo.controller;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tareas.demo.DTO.TareaCreateDTO;
import com.tareas.demo.DTO.TareaDTO;
import com.tareas.demo.entity.Tarea;
import com.tareas.demo.service.TareaService;
import com.tareas.demo.service.UsuarioService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")

public class TareaController {

    @Autowired
    private TareaService tareaService;


    @GetMapping("/proyecto/{id}")
    public List<TareaDTO> listar(@PathVariable Long id){
        return tareaService.listarPorProyecto(id);
    }

    @PostMapping("/proyecto/{proyectoId}/crear")
    public TareaDTO crear(
            @PathVariable Long proyectoId,
            @RequestBody TareaCreateDTO dto
    ) {

        return tareaService.crearTarea(proyectoId,dto);
    }
}
