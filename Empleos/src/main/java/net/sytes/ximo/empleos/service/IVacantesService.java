package net.sytes.ximo.empleos.service;

import java.util.List;

import net.sytes.ximo.empleos.model.Vacante;

public interface IVacantesService {
	List<Vacante> buscartodas();
	List<Vacante> buscarDestacadas();
	Vacante buscarPorId(Integer idVacante);
	void guardar(Vacante vacante);
	void eliminar(Integer idVacante);
	
     
}
