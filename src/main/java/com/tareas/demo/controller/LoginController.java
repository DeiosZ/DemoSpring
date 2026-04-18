package com.tareas.demo.controller;

import com.tareas.demo.DTO.LoginDTO;
import com.tareas.demo.DTO.UsuarioDTO;
import com.tareas.demo.entity.Usuario;
import com.tareas.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Inicio")
public class LoginController {
    @Autowired
    private UsuarioService service;

    @PostMapping("/login")
    public UsuarioDTO login(@RequestBody LoginDTO u) {
        return service.login(u);
    }
}
