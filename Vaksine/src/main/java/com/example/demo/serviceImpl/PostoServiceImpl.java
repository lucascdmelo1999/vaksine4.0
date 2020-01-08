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
	public Posto cadastrarPosto(Posto posto){	
		/** setando o codigo do usuario do posto**/
		posto.setCodigoUsuario("ADMPOSTO");
		return postoDAO.save(posto);
	}
	
	@Override
	public Posto atualizarPosto(Posto posto, Integer id) {
		return postoDAO.save(posto);
	}

	@Override
	public Posto deletarPosto(Integer id) {
		return null;
	}
}
