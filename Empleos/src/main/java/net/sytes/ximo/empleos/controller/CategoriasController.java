package net.sytes.ximo.empleos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {

	  @GetMapping("/index")
	  public String mostrarIndex(Model model) {
		  return "categorias/listCategorias";
	  }
	  
	  @GetMapping("/create")
	  public String crearIndex(Model model) {
		  return "categorias/formCategorias";
	  }
	  
	  @PostMapping("/save")
	  public String guardarIndex(Model model) {
		  return "categorias/listCategorias";
	  }
}
