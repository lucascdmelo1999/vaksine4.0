package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.CartaoVacinaDAO;
import com.example.demo.model.CartaoVacina;
import com.example.demo.model.Usuario;
import com.example.demo.model.Vacina;
import com.example.demo.service.CartaoVacinaService;

public class CartaoVacinaServiceImpl implements CartaoVacinaService{

	@Autowired
	private CartaoVacinaDAO cartaoVacinaDAO;
	
	
	@Override
	public Usuario buscarUsuarioPorCpf(CartaoVacina cartaoVacina) {
		return null;
	}

	@Override
	public List<Vacina> listarVacina() {
		return null;
	}

}
