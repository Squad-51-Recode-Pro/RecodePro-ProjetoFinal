package com.jobteens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobteens.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
