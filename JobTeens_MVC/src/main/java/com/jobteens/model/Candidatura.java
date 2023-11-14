package com.jobteens.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Candidatura {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_candidatura")
	private Long idCandidatura;

	@CreationTimestamp
	@Column(name = "data_candidatura")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataCandidatura;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id_fk", nullable = false)
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vagas_id_fk", nullable = false)
	private Vagas vagas;

	// Construtores
	public Candidatura() {
		super();
	}

	public Candidatura(Long idCandidatura, LocalDate dataCandidatura, Usuario usuario, Vagas vagas) {
		super();
		this.idCandidatura = idCandidatura;
		this.dataCandidatura = dataCandidatura;
		this.usuario = usuario;
		this.vagas = vagas;
	}

	public Long getIdCandidatura() {
		return idCandidatura;
	}

	public void setIdCandidatura(Long idCandidatura) {
		this.idCandidatura = idCandidatura;
	}

	public LocalDate getDataCandidatura() {
		return dataCandidatura;
	}

	public void setDataCandidatura(LocalDate dataCandidatura) {
		this.dataCandidatura = dataCandidatura;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vagas getVagas() {
		return vagas;
	}

	public void setVagas(Vagas vagas) {
		this.vagas = vagas;
	}
}
