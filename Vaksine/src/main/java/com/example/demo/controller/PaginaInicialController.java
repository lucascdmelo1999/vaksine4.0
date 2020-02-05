package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.VacinacaoDAO;
import com.example.demo.model.Vacina;

@Controller
public class PaginaInicialController {
	
	@Autowired
	VacinacaoDAO vacinacaoDAO;
	
	@GetMapping("/paginainicial")
	public String paginainicial() {
		return "index";
	}
	@GetMapping("/cartao")
	public String cartao(Vacina Model model) {
		List<Vacinacao> resultado = this.vacinacaoDAO.findById(Sort.by("id"));
		model.addAttribute("listaVacinas", resultado);
		return "cartao-de-vacina";
	}
	@GetMapping("/confirmacaoEmail")
	public String confirmacaoEmail() {
		return "confirmacao-email";
	}
	
	@GetMapping("/loginusuario")
	public String loginusuario() {
		return "usuario-login";

	}
	@GetMapping("/loginADM")
	public String loginADM() {
		return "loginAdm";

	}
	
	@GetMapping("/loginposto")
	public String loginposto() {
		return "posto-agente-login";
	}


	@GetMapping("/contato")
	public String contato() {
		return "contato";
	}
	
	@GetMapping("/quemsomos")
	public String quemsomos() {
		return"quem-somos";
	}
}
