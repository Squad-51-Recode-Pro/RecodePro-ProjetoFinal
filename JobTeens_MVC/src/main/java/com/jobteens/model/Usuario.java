package com.jobteens.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int idUsuario;

	@Column(nullable = false, length = 80)
	private String nome;

	@Column(nullable = false, length = 128)
	private String senha;

	@Column(nullable = false, length = 14, unique = true)
	private String cpf;

	@Column(nullable = false, length = 128, unique = true)
	private String email;

	@Column(nullable = false, length = 15)
	private String telefone;

	@Column(nullable = false)
	private String endereco;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
	private List<Candidatura> candidaturas;

	// Construtores
	public Usuario() {
		super();
	}

	public Usuario(int idUsuario, String nome, String senha, String cpf, String email, String telefone,
			String endereco) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.senha = senha;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	// Métodos gets and sets
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int id_usuário) {
		this.idUsuario = id_usuário;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
