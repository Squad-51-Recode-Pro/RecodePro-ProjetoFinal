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
public class Empresa {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empresa")
	private int idEmpresa;

	@Column(name = "nome_empresa", nullable = false, length = 80)
	private String nomeEmpresa;

	@Column(name = "email_coorporativo", nullable = false, length = 128, unique = true)
	private String emailCoorporativo;

	@Column(nullable = false, length = 14, unique = true)
	private String cnpj;

	@Column(nullable = false, length = 128)
	private String senha;

	@Column(nullable = false)
	private String endereco;

	@Column(name = "area_atuacao", nullable = false)
	private String areaAtuacao;

	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
	private List<Vagas> Vaga;

	// Construtores
	public Empresa() {
		super();
	}

	public Empresa(int idEmpresa, String nomeEmpresa, String emailCoorporativo, String cnpj, String senha,
			String endereco, String areaAtuacao, List<Vagas> vaga) {
		super();
		this.idEmpresa = idEmpresa;
		this.nomeEmpresa = nomeEmpresa;
		this.emailCoorporativo = emailCoorporativo;
		this.cnpj = cnpj;
		this.senha = senha;
		this.endereco = endereco;
		this.areaAtuacao = areaAtuacao;
		Vaga = vaga;
	}



	// Métodos gets and sets
	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getEmailCoorporativo() {
		return emailCoorporativo;
	}

	public void setEmailCoorporativo(String emailCoorporativo) {
		this.emailCoorporativo = emailCoorporativo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public List<Vagas> getVaga() {
		return Vaga;
	}

	public void setVaga(List<Vagas> vaga) {
		Vaga = vaga;
	}
}
