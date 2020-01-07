package com.example.demo.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Agente {
	
	@Id
	@GeneratedValue
	private Integer matricula;
	
	private String nome;
	
	private String cpf;
	
	private String rg;
	
	private String email;
	
	private String dataNascimento;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private PerfilSeguranca perfilSeguranca;

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public PerfilSeguranca getPerfilSeguranca() {
		return perfilSeguranca;
	}

	public void setPerfilSeguranca(PerfilSeguranca perfilSeguranca) {
		this.perfilSeguranca = perfilSeguranca;
	}	
}
