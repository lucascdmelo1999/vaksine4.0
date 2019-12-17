package com.example.demo.serviceImpl;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.PostoDAO;
import com.example.demo.model.Posto;
import com.example.demo.service.PostoService;

@Named
public class PostoServiceImpl implements PostoService{
	
	@Autowired
	PostoDAO postoDAO;
	
	@Override
	public Posto save(Posto posto){
		//verifica se existe alguma excessão
		try {
			this.checkPassword(posto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return postoDAO.save(posto);
	}
	
	public void checkPassword(Posto posto) throws Exception {
		if(!(posto.getSenha().equals(posto.getConfirmarSenha()))) {
			throw new Exception("Senhas não conferem, favor, inserir senhas iguais");
		}
	}
	
	
}
