package com.tareas.demo.controller;
import com.tareas.demo.entity.Prioridad;
import com.tareas.demo.repository.PrioridadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prioridades")
public class PrioridadController {

    @Autowired
    private PrioridadRepository prioridadRepo;

    @GetMapping
    public List<Prioridad> listarPrioridades() {
        return prioridadRepo.findAll();
    }
}
