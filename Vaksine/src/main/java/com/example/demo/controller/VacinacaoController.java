package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Vacinacao;
import com.example.demo.service.VacinacaoService;

@Controller
public class VacinacaoController {
	
	@Autowired
	VacinacaoService vacinacaoService;
	
	@GetMapping("/vacinacao")
	public String exibirFormCartaoVacina() {
		return "form-vacinacao";
	}
	
	@PostMapping("/efetuarvacinacao")
	public String cadastrarCartaoVacina(Vacinacao vacinacao) {
		vacinacaoService.efetuarVacinacao(vacinacao);
		return "cadastro-vacinacao";
	}
}
