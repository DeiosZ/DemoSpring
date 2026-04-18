package com.tareas.demo.controller;

import com.tareas.demo.DTO.UsuarioDTO;
import com.tareas.demo.entity.Usuario;
import com.tareas.demo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/")
    public List<UsuarioDTO> listar(){
        return usuarioService.listar();
    }
/*
    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Integer id){
        return usuarioService.usuarioPorId(id);
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario){
        return usuarioService.guardarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Integer id, @RequestBody Usuario usuario){
        return  usuarioService.actualizarUsuario(id,usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id){
        usuarioService.eliminarUsuario(id);
    }

 */
}
