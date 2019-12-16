package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Agente;

@Repository
public interface AgenteDAO extends JpaRepository<Agente, Integer>{

}
