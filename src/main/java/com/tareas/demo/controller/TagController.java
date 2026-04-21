package com.tareas.demo.controller;
import com.tareas.demo.DTO.TagDTO;
import com.tareas.demo.entity.Tag;
import com.tareas.demo.service.TagService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping
    public List<TagDTO> listarTags() {
        return tagService.listarTags();
    }

    @GetMapping("/proyecto/{id}")
    public List<TagDTO> listar(@PathVariable Long id){
        return tagService.listarTagsPorProyecto(id);
    }
    //crear tag para proyecto
    @PostMapping("/proyecto/{proyectoId}")
    public Tag crear(@PathVariable Long proyectoId, @RequestBody Tag tag) {
        return tagService.crearTag(proyectoId, tag);
    }
    //crear tag global
    @PostMapping("/global")
    public Tag crearGlobal(@RequestBody Tag tag) {
        return tagService.crearTag(null, tag);
    }
}
