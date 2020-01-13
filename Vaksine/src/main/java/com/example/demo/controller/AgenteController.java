package com.example.demo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Agente;
import com.example.demo.service.AgenteService;


@Controller
public class AgenteController {
	
	@Autowired
	private AgenteService agenteService;
	
	@GetMapping("/ind-agente")
	public String agente (Agente agente) {
		return "/agente";
	}
	
	@GetMapping("/buscarAgente")
	public String buscarAgente(Agente agente) {
		return "pesquisa-agente";
	}
	
	@GetMapping("/cadAgente")
	public String exibirCadastroAgente(Agente agente) {
		return "cadastro-agente";
	}
	
	
	@PostMapping("/cadastroAgente")
	public String cadastrarAgente(@Valid Agente agente,BindingResult result, RedirectAttributes redirectAttributes, Model model,RedirectAttributes ra) {
		
		
		redirectAttributes.addFlashAttribute("message", "Failed");
		redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		if (result.hasErrors()) {
			return "redirect:/cadAgente";
		}
		boolean retorno = this.agenteService.salvarAgente(agente);
		if (retorno == false) {
			ra.addFlashAttribute("message", "Não foi possível criar usuário: " + "Já existe um Agente com este email");
            ra.addFlashAttribute("agente", agente);
			return "redirect:/cadAgente";

		}

		ra.addFlashAttribute("message", "Agente cadastrado");
		
		return "redirect:/cadAgente";
	}
	
	/**Autenticacao - login para o posto de saude**/
	@PostMapping("/autenticacaoagente")
	public String autenticarPosto(Agente agente, HttpSession session) {

		if(agente.getSenha().equals(agente.getSenha())) {
			session.setAttribute("postoAutenticado", agente);
			return "redirect:/vacinaform";
		}
			return "";
	}
	

}
