package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;
import com.example.demo.model.Vacinacao;

@Repository
public interface VacinacaoDAO extends JpaRepository<Vacinacao, Integer>{

	List<Vacinacao> findById(String id);
	
	@Query("select c from Vacinacao c where id_usuario = :id")
	List<Vacinacao> findByIdUsuario(Integer id);

}
