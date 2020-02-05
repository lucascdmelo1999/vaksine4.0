package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Vacinacao {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@OneToOne
	private Vacina vacina;

	@DateTimeFormat(pattern="yyyy-MM-dd")	
	private LocalDate dataVacinacao;
	
	private Integer dose;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public LocalDate getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(LocalDate dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}

	public Integer getDose() {
		return dose;
	}

	public void setDose(Integer dose) {
		this.dose = dose;
	}
	
}
