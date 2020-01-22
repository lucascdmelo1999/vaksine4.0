package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CartaoVacina {

	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne
	private Usuario usuario;
	
	@OneToMany
	private List<Vacina> vacina;

	private LocalDate dataVacinacao;

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

	public List<Vacina> getVacina() {
		return vacina;
	}

	public void setVacina(List<Vacina> vacina) {
		this.vacina = vacina;
	}

	public LocalDate getDataVacinacao() {
		return dataVacinacao;
	}

	public void setDataVacinacao(LocalDate dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}
}
