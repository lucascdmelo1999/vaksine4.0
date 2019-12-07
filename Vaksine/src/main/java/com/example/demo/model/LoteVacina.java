package com.example.demo.model;

import java.util.Calendar;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Embeddable
public class LoteVacina {
	
	@NotBlank(message="Informe a quantidade de vacina")
	private int quantidade;
	
	@GeneratedValue
	private int numeroLote;
	
	@NotNull(message = "Informe a data de validade")
	private Calendar validade;
	
	@NotBlank(message="")
	private String detalhe;
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getNumeroLote() {
		return numeroLote;
	}
	public void setNumeroLote(int numeroLote) {
		this.numeroLote = numeroLote;
	}
	public Calendar getValidade() {
		return validade;
	}
	public void setValidade(Calendar validade) {
		this.validade = validade;
	}
	public String getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
}
