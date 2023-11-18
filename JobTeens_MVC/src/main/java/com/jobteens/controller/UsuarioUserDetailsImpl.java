package com.jobteens.controller;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jobteens.model.Usuario;

public class UsuarioUserDetailsImpl implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	
	public UsuarioUserDetailsImpl(Usuario usuario) {
		this.usuario = usuario;
	}

	// Captura nome do usuário logado e exibe no header.html
	public String getNome() {
		return usuario.getNome();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return usuario.getSenha();
	}

	@Override
	public String getUsername() {
		return usuario.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
