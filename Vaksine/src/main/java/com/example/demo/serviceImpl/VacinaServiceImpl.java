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
		vacina = vacinaDAO.save(vacina);
		this.associarVacinaPosto(session, vacina);
		return vacina;
	}
	
	public void checkFields(Vacina vacina) {
		
		Vacina vacinaByNome = vacinaDAO.findByNomeIgnoreCase(vacina.getNome());
		if(vacinaByNome != null) {
			throw new ServiceException("Já existe uma vacina com esse nome");
		}
	}
	
	public void associarVacinaPosto(HttpSession session, Vacina vacina) {
		/**pega o objeto psoto logado**/
		Posto posto = (Posto) session.getAttribute("usuarioLogado");
		
		/**lista que armazena as vacinas cadastradas**/
		List<Vacina> vacinaList = new ArrayList<>();
		vacinaList.add(vacina);
		/**alterando o objeto posto, adicionando as vacinas**/
		posto.setVacina(vacinaList);
		postoDAO.save(posto);
		
	}

}
