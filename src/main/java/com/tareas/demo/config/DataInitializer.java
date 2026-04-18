package com.tareas.demo.config;

import com.tareas.demo.entity.Prioridad;
import com.tareas.demo.repository.PrioridadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final PrioridadRepository prioridadRepo;

    @Override
    public void run(String... args) {

        if (prioridadRepo.count() == 0) {

            prioridadRepo.save(Prioridad.builder()
                    .name("LOW")
                    .color("green")
                    .build());

            prioridadRepo.save(Prioridad.builder()
                    .name("MEDIUM")
                    .color("orange")
                    .build());

            prioridadRepo.save(Prioridad.builder()
                    .name("HIGH")
                    .color("red")
                    .build());
        }
    }
}