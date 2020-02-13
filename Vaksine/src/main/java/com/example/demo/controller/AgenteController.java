package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.AgenteDAO;
import com.example.demo.model.Agente;
import com.example.demo.service.AgenteService;
import com.example.demo.util.Util;


@Controller
public class AgenteController {
	
	@Autowired
	private AgenteService agenteService;
	@Autowired 
	AgenteDAO agenteDAO;
	
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
	public String cadastrarAgente(@Valid Agente agente,BindingResult result, RedirectAttributes ra, Model model) throws ServiceException, MessagingException {
		

		if (result.hasErrors()) {
			System.out.println("erro");

			return "redirect:/cadAgente";
		}
		try {
			this.agenteService.cadastrarAgente(agente);
			System.out.println("cadastrado");

			ra.addFlashAttribute("mensagem", "Agente cadastrado com sucesso!");
			return "redirect:/cadAgente";
			
		} catch (ServiceException | MessagingException e) {
			System.out.println(e.getMessage());
			System.out.println("exessao");

			return "redirect:/";
		}
		
		
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
	
	@PostMapping("/agenteLogin")
	public String agenteLogin(Agente agente,
			RedirectAttributes ra,
			HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		agente = this.agenteDAO.findByEmailAndSenha(agente.getEmail(),Util.criptografarSenha(agente.getSenha()));
		
		if (agente != null) {
			
			session.setAttribute("usuarioLogado",agente);
			return "redirect:/home";
		} else {
			
			ra.addFlashAttribute("mensagem", "Login/senha inválidos");
			return "redirect:/";
		}


	}
	@GetMapping("/perfilagente")
	public String perfilagente() {
		return "perfil-agente";
	}
	
	@GetMapping("/admagente")
	public String admagente() {
		return "admagente";
	}
	

}
