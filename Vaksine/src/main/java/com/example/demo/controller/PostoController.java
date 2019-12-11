package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.PostoDAO;
import com.example.demo.model.Posto;

@Controller
public class PostoController {

	@Autowired
	public PostoDAO postoDAO;

	@GetMapping("/cadastroposto")
	public String cadastroposto(Posto posto) {
		return "cadastro-posto";
	}

	@PostMapping("/salvarposto")
	public String salvarposto(Posto posto) {

		this.postoDAO.save(posto);
		return "redirect:/paginainicial";
	}

}
