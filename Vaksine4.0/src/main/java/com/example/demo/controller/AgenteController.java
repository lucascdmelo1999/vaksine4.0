package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgenteController {

	
	@GetMapping("/cad")
	public String cadastroagente() {
		return"contato";
	}
}
