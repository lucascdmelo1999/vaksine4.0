package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Posto;

public interface PostoDAO extends JpaRepository<Posto, Integer> {

	
	@Query("select c from Posto c where c.email = :email and c.senha = :senha")
	public Posto logarPosto( @Param("email") String email,@Param("senha") String senha);
	
	@Query("select c from Posto c where c.email = :email")
	public Posto verificacaoEmailPosto(@Param("email") String email);
}
