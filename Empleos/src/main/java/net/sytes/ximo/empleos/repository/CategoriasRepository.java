package net.sytes.ximo.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.sytes.ximo.empleos.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
