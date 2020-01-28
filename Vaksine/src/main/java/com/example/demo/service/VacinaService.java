package com.example.demo.service;

import javax.servlet.http.HttpSession;

import com.example.demo.model.Vacina;

public interface VacinaService {

	public Vacina cadastrarVacina(HttpSession session, Vacina vacina);
}
