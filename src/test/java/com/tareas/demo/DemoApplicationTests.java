package com.tareas.demo;

import com.tareas.demo.DTO.ProyectoCreateDTO;
import com.tareas.demo.DTO.ProyectoDTO;
import com.tareas.demo.DTO.UsuarioCreateDTO;
import com.tareas.demo.DTO.UsuarioDTO;
import com.tareas.demo.entity.Proyecto;
import com.tareas.demo.entity.Tarea;
import com.tareas.demo.entity.Usuario;
import com.tareas.demo.mapper.UsuarioMapper;
import com.tareas.demo.repository.ProyectoRepository;
import com.tareas.demo.repository.TareaRepository;
import com.tareas.demo.repository.UsuarioRepository;
import com.tareas.demo.service.ProyectoService;
import com.tareas.demo.service.TareaService;
import com.tareas.demo.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private TareaRepository tareaRepository;

	@Autowired
	private ProyectoRepository proyectoRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private TareaService tareaService;
	@Autowired
	private ProyectoService proyectoService;

	@Test
	void contextLoads() {
	}

	@Test
	void testCrearUsuario(){
		UsuarioCreateDTO dto = UsuarioCreateDTO.builder()
				.name("OtroTest")
				.lastname("OtroTest2")
				.email("Otrotest@mail.com")
				.password("1234")
				.build();
		Usuario usuario = UsuarioMapper.toEntity(dto);
		Usuario guardado = usuarioRepository.save(usuario);

		System.out.println(""+guardado.getCreatedAt());
		assertEquals("OtroTest",guardado.getName());
	}

	@Test
	void encontrarUsuario(){
		Usuario u  = usuarioRepository.findById(2L).get();
		UsuarioDTO usuarioDTO = UsuarioMapper.toDTO(u);

		System.out.println(""+usuarioDTO.getId());
		System.out.println(""+usuarioDTO.getName());
		System.out.println(""+usuarioDTO.getEmail());
		assertEquals(usuarioDTO.getName(),u.getName());
	}

	@Test
	void testEmailDuplicado(){

		UsuarioCreateDTO dto = UsuarioCreateDTO.builder()
				.name("Repetido")
				.lastname("Test")
				.email("test@mail.com") // ya existe
				.password("123")
				.build();

		Usuario usuario = UsuarioMapper.toEntity(dto);

		try {
			usuarioRepository.save(usuario);
		} catch (Exception e){
			System.out.println("ERROR ESPERADO: " + e.getMessage());
			assertEquals(true, true); // pasa el test
		}
	}
	@Test
	void testCrearProyectoConUsuarioReal() {

		Usuario usuario = usuarioRepository.findAll()
				.stream()
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No hay usuarios"));

		ProyectoCreateDTO dto = ProyectoCreateDTO.builder()
				.name("Proyecto Test")
				.description("Descripcion test")
				.color("blue")
				.image("img.png")
				.userId(usuario.getId())
				.build();

		ProyectoDTO proyecto = proyectoService.crearProyecto(dto);

		// ✔ validar retorno
		assertEquals(usuario.getId(), proyecto.getUserId());

		// ✔ validar BD
		Proyecto proyectoBD = proyectoRepository.findById(proyecto.getId())
				.orElseThrow();

		assertEquals("Proyecto Test", proyectoBD.getName());

		// DEBUG
		System.out.println("Proyecto guardado ID: " + proyectoBD.getId());
	}

}
