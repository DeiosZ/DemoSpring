package com.tareas.demo.service;

import com.tareas.demo.entity.Usuario;
import com.tareas.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repo;

    //Listar usuarios
    public List<Usuario> listar(){
        return repo.findAll();
    }

    //buscar por id
    public Usuario usuarioPorId(Integer id){
        return repo.findById(id).orElseThrow(()->new RuntimeException("Usuario no encontrado"));
    }

    //guardar usuarios
    public Usuario guardarUsuario(Usuario u){
        return repo.save(u);
    }

    //actualizar usuario
    public Usuario actualizarUsuario(Integer id ,Usuario u){
        Usuario usuario = usuarioPorId(id);
        usuario.setNombre(u.getNombre());
        usuario.setEmail(u.getEmail());
        return repo.save(usuario);
    }

    //eliminar usuario
    public void eliminarUsuario(Integer id){
        repo.deleteById(id);
    }
}
