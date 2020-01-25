package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.VacinaUsuario;

@Repository
public interface VacinaUsuarioDAO extends JpaRepository<VacinaUsuario, Integer>{


}