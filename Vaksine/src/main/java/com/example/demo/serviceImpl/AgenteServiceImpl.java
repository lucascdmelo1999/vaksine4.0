package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AgenteDAO;
import com.example.demo.model.Agente;
import com.example.demo.service.AgenteService;

@Service
public class AgenteServiceImpl implements AgenteService {

	@Autowired
	private AgenteDAO agenteDAO;

	@Override
	public Agente cadastrarAgente(Agente agente) {
		/** setando o codigo do usuario do posto **/
		agente.setCodigoUsuario("ADMAGENTE");
		return agenteDAO.save(agente);

	}
	public boolean salvarAgente(Agente agente) {
	// Verificar a existencia de um agente com o email
	
	Agente agenteComEmailExistente = this.agenteDAO.findByEmail(agente.getEmail());
	
	if (agenteComEmailExistente == null) {
		this.agenteDAO.save(agente);	
		return true;
	}
	return false;
	
}

}
