package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Vacinacao;

@Repository
public interface VacinacaoDAO extends JpaRepository<Vacinacao, Integer>{

	List<Vacinacao> findById(String id);
	
	@Query("select c from Vacinacao c where id_usuario = :id")
	List<Vacinacao> findByIdUsuario(@Param("id") Integer id);
	
	@Query("select c from Vacinacao c where id_usuario = :id AND c.dose >=1 OR c.dose <=4 ")
	List<Vacinacao> listarVacinacoes(@Param("id") Integer id);
	
	@Query("select vcn from Vacinacao vcn where vcn.vacina.id = :id")
	Vacinacao findByVacina(@Param("id") Integer id);

}
