package com.tareas.demo;

import com.tareas.demo.entity.Tarea;
import com.tareas.demo.entity.Usuario;
import com.tareas.demo.repository.TareaRepository;
import com.tareas.demo.repository.UsuarioRepository;
import com.tareas.demo.service.TareaService;
import com.tareas.demo.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TareaRepository tareaRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private TareaService tareaService;

	@Test
	void contextLoads() {
	}

	@Test
	void guardarUsuarioYTarea() {

		// 1. Crear usuario
		Usuario usuario = new Usuario();
		usuario.setNombre("Vladimir");
		usuario.setEmail("vladimir@gmail.com");

		usuario = usuarioRepository.save(usuario);

		// 2. Crear tarea
		Tarea tarea = new Tarea();
		tarea.setTitulo("Test tarea");
		tarea.setDescripcion("Probando test");

		tarea.setUsuario(usuario);

		tarea = tareaRepository.save(tarea);

		// 3. Verificar (simple)
		System.out.println("Usuario ID: " + usuario.getId());
		System.out.println("Tarea ID: " + tarea.getId());
		System.out.println("Usuario de la tarea: " + tarea.getUsuario().getNombre());
	}

	@Test
	void actualizarUsuario(){
		//Crear objeto nuevo
		Usuario usuarioNuevo = new Usuario();
		usuarioNuevo.setNombre("Pepito");
		usuarioNuevo.setEmail("Pepito@gmail.com");

		//Modificar llamando service
		Usuario resultado = usuarioService.actualizarUsuario(3,usuarioNuevo);

		System.out.println("Usuario acualizado : " +resultado.getNombre()+"-"+resultado.getEmail());

	}

	@Test
	void creandoTareas(){
		//obtener usuario
		Usuario u  = usuarioService.usuarioPorId(1);
		//crear tareas
		for (int i = 1; i <= 3; i++) {
			Tarea tarea = new Tarea();
			tarea.setTitulo("Tarea " + i);
			tarea.setDescripcion("Descripcion " + i);
			tarea.setUsuario(u);

			tareaService.guardarTarea(tarea);
		}
		System.out.println("LISTA DE TAREAS CREADAS PARA "+u.getNombre());
	}
	@Test
	void eliminarUsuarioPepito(){
		usuarioRepository.deleteById(3);

	}
	@Test
	void tareasDeUsuario(){
		Usuario u = usuarioService.usuarioPorId(2);
		List<Tarea> tareas = tareaRepository.findByUsuarioId(u.getId());

		// Verificar que tenga 3 tareas
		assertEquals(1, tareas.size());

		System.out.println(u.getNombre()+" tiene " + tareas.size() + " tareas");
		tareas.forEach(t->{
			System.out.println(t.getTitulo()+"-"+t.getUsuario().getNombre());
				});


	}
}
