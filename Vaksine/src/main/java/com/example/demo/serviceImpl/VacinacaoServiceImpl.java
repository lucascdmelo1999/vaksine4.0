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
		
		/**cadastrando a vacina do usuario**/
		Usuario usuario = usuarioDAO.verificacaoCPF(vacinacao.getUsuario().getCpf());
		Vacina vacina = vacinaDAO.findByNomeIgnoreCase(vacinacao.getVacina().getNome());
		this.checkFields(usuario);
		
		vacina.getLoteVacina().setQuantidade(vacina.getLoteVacina().getQuantidade() -1);
		vacina = vacinaDAO.save(vacina);
		
		//setar usuario e cartao
		vacinacao.setUsuario(usuario);
		
//		vacinacao.setCartaoVacina(usuario.getCartaoVacina());
		
		vacinacao = vacinacaoDAO.save(vacinacao);
		return vacinacao;
	}
	
	public void checkFields(Usuario usuario) {
		/**verificando se existe um usuário cadastrado**/
		if(usuario == null) {
			throw new ServiceException("Não existe nenhum usuário com esse cpf");
		}
		
		//Optional<Vacinacao> findVacinacao = vacinacaoDAO.findById(vacinacao.getId());
		
		//vacinaUsuario.ifPresent(this::teste);
		/**verificando se o usuario ja recebeu tem uma dose da vacina**/
		
		
	}

	@Override
	public Vacinacao efetuarVacinacao(Vacinacao vacinacao, RedirectAttributes ra) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
