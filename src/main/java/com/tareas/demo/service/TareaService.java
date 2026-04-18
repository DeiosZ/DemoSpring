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

}
