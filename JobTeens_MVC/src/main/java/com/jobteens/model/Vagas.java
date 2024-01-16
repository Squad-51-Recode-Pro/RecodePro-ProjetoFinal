package com.jobteens.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Vagas {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vagas")
	private Long idVagas;

	@Column(nullable = false)
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	private BigDecimal salario;

	@Column(nullable = false)
	private String requisitos;

	@Column(nullable = false)
	private String descricao;

	@Column(name = "titulo_vaga", nullable = false)
	private String tituloVaga;

	@CreationTimestamp
	@Column(name = "data_publicacao")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataPublicacao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "empresa_id_fk", nullable = false)
	private Empresa empresa;

	@OneToMany(mappedBy = "vagas", fetch = FetchType.LAZY)
	private List<Candidatura> candidaturas;

	// Construtores
	public Vagas() {
		super();
	}

	public Vagas(Long idVagas, BigDecimal salario, String requisitos, String descricao, String tituloVaga,
			LocalDate dataPublicacao, Empresa empresa, List<Candidatura> candidaturas) {
		super();
		this.idVagas = idVagas;
		this.salario = salario;
		this.requisitos = requisitos;
		this.descricao = descricao;
		this.tituloVaga = tituloVaga;
		this.dataPublicacao = dataPublicacao;
		this.empresa = empresa;
		this.candidaturas = candidaturas;
	}

	// Métodos gets and sets
	public Long getIdVagas() {
		return idVagas;
	}

	public void setIdVagas(Long idVagas) {
		this.idVagas = idVagas;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTituloVaga() {
		return tituloVaga;
	}

	public void setTituloVaga(String tituloVaga) {
		this.tituloVaga = tituloVaga;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Candidatura> getCandidaturas() {
		return candidaturas;
	}

	public void setCandidaturas(List<Candidatura> candidaturas) {
		this.candidaturas = candidaturas;
	}
}
