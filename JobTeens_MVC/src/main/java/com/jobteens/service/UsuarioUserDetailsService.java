package com.jobteens.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jobteens.controller.UsuarioUserDetailsImpl;
import com.jobteens.model.Usuario;
import com.jobteens.repository.UsuarioRepository;

@Service
public class UsuarioUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na base de dados"));
		
		return new UsuarioUserDetailsImpl(usuario);
	}
}
