package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PerfilSeguranca{
	
	@Id
	private String login;
	
	private String codUsuario;
	
	private String senha;
	
	private String senha2;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha2() {
		return senha2;
	}

	public void setSenha2(String senha2) {
		this.senha2 = senha2;
	}

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

}
