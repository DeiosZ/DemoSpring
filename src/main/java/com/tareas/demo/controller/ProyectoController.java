package com.tareas.demo.controller;

import com.tareas.demo.DTO.ProyectoCreateDTO;

import com.tareas.demo.DTO.ProyectoDTO;
import com.tareas.demo.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {
    @Autowired
    private ProyectoService service;

    @GetMapping("/users/{userId}/projects")
    public List<ProyectoDTO> getProyectosByUsuario(@PathVariable Long userId){
        return service.listarPorUsuario(userId);
    }

    @PostMapping("/crear")
    public ProyectoDTO crear(@RequestBody ProyectoCreateDTO dto){
        return service.crearProyecto(dto);
    }


}
