package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Posto;

public interface PostoDAO extends JpaRepository<Posto, Integer> {
	
	public Posto findByEmailAndSenha(String email, String senha);
	

}
