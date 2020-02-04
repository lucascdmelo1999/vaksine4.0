package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CartaoVacina {

	@Id
	@GeneratedValue
	private String id;
	
	@OneToMany(mappedBy="cartaoVacina", cascade= {CascadeType.ALL})
	private List<Vacinacao> vacinacao;

	public String getId() {
		return id;
	}

	public void setId(String string) {
		this.id = string;
	}

	public List<Vacinacao> getVacinacao() {
		return vacinacao;
	}

	public void setVacinacao(List<Vacinacao> vacinacao) {
		this.vacinacao = vacinacao;
	}
}
