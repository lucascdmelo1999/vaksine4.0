package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String cadastrarAgente(Agente agente,BindingResult result, RedirectAttributes redirectAttributes) {
		agenteService.cadastrarAgente(agente);
		
		
		redirectAttributes.addFlashAttribute("message", "Failed");
		redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		if (result.hasErrors()) {
			return "redirect:/cadUsuario";
		}
		redirectAttributes.addFlashAttribute("message", "Agente cadastrado");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		
		return "redirect:/cadAgente";
	}
	
	/**Autenticacao - login para o posto de saude**/
	@PostMapping("/autenticacaoagente")
	public String autenticarPosto(Agente agente, HttpSession session) {
		
		
		
//		if(inputperfil.getSenha().equals(perfil.getSenha())) {
//			session.setAttribute("postoAutenticado", perfil);
//			return "redirect:/vacinaform";
//		}
			return "";
	}
	

}
