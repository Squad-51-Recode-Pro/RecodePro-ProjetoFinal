package com.jobteens.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jobteens.controller.EmpresaUserDetailsImpl;
import com.jobteens.model.Empresa;
import com.jobteens.repository.EmpresaRepository;

@Service
public class EmpresaUserDetailsService implements UserDetailsService{


	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public UserDetails loadUserByUsername(String emailCoorporativo) throws UsernameNotFoundException {
		
		Empresa empresa = empresaRepository.findByEmailCoorporativo(emailCoorporativo)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na base de dados"));
		
		return new EmpresaUserDetailsImpl(empresa);
	}
}
