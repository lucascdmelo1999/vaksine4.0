package com.example.demo.serviceImpl;


import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AgenteDAO;
import com.example.demo.model.Agente;
import com.example.demo.model.Posto;
import com.example.demo.service.AgenteService;
import com.example.demo.util.Util;


@Service
public class AgenteServiceImpl implements AgenteService {
	@Autowired
	private AgenteDAO agenteDAO;

	public Agente verificacaoEmailAgente(String email) {
		return agenteDAO.verificacaoEmailAgente(email);
	}
	
	@Override
	public Agente cadastrarAgente(Agente agente) throws ServiceException, MessagingException{
		/** setando o codigo do usuario do posto **/
		
		if (this.verificacaoEmailAgente(agente.getEmail()) != null) {
			throw new ServiceException("Já existe um usuário com este e-mail");
		}
		String senhaCriptografada;

		try {
			senhaCriptografada = Util.criptografarSenha(agente.getSenha());
			agente.setSenha(senhaCriptografada);
			agente.setCodigoUsuario("ADMAGENTE");
			return agenteDAO.save(agente);
		}catch(Exception e) {
			
		}
		return agente;
		
		
	}
	
	
	public Agente logarAgente(String email, String senha) throws ServiceException, NoSuchAlgorithmException, UnsupportedEncodingException {	
		
		String senhaCriptografada = Util.criptografarSenha(senha);
		Agente agente = this.agenteDAO.logarAgente(email, senhaCriptografada);

		return agente;
	}
	
	
	
	public boolean salvarAgente(Agente agente) {
	
	Agente agenteComEmailExistente = this.agenteDAO.findByEmail(agente.getEmail());
	
		if (agenteComEmailExistente == null) {
			this.agenteDAO.save(agente);	
			return true;
		}
	return false;
	
	}	
	
}
