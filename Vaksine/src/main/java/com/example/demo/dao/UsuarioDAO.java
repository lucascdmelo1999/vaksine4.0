package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {
	
	//Usuario findByEmail(String email);

	
	
	@Query("select c from Usuario c where c.email = :email and c.senha = :senha")
	public  Usuario UsuarioLogin(@Param("email") String email, @Param("senha") String senha);
	
	@Query("select c from Usuario c where c.email = :email and c.email <> :email")
	public Usuario findByEmailIgnoreCase(@Param("email") String email);
	
	@Query("select c from Usuario c where c.email = :email")
	public Usuario verificacaoEmail(String email);
	
	@Query("select c from Usuario c where c.cpf = :cpf ")
	public Usuario verificacaoCPF(@Param("cpf") String cpf);
	
	@Query("select c from Usuario c where c.cpf = :cpf and c.cpf <> :cpf")
	public Usuario findByCpfIgnoreCase(@Param("cpf") String cpf);
	
	@Query("select c from Usuario c where c.id = :id")
	public Usuario findByid(@Param("id") Integer id);


}
