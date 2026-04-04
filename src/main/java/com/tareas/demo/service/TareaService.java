package com.tareas.demo.service;

import com.tareas.demo.entity.Tarea;
import com.tareas.demo.entity.Usuario;
import com.tareas.demo.repository.TareaRepository;
import com.tareas.demo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TareaService {
    private final UsuarioRepository usuariorepo;
    private final TareaRepository tarearepo;

    //listar tareas
    public List<Tarea> listarTarea(){
        return tarearepo.findAll();
    }

    //obtener tarea por ID
    public Tarea tareaPorId(Integer id){
        return tarearepo.findById(id).orElseThrow(()-> new RuntimeException("Tarea no encontrada"));
    }

    //crear tarea asignada a usuario
    public Tarea guardarTarea(Tarea tarea){
        Integer usuarioId = tarea.getUsuario().getId();
        Usuario usuario = usuariorepo.findById(usuarioId).orElseThrow(()->new RuntimeException("Usuario no existe"));
        tarea.setUsuario(usuario);
        return tarearepo.save(tarea);
    }

    //actualizar tarea
    public Tarea actualizarTarea(Integer id , Tarea t){
        Tarea tarea = tareaPorId(id);
        tarea.setTitulo(t.getTitulo());
        tarea.setDescripcion(t.getDescripcion());

        if(t.getUsuario() != null){
            Integer usuarioId =  t.getUsuario().getId();
            Usuario usuario = usuariorepo.findById(usuarioId)
                    .orElseThrow(()->new RuntimeException("Usuario no existe"));
            tarea.setUsuario(usuario);
        }
        return tarearepo.save(tarea);
    }

    //eliminar tarea
    public void eliminarTarea(Integer id){
        tarearepo.deleteById(id);
    }

    //tarea por usuario
    public List<Tarea> tareasPorUsuario(Integer id){
        usuariorepo.findById(id).orElseThrow(()-> new RuntimeException("Usuario no existe"));
        return tarearepo.findByUsuarioId(id);
    }
}
