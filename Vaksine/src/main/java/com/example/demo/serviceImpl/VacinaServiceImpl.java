package com.example.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PostoDAO;
import com.example.demo.dao.VacinaDAO;
import com.example.demo.model.Posto;
import com.example.demo.model.Vacina;
import com.example.demo.service.VacinaService;

@Service
public class VacinaServiceImpl implements VacinaService{

	@Autowired
	VacinaDAO vacinaDAO;
	
	@Autowired
	PostoDAO postoDAO;
	
	@Override
	public Vacina cadastrarVacina(HttpSession session, Vacina vacina) {
		
		this.checkFields(vacina);
		vacina = this.associarVacinaPosto(session, vacina);
		return vacina;
	}
	
	public void checkFields(Vacina vacina) {
		
		Vacina vacinaByNome = vacinaDAO.findByNomeIgnoreCase(vacina.getNome());
		if(vacinaByNome != null) {
			throw new ServiceException("Já existe uma vacina com esse nome");
		}
	}
	
	public Vacina associarVacinaPosto(HttpSession session, Vacina vacina) {
		
		try {
		/**pega o objeto posto logado**/
		Posto posto = (Posto) session.getAttribute("usuarioLogado");
		
		/**lista que armazena as vacinas cadastradas**/
		List<Vacina> vacinaList = new ArrayList<>();
		vacinaList.add(vacina);
		
		/**alterando o objeto posto, adicionando as vacinas**/
		posto.setVacina(vacinaList);
		
		/**associando vacina com posto e posto com vacina**/
		vacina.setPosto(posto);
		vacina = vacinaDAO.save(vacina);
		postoDAO.save(posto);
		
		return vacina;
		
		}catch (Exception e) {
			throw new ServiceException("Ocorreu um erro inesperado");
		}
		
	}

}
