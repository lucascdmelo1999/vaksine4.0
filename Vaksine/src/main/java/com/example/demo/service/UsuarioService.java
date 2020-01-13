package com.example.demo.service;

import javax.mail.MessagingException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;
@Repository
public interface UsuarioService extends JpaRepository<Usuario, Integer> {
	
	public boolean salvarUsuario(Usuario usuario) throws ServiceException, MessagingException;
	
	
}
