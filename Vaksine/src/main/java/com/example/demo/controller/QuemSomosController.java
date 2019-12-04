package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuemSomosController {

	@GetMapping("/quemsomos")
	public String quemsomos() {
		return"quem-somos";
	}
}
