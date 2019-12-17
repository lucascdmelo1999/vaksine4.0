package com.example.demo.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Posto;
import com.example.demo.service.PostoService;

@Controller
public class PostoController {
	
	@Inject
	PostoService postoService;
	
	@GetMapping("/loginPostoAgente")
	public String loginPostoAgente(Posto posto) {
		return "posto-agente-login";
	}

	@GetMapping("/cadastroposto")
	public String formCadastro(Posto posto) {
		return "cadastro-posto";
	}

	@PostMapping("/salvarposto")
	public String cadastrarPosto(Posto posto) {

		this.postoService.cadastrarPosto(posto);
		return "redirect:/paginainicial";
	}

}
