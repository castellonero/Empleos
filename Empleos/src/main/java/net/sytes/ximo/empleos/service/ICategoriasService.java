package net.sytes.ximo.empleos.service;

import java.util.List;

import net.sytes.ximo.empleos.model.Categoria;

public interface ICategoriasService {

		List<Categoria> buscarTodas();
		Categoria buscarPorId(Integer idCategoria);	
		void guardar(Categoria Categoria);

	}

