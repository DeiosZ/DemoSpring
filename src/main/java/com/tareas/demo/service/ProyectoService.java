package com.tareas.demo.service;


import com.tareas.demo.DTO.ProyectoCreateDTO;
import com.tareas.demo.DTO.ProyectoDTO;
import com.tareas.demo.entity.Proyecto;
import com.tareas.demo.entity.Usuario;
import com.tareas.demo.mapper.ProyectoMapper;
import com.tareas.demo.repository.ProyectoRepository;
import com.tareas.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProyectoService {
    @Autowired
    private  ProyectoRepository proyectoRepository;
    @Autowired
    private  UsuarioRepository usuarioRepository;

    public ProyectoDTO crearProyecto(ProyectoCreateDTO dto){

        Usuario usuario = usuarioRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        Proyecto proyecto = ProyectoMapper.toEntity(dto, usuario);
        Proyecto guardado = proyectoRepository.save(proyecto);
        return ProyectoMapper.toDTO(guardado);
    }

    public List<ProyectoDTO> listarPorUsuario(Long userId){
        return proyectoRepository.findByUsuarioId(userId)
                .stream()
                .map(ProyectoMapper::toDTO)
                .toList();
    }


}
