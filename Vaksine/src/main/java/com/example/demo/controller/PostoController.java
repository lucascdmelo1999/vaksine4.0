package com.example.demo.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.VacinaDAO;
import com.example.demo.model.Posto;
import com.example.demo.service.PostoService;

@Controller
public class PostoController {
	
	@Inject
	PostoService postoService;
	
	@Autowired
	VacinaDAO vacinaDAO;
	
	@GetMapping("/loginPostoAgente")
	public String loginPostoAgente(Posto posto) {
		return "posto-agente-login";
	}

	@GetMapping("/cadastroposto")
	public String formCadastro(Posto posto) {
		return "cadastro-posto";
	}

	@PostMapping("/salvarposto")
	public String cadastrarPosto(Posto posto,BindingResult result, RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("message", "Failed");
		redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		if (result.hasErrors()) {
			return "redirect:/cadUsuario";
		}
		redirectAttributes.addFlashAttribute("message", "Posto cadastrado com sucesso");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		this.postoService.cadastrarPosto(posto);
		return "redirect:/cadastroposto";
	
	
	}
	
	/**Autenticacao - login para o posto de saude**/
	@PostMapping("/autenticacaoposto")
	public String autenticarPosto(Posto posto, HttpSession session) {
		
//		if(inputperfil.getSenha().equals(perfil.getSenha())) {
//			session.setAttribute("postoAutenticado", perfil);
//			return "redirect:/vacinaform";
//		}
			return "";
	}

}
