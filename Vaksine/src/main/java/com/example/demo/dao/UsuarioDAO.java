package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {
	
	//Usuario findByEmail(String email);
	
	@Query("select c from Usuario c where c.email = :email and c.senha = :senha")
	public  Usuario UsuarioLogin(String email, String senha);
	
	@Query("select c from Usuario c where c.email = :email")
	public Usuario findByEmailIgnoreCase(String email);
	
	@Query("select c from Usuario c where c.cpf = :cpf")
	public Usuario findByCpfIgnoreCase(String cpf);
}
