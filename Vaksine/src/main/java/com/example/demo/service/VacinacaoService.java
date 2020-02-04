package com.example.demo.service;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Vacinacao;

public interface VacinacaoService {
	
	public Vacinacao efetuarVacinacao(Vacinacao vacinacao);

	Vacinacao efetuarVacinacao(Vacinacao vacinacao, RedirectAttributes ra);
	
}
