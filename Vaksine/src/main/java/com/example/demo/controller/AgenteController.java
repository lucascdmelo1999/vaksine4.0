package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dao.AgenteDAO;
import com.example.demo.model.Agente;
import com.example.demo.model.Posto;

@Controller
public class AgenteController {
	
	@Autowired
	private AgenteDAO agenteDAO;
	
	
	@RequestMapping(value = "/formagente", method = RequestMethod.GET)
	public String exibirCadastroAgente() {
		return "cadastro-agente";
	}
	
	@RequestMapping(value = "/cadastroagente", method = RequestMethod.POST)
	public String cadastrarAgente(Agente agente) {
		agenteDAO.save(agente);
		return "cadastro-agente";
	}
	

}
