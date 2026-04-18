package com.tareas.demo.controller;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tareas.demo.entity.Tarea;
import com.tareas.demo.service.TareaService;
import com.tareas.demo.service.UsuarioService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
@RequiredArgsConstructor
public class TareaController {

    private final TareaService tareaService;


    @GetMapping("/")
    public List<Tarea> listar(){
        return tareaService.listarTarea();
    }
    /*
    @GetMapping("/{id}")
    public Tarea obtener(@PathVariable Integer id) {
        return tareaService.tareaPorId(id);
    }

    @GetMapping("/usuario/{id}")
    public List<Tarea> tareasPorUsuario(@PathVariable Integer id){
        return tareaService.tareasPorUsuario(id);
    }

    @PostMapping
    public Tarea crear(@RequestBody Tarea tarea) {
        return tareaService.guardarTarea(tarea);
    }

    @PutMapping("/{id}")
    public Tarea actualizar(@PathVariable Integer id, @RequestBody Tarea tarea) {
        return tareaService.actualizarTarea(id, tarea);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        tareaService.eliminarTarea(id);
    }
    */
}
