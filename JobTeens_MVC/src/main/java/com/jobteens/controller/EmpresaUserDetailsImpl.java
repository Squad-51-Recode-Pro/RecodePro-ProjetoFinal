package com.jobteens.controller;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.jobteens.enums.Perfil;
import com.jobteens.model.Empresa;

public class EmpresaUserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Empresa empresa;
	
	public EmpresaUserDetailsImpl(Empresa empresa) {
		this.empresa = empresa;
	}
	
	// Captura nome da empresa logada e exibe no header.html
	public String getNome() {
		return empresa.getNomeEmpresa();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Perfil perfil = empresa.getPerfil();
		return AuthorityUtils.createAuthorityList(perfil.toString());
	}

	@Override
	public String getPassword() {
		return empresa.getSenha();
	}

	@Override
	public String getUsername() {
		return empresa.getEmailCoorporativo();
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

