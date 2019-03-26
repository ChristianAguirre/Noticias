package uacm.edu.mx.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.model.Usuario;
import uacm.edu.mx.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/api")
public class UserController {

	public static final Logger log = LogManager.getLogger(UserController.class);

	@Autowired // INYECCION DE DEPENDENCIAS
	private UsuarioRepository usuarioRepository;

	@GetMapping(value = "/usuario/agregar/{nombre}/{apellidoP}")
	public String agregarUsuario(@PathVariable String nombre, @PathVariable String apellidoP) {
		log.debug("_______________________________________________________");
		log.debug("-CON----------------- Entrando al metodo agregarUsuario");
		Usuario usuario = new Usuario(nombre, apellidoP, "hernandez", "ascencio847@gmail.com", "1234", "teemoo66");
		Usuario usuarioRetorn = usuarioRepository.save(usuario);
		return "Usuario " + usuarioRetorn.getNombre() + " agregado";
	}

	/*
	@GetMapping(value = "/usuario")
	public Usuario darUsuario() {
		Usuario usuario = new Usuario();
		usuario.setApellidoM("lucas");
		usuario.setNombre("Ixchel");
		usuario.setApellidoP("Lopez");
		usuario.setApellidoM("Perez");
		usuario.setCorreo("ixchel@hotmail.com");
		usuario.setNickname("amiguito");
		return usuario;
	}*/
	@GetMapping()
	public Usuario getUsuario(@PathVariable String id)
	{
		
		Usuario usuarioReturn = usuarioRepository.byId_usuario(Long.parseLong(id));
		return usuarioReturn;
		
	}
	@GetMapping(value = "/usuario")
	public List<Usuario> todosUsuario() {
		log.debug("_______________________________________________________");
		log.debug("-CON----------------- Entrando al metodo todosUsuario");
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@PostMapping(value = "/usuario")
	public String addUsuario() {
		return "agregado";
	}

}
