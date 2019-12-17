package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.VacinaDAO;
import com.example.demo.model.Vacina;

@Controller
public class VacinaController {

	@Autowired
	private VacinaDAO vacinaDAO;
	
	@GetMapping("/vacinaform")
	public String exibirForm(Vacina vacina) {
		return "/cadastro-vacina";
	}
	
	@GetMapping("/vacinacaoDeletar")
	public String vacinacaoDeletar(Vacina vacina) {
		return "/vacinacao-deletar";
	}

	@GetMapping("/vacinalist")
	public String listarVacina(Vacina vacina, Model model) {
		model.addAttribute("listaVacinas",this.vacinaDAO.findAll(Sort.by("id")));
		return "/lista-vacina2";
	}

	@GetMapping("/vacinabuscar")
	public String buscarvacina(Vacina vacina, Model model) {
		model.addAttribute("vacina", vacinaDAO.findAll());
		return "redirect:/vacinalist";
	}

	@PostMapping("/vacinaCadastro")
	public String cadastrarVacina(Vacina vacina) {
		this.vacinaDAO.save(vacina); 
		return "redirect:/vacinalist";
	}

	@GetMapping("/editarvacina")
	public String atualizarVacina(Model model, Integer id) {
		model.addAttribute("vacina", vacinaDAO.findById(id));
		return "/cadastro-vacina";
	}

	@GetMapping("/deletarvacina")
	public String deletarVacina(Integer id) {
		vacinaDAO.deleteById(id);
		return "redirect:/vacinalist";

	}
	
	
	
	
	
	
/*
	@GetMapping("/listarvacinas")
	public String listarVacinas(Model model) {
		model.addAttribute("listaVacinas",this.vacinaDAO.findAll(Sort.by("id")));
		return "redirect:/vacinalist";
	}*/
}
