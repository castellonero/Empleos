package net.sytes.ximo.empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.sytes.ximo.empleos.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
