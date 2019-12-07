package com.example.demo.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Agente {
	
	@Id
	@GeneratedValue
	private Integer matricula;
	
	@NotBlank(message="O campo Nome precisa ser preenchido")
	private String nome;
	
	@NotBlank(message="O campo CPF precisa ser preenchido")
	private String cpf;
	
	@NotBlank(message="O campo Rg precisa ser preenchido")
	private String rg;
	
	@NotBlank(message="O campo Email precisa ser preenchido")
	private String email;
	
	@NotNull(message="O campo Data de nascimento precisa ser preenchido")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataNascimento;
	
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
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
