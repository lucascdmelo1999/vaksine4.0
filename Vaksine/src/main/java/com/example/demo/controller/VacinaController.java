package com.example.demo.controller;

import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.VacinaDAO;
import com.example.demo.model.Posto;
import com.example.demo.model.Vacina;
import com.example.demo.service.VacinaService;

@Controller
public class VacinaController {
	
	private String data;  
	Locale locale = new Locale("pt","BR");  
	GregorianCalendar calendar = new GregorianCalendar();  

	@Autowired
	private VacinaDAO vacinaDAO;
	
	@Autowired
	VacinaService vacinaService;
	
	@GetMapping("/vacinaform")
	public String exibirForm(Vacina vacina) {
		return "/cadastro-vacina";
	}
	
	@GetMapping("/editarFormVacina")
	public String editandoVacina(Vacina vacina) {
		return "/editar-vacina";
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
	
	@PostMapping("/pesquisarvacina")
	public String pesquisarvacina(Vacina vacina, Model model) {
		// select nome from vacina where nome LIKE %nome%;
		List<Vacina> resultado = this.vacinaDAO.findByNomeContainingIgnoreCase(vacina.getNome(), Sort.by("nome"));
		model.addAttribute("listaVacinas", resultado);
		return "/buscarvacina";
	}

	@PostMapping("/vacinaCadastro")
	public String cadastrarVacina(Vacina vacina,BindingResult result, RedirectAttributes redirectAttributes, HttpSession session) {
		
		
		
		if (result.hasErrors()) {
			return "redirect:/vacinaform";
		}
		
		try {
			redirectAttributes.addFlashAttribute("message", "vacina cadastrada");
	    	this.vacinaService.cadastrarVacina(session, vacina);
		}catch (Exception e) {
			redirectAttributes.addFlashAttribute("message",e.getMessage());
			System.out.println(e.getMessage());
			return "redirect:/vacinaform";
		}
		
		return "redirect:/vacinalist";
	}
	
	@PostMapping("/vacinaEditar")
	public String editVacina(Vacina vacina,BindingResult result, RedirectAttributes redirectAttributes, HttpSession session) {
		
		
		
		if (result.hasErrors()) {
			return "redirect:/cadastro-vacina";
		}
		
		//se a data for anterior a data atual a vacina não é cadastrada
	    if(!vacina.getLoteVacina().getValidade().isBefore(LocalDate.now().plusMonths(1))) {
			redirectAttributes.addFlashAttribute("messagem", "vacina alterada");
	    	this.vacinaService.cadastrarVacina(session, vacina);
	    }else {
			redirectAttributes.addFlashAttribute("messagem", "dataInvalida");
	    }
		
		return "redirect:/vacinalist";
	}
	

	@GetMapping("/editarvacina")
	public String atualizarVacina(Model model, Integer id) {
		model.addAttribute("vacina", vacinaDAO.findById(id));
		return "/editar-vacina";
	}

	@GetMapping("/deletarvacina")
	public String deletarVacina(Integer id,Vacina vacina, RedirectAttributes ra) {
		ra.addFlashAttribute("messagem", "vacina deletada");
		vacinaDAO.deleteById(id);
		return "redirect:/vacinalist";

	}

	/*
	 * @GetMapping("/listarvacinas") public String listarVacinas(Model model) {
	 * model.addAttribute("listaVacinas",this.vacinaDAO.findAll(Sort.by("id")));
	 * return "redirect:/vacinalist"; }
	 */
}
