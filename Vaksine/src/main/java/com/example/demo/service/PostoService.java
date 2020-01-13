package com.example.demo.service;
import com.example.demo.model.Posto;

public interface PostoService {
	
	public Posto cadastrarPosto(Posto posto);
	
	public Posto atualizarPosto(Posto posto, Integer id);
	
	public Posto deletarPosto(Integer id);
	
	public Posto buscarPostoPorEmail(String email);

	void checarDados(Posto posto) throws Exception;

}
