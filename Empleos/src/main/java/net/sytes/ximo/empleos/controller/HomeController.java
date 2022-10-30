package net.sytes.ximo.empleos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.sytes.ximo.empleos.model.Vacante;



@Controller
public class HomeController {
	
	@GetMapping("/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> lista = getVacantes();
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
	public String mostrarHome(Model modelo) {

		modelo.addAttribute("mensaje","asdfadfasdf");
		modelo.addAttribute("fecha",new Date());
		return "home";
	}
	
	private List<Vacante> getVacantes() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> lista = new LinkedList<Vacante>();
		try {
			
			// Oferta 1
			Vacante vacante1 = new Vacante();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("Solicitamos Ingeniero civil");
			vacante1.setFecha(sdf.parse("08-02-2021"));
			vacante1.setSalario(8500.3);
			vacante1.setDestacado(1);
			vacante1.setImagen("empresa1.png");
			
			// Oferta 2
			Vacante vacante2 = new Vacante();
			vacante2.setId(2);
			vacante2.setNombre("Ingeniero Militar");
			vacante2.setDescripcion("Solicitamos Ingeniero Militar");
			vacante2.setFecha(sdf.parse("08-02-2021"));
			vacante2.setSalario(8000.3);
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.png");
			
			// Oferta 3
			Vacante vacante3 = new Vacante();
			vacante3.setId(3);
			vacante3.setNombre("Programador");
			vacante3.setDescripcion("Solicitamos Programador");
			vacante3.setFecha(sdf.parse("08-02-2022"));
			vacante3.setSalario(6500.3);
			vacante3.setDestacado(0);

			// Oferta 4
			Vacante vacante4 = new Vacante();
			vacante4.setId(1);
			vacante4.setNombre("Albañil");
			vacante4.setDescripcion("Solicitamos Albañil");
			vacante4.setFecha(sdf.parse("30-03-2022"));
			vacante4.setSalario(3500.3);
			vacante4.setDestacado(1);
			vacante4.setImagen("empresa4.png");
			
			// Agregamos a Lista.
			lista.add(vacante1);
			lista.add(vacante2);
			lista.add(vacante3);
			lista.add(vacante4);
			
		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
			
		}
		return lista;
	}
}
