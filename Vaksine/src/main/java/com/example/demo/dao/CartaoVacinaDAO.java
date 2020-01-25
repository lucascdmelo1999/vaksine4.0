package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CartaoVacina;

@Repository
public interface CartaoVacinaDAO extends JpaRepository<CartaoVacina, Integer>{


}
