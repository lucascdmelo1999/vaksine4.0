package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Posto {
	
	@Id @GeneratedValue 
	@NotBlank
	private Integer id;
	@NotBlank (message = "Campo vazio")
	@Column(length = 50)
	private String nomedoposto;
	@NotBlank (message = "Campo vazio")
	@Column(length = 35)
	private String email;
	@NotBlank (message = "Campo vazio")
	@Column(length = 14)
	private String telefone;
	@NotBlank (message = "Campo vazio")
	@Column(length = 255)
	private String endereco;
	@NotBlank (message = "Campo vazio")
	@Column(length = 6)
	private String senha;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomedoposto() {
		return nomedoposto;
	}
	public void setNomedoposto(String nomedoposto) {
		this.nomedoposto = nomedoposto;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
