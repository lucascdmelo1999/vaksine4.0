package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Posto {
	
	@Id 
	@GeneratedValue 
	private Integer id;
	
	@NotBlank(message = "")
	private String nomePosto;
	
	@NotBlank(message = "")
	private String email;
	
	@NotBlank(message = "")
	private String telefone;
	
	@NotBlank(message = "")
	private String endereco;
	
	@NotNull
	private String codigo;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private PerfilUsuarioPosto perfilUsuarioPosto;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomePosto() {
		return nomePosto;
	}
	public void setNomePosto(String nomedoposto) {
		this.nomePosto = nomedoposto;
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
	public PerfilUsuarioPosto getPerfilUsuarioPosto() {
		return perfilUsuarioPosto;
	}
	public void setPerfilUsuarioPosto(PerfilUsuarioPosto perfilUsuarioPosto) {
		this.perfilUsuarioPosto = perfilUsuarioPosto;
	}
}
