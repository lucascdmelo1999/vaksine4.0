package com.example.demo.serviceImpl;

import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.UsuarioDAO;
import com.example.demo.dao.VacinaDAO;
import com.example.demo.dao.VacinacaoDAO;
import com.example.demo.model.Usuario;
import com.example.demo.model.Vacina;
import com.example.demo.model.Vacinacao;
import com.example.demo.service.VacinacaoService;

@Service
public class VacinacaoServiceImpl implements VacinacaoService{

	@Autowired
	private VacinacaoDAO vacinacaoDAO;
	
	@Autowired
	private VacinaDAO vacinaDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public Vacinacao efetuarVacinacao(Vacinacao vacinacao) {
		
		Usuario usuario = usuarioDAO.verificacaoCPF(vacinacao.getUsuario().getCpf());
		
		/**cadastrando a vacina do usuario**/
		Vacina vacina = vacinaDAO.findByNomeIgnoreCase(vacinacao.getVacina().getNome());
		this.checkFields(vacinacao);
		
		vacina.getLoteVacina().setQuantidade(vacina.getLoteVacina().getQuantidade() -1);
		vacina = vacinaDAO.save(vacina);
		
		//setar usuario e cartao
		vacinacao.setUsuario(usuario);
		
//		vacinacao.setCartaoVacina(usuario.getCartaoVacina());
		
		vacinacao = vacinacaoDAO.save(vacinacao);
		return vacinacao;
	}
	
	public void checkFields(Vacinacao vacinacao) {
		
		Usuario usuario = usuarioDAO.verificacaoCPF(vacinacao.getUsuario().getCpf());
		/**verificando se existe um usuário cadastrado**/
		if(usuario == null) {
			throw new ServiceException("Não existe nenhum usuário com esse cpf");
		}
		
//		//Optional<Vacina> findVacina = vacinaDAO.findById(vacinacao.getVacina().getId());
//		Vacinacao findVacinacao = vacinacaoDAO.find
//		
//		if(findvacina.isPresent() && findVacina.get().get) {
//			throw new ServiceException("Já existe uma vacina, com a mesma dose cadastrada");
//		}
	}

	@Override
	public Vacinacao efetuarVacinacao(Vacinacao vacinacao, RedirectAttributes ra) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
