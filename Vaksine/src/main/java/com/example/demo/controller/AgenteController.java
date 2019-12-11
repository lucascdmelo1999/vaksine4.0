package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.AgenteDAO;
import com.example.demo.model.Agente;

@Controller
public class AgenteController {
	
	@Autowired
	private AgenteDAO agenteDAO;
	
	@GetMapping("/ind-agente")
	public String agente (Agente agente) {
		return "/agente";
	}
	
	
	
	@GetMapping("/cadAgente")
	public String exibirCadastroAgente(Agente agente) {
		return "cadastro-agente";
	}
	
	@PostMapping("/cadastroAgente")
	public String cadastrarAgente(Agente agente) {
		agenteDAO.save(agente);
		return "redirect:/cadAgente";
	}
	

}
