package com.example.demo.service;
import com.example.demo.model.PerfilUsuarioPosto;
import com.example.demo.model.Posto;

public interface PostoService {
	
	public Posto cadastrarPosto(Posto posto);
	
	public Posto atualizarPosto(Posto posto, Integer id);
	
	public Posto deletarPosto(Integer id);
	
	public PerfilUsuarioPosto buscarPerfilUsuarioPosto(String email);

}
