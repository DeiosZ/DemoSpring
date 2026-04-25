package com.tareas.demo.service;


import com.tareas.demo.DTO.ProyectoCreateDTO;
import com.tareas.demo.DTO.ProyectoDTO;
import com.tareas.demo.DTO.TagDTO;
import com.tareas.demo.entity.Proyecto;
import com.tareas.demo.entity.Tag;
import com.tareas.demo.entity.Tarea;
import com.tareas.demo.entity.Usuario;
import com.tareas.demo.mapper.ProyectoMapper;
import com.tareas.demo.repository.ProyectoRepository;
import com.tareas.demo.repository.TagRepository;
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
    @Autowired
    private TagRepository tagRepository;

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

    public void asignarTags(Long proyectoId, List<Long> tagIds){

        Proyecto proyecto = proyectoRepository.findById(proyectoId)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        List<Tag> tags = tagRepository.findAllById(tagIds);

        for(Tag tag : tags){

            //  si es global → lo asignamos al proyecto
            if(tag.getProyecto() == null){
                tag.setProyecto(proyecto);
            }
            //  si pertenece a otro proyecto
            else if(!tag.getProyecto().getId().equals(proyectoId)){
                throw new RuntimeException("Tag pertenece a otro proyecto");
            }
        }

        tagRepository.saveAll(tags);
    }
    public ProyectoDTO actualizarProyecto(Long id, ProyectoCreateDTO dto) {

        Proyecto proyecto = proyectoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        Usuario usuario = usuarioRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        proyecto.setName(dto.getName());
        proyecto.setDescription(dto.getDescription());
        proyecto.setColor(dto.getColor());
        proyecto.setImage(dto.getImage());
        proyecto.setUsuario(usuario);

        return ProyectoMapper.toDTO(proyectoRepository.save(proyecto));
    }

    public void eliminarProyecto(Long id) {
        Proyecto proyecto = proyectoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));


        for (Tarea tarea : proyecto.getTareas()) {
            if (tarea.getTags() != null) {
                tarea.getTags().clear();
            }
        }

        proyectoRepository.save(proyecto);

        proyectoRepository.delete(proyecto);
    }
}
