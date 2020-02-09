package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.VacinacaoDTO;
import com.example.demo.model.Vacina;

@Repository
public interface VacinaDAO extends JpaRepository<Vacina, Integer>{
	
	List<Vacina> findByNomeContainingIgnoreCase(String nome, Sort sort);
	
	Vacina findByNomeIgnoreCase(String nome);
	
//	@Query(value = "SELECT DISTINCT(select nome from vacina v where v.id = vacinacao.vacina_id)vacina,\r\n" + 
//			"(select  DISTINCT usuario.nome from usuario  where usuario.id = vacinacao.id_usuario)usuario,\r\n" + 
//			"(select  DISTINCT vac.data_vacinacao from vacinacao vac where vac.dose=1 and vac.id_usuario=2 and vac.vacina_id = vacinacao.vacina_id)dose1,\r\n" + 
//			"(select  DISTINCT vac.data_vacinacao from vacinacao vac where vac.dose=2 and vac.id_usuario=2 and vac.vacina_id = vacinacao.vacina_id)dose2,\r\n" + 
//			"(select  DISTINCT vac.data_vacinacao from vacinacao vac where vac.dose=3 and vac.id_usuario=2 and vac.vacina_id = vacinacao.vacina_id)dose3,\r\n" + 
//			"(select  DISTINCT vac.data_vacinacao from vacinacao vac where vac.dose=4 and vac.id_usuario=2 and vac.vacina_id = vacinacao.vacina_id)dose4\r\n" + 
//			"FROM vacinacao where  vacinacao.id_usuario=2", nativeQuery = true)
//	public List<VacinacaoDTO> findVacinaWithFilter();
	
	
	@Query(value = "SELECT DISTINCT(select nome from vacina v where v.id = vacinacao.vacina_id)vacina,\r\n" + 
			"(select  DISTINCT usuario.nome from usuario  where usuario.id = vacinacao.id_usuario)usuario,\r\n" + 
			"(select  DISTINCT vac.data_vacinacao from vacinacao vac where vac.dose=1 and vac.id_usuario= :idUsuario and vac.vacina_id = vacinacao.vacina_id)dose1,\r\n" + 
			"(select  DISTINCT vac.data_vacinacao from vacinacao vac where vac.dose=2 and vac.id_usuario= :idUsuario and vac.vacina_id = vacinacao.vacina_id)dose2,\r\n" + 
			"(select  DISTINCT vac.data_vacinacao from vacinacao vac where vac.dose=3 and vac.id_usuario= :idUsuario and vac.vacina_id = vacinacao.vacina_id)dose3,\r\n" + 
			"(select  DISTINCT vac.data_vacinacao from vacinacao vac where vac.dose=4 and vac.id_usuario= :idUsuario and vac.vacina_id = vacinacao.vacina_id)dose4\r\n" + 
			"FROM vacinacao where  vacinacao.id_usuario= :idUsuario", nativeQuery = true)
	List <Object> findVacinaWithFilter1(@Param("idUsuario") Integer idUsuario);
	
	
}
