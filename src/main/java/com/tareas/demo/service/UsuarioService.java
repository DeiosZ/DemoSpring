package com.tareas.demo.service;

import com.tareas.demo.DTO.LoginDTO;
import com.tareas.demo.DTO.UsuarioCreateDTO;
import com.tareas.demo.DTO.UsuarioDTO;
import com.tareas.demo.entity.Usuario;
import com.tareas.demo.mapper.UsuarioMapper;
import com.tareas.demo.repository.UsuarioRepository;
import jakarta.persistence.Access;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UsuarioService {
    @Autowired
    private UsuarioRepository repo;

    //Listar usuarios
    public List<UsuarioDTO> listar(){
        return repo.findAll()
                .stream()
                .map(UsuarioMapper::toDTO)
                .toList();
    }

    public UsuarioDTO login(LoginDTO dto){
        Usuario u = repo.findByEmail(dto.getEmail())
                .orElseThrow(()-> new RuntimeException("Usuario no encontrado"));

        if(!u.getPassword().equals(dto.getPassword())){
            throw new RuntimeException("Password Incorrecto");
        }
        return UsuarioMapper.toDTO(u);
    }

    public UsuarioDTO register(UsuarioCreateDTO dto){
        if(repo.findByEmail(dto.getEmail())!=null){
            throw new RuntimeException("Correo existente");
        }
        Usuario u  = UsuarioMapper.toEntity(dto);
        Usuario guardado = repo.save(u);
        return  UsuarioMapper.toDTO(guardado);

    }

}
