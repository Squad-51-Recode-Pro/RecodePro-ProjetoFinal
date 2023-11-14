package com.jobteens.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobteens.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	Optional<Empresa> findByEmailCoorporativo(String emailCoorporativo);
}
