package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.PostoDAO;
import com.example.demo.model.Posto;

@Controller
public class PostoController {
	
	@Autowired
	public PostoDAO postoDAO;
	
	@GetMapping("/cadastroposto")
	public String cadastroposto() {
		return "cadastro-posto";
	}
	
	@PostMapping("/salvarposto")
	public String salvarposto(@Valid Posto posto, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "cadastro-posto";
			
		};
		this.postoDAO.save(posto);
		return "redirect:/#";
	}


}
