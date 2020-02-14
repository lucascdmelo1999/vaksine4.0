package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Vacina {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	
	@OneToOne
	Posto posto;
	
	@Embedded
	private LoteVacina loteVacina;	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LoteVacina getLoteVacina() {
		return loteVacina;
	}
	public void setLoteVacina(LoteVacina loteVacina) {
		this.loteVacina = loteVacina;
	}
	
	public Posto getPosto() {
		return posto;
	}
	public void setPosto(Posto posto) {
		this.posto = posto;
	}
}
