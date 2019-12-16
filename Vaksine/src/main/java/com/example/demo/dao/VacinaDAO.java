package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Vacina;

@Repository
public interface VacinaDAO extends JpaRepository<Vacina, Integer>{

}
