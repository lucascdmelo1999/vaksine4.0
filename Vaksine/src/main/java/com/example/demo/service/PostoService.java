package com.example.demo.service;
import javax.mail.MessagingException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Posto;

@Repository
public interface PostoService {
	
	public Posto cadastrarPosto(Posto posto) throws ServiceException, MessagingException;
	
	public Posto atualizarPosto(Posto posto, Integer id);
	
	public Posto deletarPosto(Integer id);
	
	public Posto buscarPostoPorEmail(String email);
	
	public Posto atualizarPerfil(Posto posto);
	
	void checarDados(Posto posto) throws Exception;

}
