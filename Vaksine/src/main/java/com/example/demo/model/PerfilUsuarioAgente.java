package com.example.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class PerfilUsuarioAgente{

	@Id
	@GeneratedValue
	private String cdUsuario;
	
	private String senha;
	
	private String senha2;
	
	private byte[] foto;
	
	public String getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(String cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
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

}
