package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("listaVacinas", this.vacinaDAO.findAll(Sort.by("id")));
		return "/lista-vacina";
	}
	
	
	@GetMapping("/buscandovacina") 
	public String buscandoVacina(Vacina vacina, Model model) {
		model.addAttribute("listaVacinas", this.vacinaDAO.findAll(Sort.by("id")));
			return "buscarvacina";
	}	
	
	@PostMapping("/pesquisarvacina")
	public String pesquisarvacina(Vacina vacina, Model model) {
										// select nome from vacina where nome LIKE %nome%;
		List<Vacina> resultado = this.vacinaDAO.findByNomeContainingIgnoreCase(vacina.getNome(), Sort.by("nome"));
		model.addAttribute("listaVacinas", resultado);
		return "/buscarvacina";
	}

	@PostMapping("/vacinaCadastro")
	public String cadastrarVacina(Vacina vacina,BindingResult result, RedirectAttributes redirectAttributes) {
		
		this.vacinaDAO.save(vacina);
		
		if (result.hasErrors()) {
			return "redirect:/cadUsuario";
		}
		redirectAttributes.addFlashAttribute("message", "vacina cadastrada");
		
		return "redirect:/vacinaform";
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
	 * @GetMapping("/listarvacinas") public String listarVacinas(Model model) {
	 * model.addAttribute("listaVacinas",this.vacinaDAO.findAll(Sort.by("id")));
	 * return "redirect:/vacinalist"; }
	 */
}
