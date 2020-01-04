package com.example.demo.serviceImpl;

import java.util.Optional;
import javax.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.PostoDAO;
import com.example.demo.model.PerfilUsuarioPosto;
import com.example.demo.model.Posto;
import com.example.demo.service.PostoService;

@Named
public class PostoServiceImpl implements PostoService{
	
	@Autowired
	PostoDAO postoDAO;
	
	
	@Override
	public Posto cadastrarPosto(Posto posto){
		//verifica se existe alguma excessão
		try {
			this.checkPassword(posto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return postoDAO.save(posto);
	}
	
	@Override
	public Posto atualizarPosto(Posto posto, Integer id) {
		try {
			this.checkValidation(id, posto);
			return postoDAO.save(posto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Posto deletarPosto(Integer id) {
		return null;
	}
	
	//métodos de vaidações
	
	//verifica se as senhas não conferem
	public void checkPassword(Posto posto) throws Exception {
		if(!(posto.getPerfilUsuarioPosto().getSenha().equals(posto.getPerfilUsuarioPosto().getSenha2()))) {
			throw new Exception("Senhas não conferem, favor, inserir senhas iguais");
		}
	}
	
	public void checkValidation(Integer id, Posto posto) throws Exception {
		
		//verifica se não existe um posto com esse id. caso não exista, da erro
		Optional<Posto> postoOptional = postoDAO.findById(id);
		if(!postoOptional.isPresent()) {
			throw new Exception("Não é possível atualizar posto inexistente");
		}
		
		//verifica se o usuario esta tentando atualizar o codigo(primary key)
		if(posto.getCodigo() != null) {
			throw new Exception("Não é possível atualizar código do posto");
		}
		
	}
	
	@Override
	public PerfilUsuarioPosto buscarPerfilUsuarioPosto(String email) {
		Posto posto = postoDAO.findByEmail(email);
		if(posto.getPerfilUsuarioPosto() != null) {
			PerfilUsuarioPosto perfil = posto.getPerfilUsuarioPosto();
			return perfil;
		}
		return null;
	}
}
