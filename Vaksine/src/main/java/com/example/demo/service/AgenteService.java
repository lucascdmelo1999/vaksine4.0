package com.example.demo.service;


import javax.mail.MessagingException;

import org.hibernate.service.spi.ServiceException;

import com.example.demo.model.Agente;

public interface AgenteService {

	public Agente cadastrarAgente(Agente agente) throws ServiceException, MessagingException;
	
	public boolean salvarAgente(Agente agente);
	
	

}
