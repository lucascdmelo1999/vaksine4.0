package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.VacinaDAO;
import com.example.demo.dao.VacinacaoDAO;
import com.example.demo.model.Vacinacao;
import com.example.demo.service.VacinacaoService;

@Controller
public class VacinacaoController {
	
	@Autowired
	VacinacaoService vacinacaoService;
	
	@Autowired
	VacinaDAO vacinaDAO;
	
	@Autowired
	VacinacaoDAO vacinacaoDAO;
	
	@GetMapping("/vacinacao")
	public String exibirFormCartaoVacina(Vacinacao vacinacao,Model model) {
		model.addAttribute("listaVacinas", this.vacinaDAO.findAll(Sort.by("id")));
		return "cadastro-vacinacao";
	}
	
	@PostMapping("/vacinacaoCadastro")
	public String cadastrarVacinacao(Vacinacao vacinacao) {
		vacinacaoService.efetuarVacinacao(vacinacao);
		return "cadastro-vacinacao";
	}
	
//	@PostMapping("/vacinacaoCadastro")
//	public String vacinacaoCadastro(Vacinacao vacinacao,BindingResult result, RedirectAttributes ra) {
//		
//		
//		
//		if (result.hasErrors()) {
//	    	System.out.println(result);
//			return "redirect:/vacinacao";
//		}
//		
//		
//		//se a data for anterior a data atual a vacina não é cadastrada
//	    if(!vacinacao.getVacina().getLoteVacina().getValidade().isBefore(LocalDate.now())) {
//			ra.addFlashAttribute("message", "usuario Vacinado");
//			this.vacinacaoDAO.save(vacinacao);
//			System.out.println("usuario vacinado");
//	    }else {			
//	    	
//	    	System.out.println("error");
//			ra.addFlashAttribute("message", "dataInvalida");
//	    }
//		
//		return "redirect:/vacina";
//	}
}
