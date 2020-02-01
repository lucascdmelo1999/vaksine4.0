package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Posto;

public interface PostoDAO extends JpaRepository<Posto, Integer> {
	
	public Posto findByEmailAndSenha(String email, String senha);
	
	@Query("select c from Posto c where c.email = :email and c.senha = :senha")
	public Posto logarPosto(String email, String senha);
	
	@Query("select c from Posto c where c.email = :email")
	public Posto verificacaoEmailPosto(String email);
}
