package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.UsuarioDAO;
import com.example.demo.dao.VacinacaoDAO;
import com.example.demo.model.Usuario;
import com.example.demo.model.Vacinacao;


@Controller
public class PaginaInicialController {
	
	@Autowired
	VacinacaoDAO vacinacaoDAO;
	
	@Autowired
	UsuarioDAO usuarioDAO;
	
	@GetMapping("/paginainicial")
	public String paginainicial() {
		return "index";
	}
	@GetMapping("/cartao")
	public String cartao(Vacinacao vacinacao,Model model,HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		System.out.println("vacina"+vacinacao.getId());
		System.out.println("user"+usuario.getId());

		List<Vacinacao> resultado = this.vacinacaoDAO.findByIdUsuario(usuario.getId());
		if(resultado != null) {
			model.addAttribute("listaVacinacoes", resultado);
		}
		return "cartao-de-vacina";
	}
	@GetMapping("/confirmacaoEmail")
	public String confirmacaoEmail() {
		return "confirmacao-email";
	}
	
	@GetMapping("/loginusuario")
	public String loginusuario() {
		return "usuario-login";

	}
	@GetMapping("/loginADM")
	public String loginADM() {
		return "loginAdm";

	}
	
	@GetMapping("/loginposto")
	public String loginposto() {
		return "posto-agente-login";
	}


	@GetMapping("/contato")
	public String contato() {
		return "contato";
	}
	
	@GetMapping("/quemsomos")
	public String quemsomos() {
		return"quem-somos";
	}
}
