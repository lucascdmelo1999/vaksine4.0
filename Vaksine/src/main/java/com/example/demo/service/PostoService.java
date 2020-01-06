package com.example.demo.service;
import com.example.demo.model.PerfilSeguranca;
import com.example.demo.model.Posto;

public interface PostoService {
	
	public Posto cadastrarPosto(Posto posto);
	
	public Posto atualizarPosto(Posto posto, Integer id);
	
	public Posto deletarPosto(Integer id);

	PerfilSeguranca buscarPerfilUsuarioPosto(String email);

}
