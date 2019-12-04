package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GerenciarVacinaController {

	@GetMapping("/gerenciarvacina")
	public String gerenciarvacina() {
		return"gerenciar-vacina";
	}
}
