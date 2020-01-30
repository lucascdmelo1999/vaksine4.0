package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Posto {
	
	@Id 
	@GeneratedValue 
	private Integer id;
	
	private String nomePosto;
	
	private String email;
	
	private String telefone;
	
	private String endereco;
	
	private String codigoPosto;
	
	private String senha;
	
	private String codigoUsuario;
	
	@OneToMany
	private List<Vacina> vacina;
	
	
	public String getCodigoPosto() {
		return codigoPosto;
	}
	
	public void setCodigoPosto(String codigo) {
		this.codigoPosto = codigo;
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
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public List<Vacina> getVacina() {
		return vacina;
	}

	public void setVacina(List<Vacina> vacina) {
		this.vacina = vacina;
	}
	
}
