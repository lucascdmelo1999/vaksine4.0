package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String nomeMae;
	private String nomePai;
	private String dataNas;
	private String cpf;
	private String tipoSanguineo;
	private String email;
	private String telefone;
	private String endereco;
	private String senha;
	private String token;
	private int ativo=0;
	
	@OneToMany(mappedBy="usuario", cascade= {CascadeType.ALL})
	private List<Vacinacao> vacinacao;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getDataNas() {
		return dataNas;
	}
	public void setDataNas(String dataNas) {
		this.dataNas = dataNas;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTipoSanguineo() {
		return tipoSanguineo;
	}
	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getAtivo() {
		return ativo;
	}
	public void setAtivo(int ativo) {
		this.ativo = 1;
	}
	public List<Vacinacao> getVacinacao() {
		return vacinacao;
	}
	public void setVacinacao(List<Vacinacao> vacinacao) {
		this.vacinacao = vacinacao;
	}

}
