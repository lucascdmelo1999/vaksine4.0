//package com.example.demo.controller;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.example.demo.dao.PostoDAO;
//import com.example.demo.dao.VacinaDAO;
//import com.example.demo.model.Posto;
//import com.example.demo.model.Vacina;
//
//public class AutenticacaoPostoController {
//	
//	@Autowired
//	PostoDAO postoDAO;
//	
//	@Autowired VacinaDAO vacinaDAO;
//	
//	@GetMapping("/vacinalist")
//	public String listarVacina(Vacina vacina, Model model) {
//		model.addAttribute("listaVacinas", this.vacinaDAO.findAll(Sort.by("id")));
//		return "/lista-vacina3";
//	}
//	
//	@GetMapping("/loginform")
//	public String loginPostoAgente(Posto posto) {
//		return "posto-agente-login";
//	}
//	
//	@PostMapping("/loginpostoagente")
//	public String autenticarPosto(Posto posto, HttpSession session) {
//		
//		posto = postoDAO.findByEmailAndSenha(posto.getEmail(), posto.getSenha());
//		
//		if(posto!=null) {
//			session.setAttribute("postoAutenticado", posto);
//			return "redirect:/vacinalist";
//		}
//		
//		
//		return null;
//	}
//
//}
