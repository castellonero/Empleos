package net.sytes.ximo.empleos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.sytes.ximo.empleos.model.Categoria;
import net.sytes.ximo.empleos.service.ICategoriasService;

@Controller
@RequestMapping(value="/categorias")
public class CategoriasController {

	@Autowired
	private ICategoriasService serviceCategorias;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model)  {
		List<Categoria> categorias=serviceCategorias.buscarTodas();
		model.addAttribute("categorias", categorias);

		return "categorias/listCategorias";
	
	}
	  
	@GetMapping("/create")
	public String crear(Categoria categoria, Model model) {
		model.addAttribute("categoria", categoria);
		return "categorias/formCategoria";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idCategoria,Model model)  {
		Categoria categoria = serviceCategorias.buscarPorId(idCategoria);
		model.addAttribute("categoria", categoria);
		return "/categorias/formCategoria";
	
	}
		
	  
	@PostMapping("/save")
	public String guardar(Categoria categoria, BindingResult result,  RedirectAttributes attributes)  {
		if (result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
			System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return "categorias/formCategoria";
		}
		System.out.println("Categoria: " + categoria );
		serviceCategorias.guardar(categoria);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		return "redirect:/categorias/index";
	
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idCategoria, Model model,  RedirectAttributes attributes)  {
		System.out.println("Borrando categoria con ID: " + idCategoria);
	    serviceCategorias.eliminar(idCategoria);
		attributes.addFlashAttribute("msg", "La categoria se ha eliminado");
		return "redirect:/categorias/index";
	}
	
	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idCategoria, Model model)  {
		Categoria categoria = serviceCategorias.buscarPorId(idCategoria);
		System.out.println("Categoria: " + categoria);	
		model.addAttribute("categoria", categoria);	
		return "detalle";
   }
}
