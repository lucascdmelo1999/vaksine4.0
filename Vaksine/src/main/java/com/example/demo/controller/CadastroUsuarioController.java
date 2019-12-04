package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UsuarioDAO;
import com.example.demo.model.Usuario;

@Controller
public class CadastroUsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@GetMapping("/cadUsuario")
	public String cadastro(Model model,Usuario usuario) {
		
		return "cadastro-usuario";
		
	}
	@PostMapping("/cad")
	public String cadastrar(Usuario usuario) {
		usuarioDAO.save(usuario);
		return "redirect:/cadUsuario";
		
	}
	
	@PostMapping("/addCadastro")
	public ModelAndView addUser( Usuario user) {
		ModelAndView mv = new ModelAndView("cadastro-posto");
		mv.addObject("usuario", user);
		return mv;
		
	
    }
	
}
