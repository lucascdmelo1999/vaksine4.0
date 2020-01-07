package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AgenteDAO;
import com.example.demo.model.Agente;
import com.example.demo.model.PerfilSeguranca;
import com.example.demo.service.AgenteService;

@Service
public class AgenteServiceImpl implements AgenteService{

	@Autowired
	AgenteDAO agenteDAO;
	
	@Override
	public Agente cadastrarAgente(Agente agente) {
		
		/** setando o login e o codigo do usuario do posto**/
		agente.getPerfilSeguranca().setLogin(agente.getCpf());
		agente.getPerfilSeguranca().setCodUsuario("ADMAGENTE");
		
		return agenteDAO.save(agente);
	}

	@Override
	public PerfilSeguranca buscarAgentePorCpf(String cpf) {
		Agente agente = agenteDAO.findByCpf(cpf);
		if(agente.getPerfilSeguranca() != null) {
			PerfilSeguranca perfil = agente.getPerfilSeguranca();
			return perfil;
		}
		return null;
	}
	
	//verifica se as senhas não conferem
	public void checkPassword(Agente agente) throws Exception {
		if(!(agente.getPerfilSeguranca().getSenha().equals(agente.getPerfilSeguranca().getSenha2()))) {
			throw new Exception("Senhas não conferem, favor, inserir senhas iguais");
		}
	}

}
