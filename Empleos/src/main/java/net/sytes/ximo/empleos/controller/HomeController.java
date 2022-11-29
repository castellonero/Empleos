package net.sytes.ximo.empleos.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.sytes.ximo.empleos.model.Vacante;
import net.sytes.ximo.empleos.service.IVacantesService;



@Controller
public class HomeController {
	
	@Autowired
	private IVacantesService serviceVacantes;
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = serviceVacantes.buscartodas();
		model.addAttribute("vacantes", lista);
		return "tabla";
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model modelo) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de comunicaciones");
		vacante.setDescripcion("Se solicita comunicador");
		vacante.setFecha(new Date());
		vacante.setSalario(2500.5);
		
		modelo.addAttribute(vacante);
		return "detalle";
		
	}

	@GetMapping("/listado")
	public String mostrarLista(Model modelo) {
		
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero informatico");
		lista.add("Ingeniero astronauta");
		lista.add("Auxiliar administrativo");
		lista.add("Programador informatico");
		
		modelo.addAttribute("empleos", lista);
				
		return "listado";
	}
	@GetMapping
	public String mostrarHome(Model model) {
		List<Vacante> lista = serviceVacantes.buscartodas();
		model.addAttribute("vacantes", lista);

		return "home";
	}
	
}
