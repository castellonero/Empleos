package net.sytes.ximo.empleos.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.sytes.ximo.empleos.model.Categoria;

@Service
public class CategoriasServiceImpl implements ICategoriasService {
    private List<Categoria> lista = null;
    
    public CategoriasServiceImpl() {
		lista = new LinkedList<Categoria>();
			
			// Oferta 1
			Categoria categoria1 = new Categoria();
			categoria1.setId(1);
			categoria1.setNombre("Contabilidad");
			categoria1.setDescripcion("Contable descripc");

			
			// Oferta 2
			Categoria categoria2 = new Categoria();
			categoria2.setId(2);
			categoria2.setNombre("Ventas");
			categoria2.setDescripcion("Vendehumos");
	
			
			// Oferta 3
			Categoria categoria3 = new Categoria();
			categoria3.setId(3);
			categoria3.setNombre("Informatica");
			categoria3.setDescripcion("Descripcion informatica");


			// Oferta 4
			Categoria categoria4 = new Categoria();
			categoria4.setId(1);
			categoria4.setNombre("Politico");
			categoria4.setDescripcion("descripcion Politico");

			
			// Agregamos a Lista.
			lista.add(categoria1);
			lista.add(categoria2);
			lista.add(categoria3);
			lista.add(categoria4);
			
		
    }
    
	@Override
	public List<Categoria> buscarTodas() {
		return lista;
	}

	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for (Categoria v : lista) {
			if (v.getId()==idCategoria) {
				return v;
			}
		}
		return null;
	}

	@Override
	public void guardar(Categoria categoria) {
		lista.add(categoria);
		
	}

	@Override
	public void eliminar(Integer idCategoria) {
		// TODO Auto-generated method stub
		
	}

}