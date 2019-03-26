package uacm.edu.mx.controller;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uacm.edu.mx.model.Noticia;
import uacm.edu.mx.repository.NoticiaRepository;

@RequestMapping(value = "/api")
@RestController
public class NoticiaController {
	public static final Logger log = LogManager.getLogger(UserController.class);

	@Autowired // INYECCION DE DEPENDENCIAS
	private NoticiaRepository noticiaRepository;
	
	//obtiene el valor por la url 
	@GetMapping(value="/noticia/agregar/{nombreNoticia}")
	//el PathVariable recibe los parametros por la url
	public String addNoticia(@PathVariable String nombreNombre)
	{
		Noticia noticia = new Noticia(nombreNombre, new Date(),"Esta es una nota", "esto es un autor");
		Noticia noticiaReturn = noticiaRepository.save(noticia);
		return "NOTA "+noticiaReturn.getTitulo()+"agregado"; 
	}
	
	@GetMapping(value="/noticia")
	public List<Noticia> allNoticias()
	{
		List<Noticia> noticias = (List<Noticia>) noticiaRepository.findAll();
		return noticias;
	}
}
