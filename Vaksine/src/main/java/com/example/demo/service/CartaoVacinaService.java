package com.example.demo.service;

import java.util.List;

import com.example.demo.model.CartaoVacina;
import com.example.demo.model.Usuario;
import com.example.demo.model.Vacina;

public interface CartaoVacinaService {

	public Usuario buscarUsuarioPorCpf(CartaoVacina cartaoVacina);
	
	public List<Vacina> listarVacina();
	
}
