package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.VacinaDAO;
import com.example.demo.model.Usuario;
import com.example.demo.model.Vacina;

@Controller
public class VacinaController {
	
	@Autowired
	private VacinaDAO vacinaDAO;
	
	@GetMapping("/vacinaform")
	public String exibirForm(Vacina vacina) {
		return "cadastro-vacina";
	}
	
	@PostMapping("/cadastrarvacina")
	public String cadastrarVacina(Vacina vacina, Model model) {
		model.addAttribute("vacina", vacina);
		vacinaDAO.save(vacina);
		return "cadastro-vacina";
	}
	
	@GetMapping("/editarvacina")
	public String atualizarVacina(@ Valid BindingResult atributes, Model model, Integer id) {
		model.addAttribute("listaDados", vacinaDAO.findById(id));
		return "vacina-form";
	}
	
	@GetMapping("/deletarvacina")
	public String deletarVacina(Integer id) {
		vacinaDAO.deleteById(id);
		return "redirect:/listarVacina";
	}
	
	@GetMapping("/listarvacinas")
	public String listarVacinas(Model model) {
		model.addAttribute("listaVacinas", vacinaDAO.findAll());
		return "lista-vacinas";
	}
}
