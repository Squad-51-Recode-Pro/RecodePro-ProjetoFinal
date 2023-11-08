package com.jobteens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobteens.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
