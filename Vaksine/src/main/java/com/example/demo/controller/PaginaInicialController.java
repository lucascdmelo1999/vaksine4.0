package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaInicialController {

	@GetMapping("/paginainicial")
	public String paginainicial() {
		return "index";
	}

	@GetMapping("/loginusuario")
	public String loginusuario() {
		return "usuario-login";

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
