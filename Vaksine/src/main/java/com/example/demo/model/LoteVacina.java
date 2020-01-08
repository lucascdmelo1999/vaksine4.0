package com.example.demo.model;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class LoteVacina {
	
	@NotBlank(message="Informe a quantidade de vacina")
	private int quantidade;
	
	@GeneratedValue
	private int numeroLote;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate validade;
	
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
	public LocalDate getValidade() {
		return validade;
	}
	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}
	public String getDetalhe() {
		return detalhe;
	}
	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
}
