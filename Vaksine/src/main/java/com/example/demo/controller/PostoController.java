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

	@GetMapping("/cadastroposto")
	public String cadastroposto(Posto posto) {
		return "cadastro-posto";
	}

	@PostMapping("/salvarposto")
	public String salvarposto(Posto posto) {

		this.postoService.save(posto);
		return "redirect:/paginainicial";
	}

}
