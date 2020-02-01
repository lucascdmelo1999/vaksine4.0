package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Email;

public interface EmailDAO extends JpaRepository<Email, Integer> {
	public Email findByToken(String token);
	
	
}