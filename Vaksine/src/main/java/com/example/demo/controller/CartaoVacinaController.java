package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.VacinaUsuario;
import com.example.demo.service.VacinaUsuarioService;

@Controller
public class CartaoVacinaController {
	
	@Autowired
	VacinaUsuarioService cartaoVacinaService;
	
	@GetMapping("/cartaovacina")
	public String exibirFormCartaoVacina() {
		return "form-cartao";
	}
	
	@PostMapping("/cadastrarcartao")
	public String cadastrarCartaoVacina(VacinaUsuario cartao) {
		cartaoVacinaService.cadastrarCartao(cartao);
		return "cadastro-cartao";
	}
}
