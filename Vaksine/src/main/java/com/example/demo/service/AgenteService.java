package com.example.demo.service;

import com.example.demo.model.Agente;
import com.example.demo.model.PerfilSeguranca;

public interface AgenteService {

	public Agente cadastrarAgente(Agente agente);
	
	public PerfilSeguranca buscarAgentePorCpf(String cpf);
}
