package com.example.demo.controller;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.PostoDAO;
import com.example.demo.model.Posto;
import com.example.demo.service.PostoService;

@Controller
public class PostoController {
	
	@Inject
	PostoService postoService;
	
	@Autowired
	private PostoDAO postoDAO;
	
	@GetMapping("/loginPostoAgente")
	public String loginPostoAgente(Posto posto) {
		return "posto-agente-login";
	}
	
	@GetMapping("/cadastroposto")
	public String formCadastro(Posto posto) {
		return "cadastro-posto";
	}
	
	@GetMapping("/admposto")
	public String admposto() {
		return"admposto";
	}
	
	@GetMapping("/atualizarperfilposto")
	public String atualizarPerfil(Posto posto) {
		return "redirect:/link";
	}

	@PostMapping("/salvarposto")
	public String cadastrarPosto(@Valid Posto posto,BindingResult result, RedirectAttributes ra) {
		
		
		if (result.hasErrors()) {
			return "redirect:/cadUsuario";
		}try {
			ra.addFlashAttribute("message", "Posto cadastrado com sucesso");
			ra.addFlashAttribute("alertClass", "alert-success");
			this.postoService.cadastrarPosto(posto);
			return "redirect:/cadastroposto";
		} catch (ServiceException | MessagingException e) {
			ra.addFlashAttribute("message", "Não foi possível criar posto: " + e.getMessage());
			return "redirect:/cadastroposto";

		}
		
	
	}
	
	/*@PostMapping("/autenticacaoposto")
	public String autenticarPosto(Posto inputPosto, RedirectAttributes ra, HttpSession session) {
		Posto posto = postoService.buscarPostoPorEmail(inputPosto.getEmail());
		if(inputPosto.getSenha().equals(inputPosto.getSenha())) {
			System.out.println(posto.getEmail());
			ra.addFlashAttribute("mensagem","logado");
			session.setAttribute("usuarioLogado", inputPosto);
			return "redirect:/admposto";
		}else {
			ra.addAttribute("mensagem", "Login/senha inválida");
			return "redirect:/loginPostoAgente";
		}
	}*/
	/*@PostMapping("/autenticacaoposto")
	public String efetuarlogin(Posto posto, RedirectAttributes ra, HttpSession session) {
		posto = this.postoDAO.findByEmailAndSenha(posto.getEmail(),posto.getSenha());
		if(posto != null) {
			ra.addFlashAttribute("mensagem","login com sucesso");
			session.setAttribute("postoLogado", posto);
			return "redirect:/admposto";
		}else {
			ra.addFlashAttribute("mensagem","erro ao logar");
			return "redirect:/";
		}
	}*/
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session, Posto posto) {
		session.invalidate();
		return "redirect:/cadastroposto";
	}

	@GetMapping("/perfilposto")
	public String perfilposto() {
		return "perfil-posto";
	}
	
}
