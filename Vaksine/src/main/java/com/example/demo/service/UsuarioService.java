package com.example.demo.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;
@Repository
public interface UsuarioService extends JpaRepository<Usuario, Integer> {
	
	public boolean salvarUsuario(Usuario usuario) throws ServiceException, MessagingException;
	
	public Usuario logarUsuario(String cpf, String senha) throws ServiceException, NoSuchAlgorithmException, UnsupportedEncodingException;
	
}
