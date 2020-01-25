package com.example.demo.serviceImpl;

import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsuarioDAO;
import com.example.demo.dao.VacinaDAO;
import com.example.demo.dao.VacinaUsuarioDAO;
import com.example.demo.model.Usuario;
import com.example.demo.model.VacinaUsuario;
import com.example.demo.service.VacinaUsuarioService;

@Service
public class CartaoVacinaServiceImpl implements VacinaUsuarioService{

	@Autowired
	private VacinaUsuarioDAO vacinaUsuarioDAO;
	
	@Autowired
	private VacinaDAO vacinaDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public VacinaUsuario cadastrarCartao(VacinaUsuario cartao) {
		
		/**cadastrando a vacina do usuario**/
		Optional.ofNullable(cartao).ifPresent(this::checkFields);
		
		cartao = vacinaUsuarioDAO.save(cartao);
		return cartao;
	}
	
	public void checkFields(VacinaUsuario cartao) {
		/**verificando se existe um usuário cadastrado**/
		Usuario usuario = usuarioDAO.findByCpfIgnoreCase(cartao.getUsuario().getCpf());
		if(usuario == null) {
			throw new ServiceException("Não existe nenhum usuário com esse cpf");
		}
		
		Optional<VacinaUsuario> vacinaUsuario = vacinaUsuarioDAO.findById(cartao.getId());
		
		//vacinaUsuario.ifPresent(this::teste);
		/**verificando se o usuario ja recebeu tem uma dose da vacina**/
		
		
	}
	

}
