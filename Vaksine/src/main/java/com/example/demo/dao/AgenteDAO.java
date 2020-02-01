package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Agente;

@Repository
public interface AgenteDAO extends JpaRepository<Agente, Integer>{

	Agente findByCpf(String cpf);
	
	@Query("select c from Posto c where c.email = :email")
	public Agente verificacaoEmailAgente(String email);
	
	Agente findByEmail(String email);
	Agente findByEmailAndSenha(String email, String senha);

}
