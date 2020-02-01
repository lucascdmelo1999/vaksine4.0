package com.example.demo.serviceImpl;

import javax.inject.Named;
import javax.mail.MessagingException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.PostoDAO;
import com.example.demo.model.Posto;
import com.example.demo.service.PostoService;
import com.example.demo.util.Util;

@Named
public class PostoServiceImpl implements PostoService{
	
	@Autowired
	PostoDAO postoDAO;
	
	public Posto verificacaoEmailPosto(String email) {
		return postoDAO.verificacaoEmailPosto(email);
	}
	
	@Override
	public Posto cadastrarPosto(Posto posto)throws ServiceException, MessagingException {	
		/** setando o codigo do usuario do posto**/
		if (this.verificacaoEmailPosto(posto.getEmail()) != null) {
			throw new ServiceException("Já existe um usuário com este e-mail");
		}else {
			String senhaCriptografada;

			try {
				senhaCriptografada = Util.criptografarSenha(posto.getSenha());
				posto.setSenha(senhaCriptografada);
				posto.setCodigoUsuario("ADMPOSTO");
				return postoDAO.save(posto);
			}catch (Exception e){
				
			}
			
		}
		return posto;
	}
	
	@Override
	public Posto atualizarPosto(Posto posto, Integer id) {
		return postoDAO.save(posto);
	}

	@Override
	public Posto deletarPosto(Integer id) {
		return null;
	}
	
	@Override
	/*public Posto buscarPostoPorEmail(String email) {
		
		Posto posto = postoDAO.findByEmail(email);
		try {
			this.checarDados(posto);
			return posto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}*/
	
	public void checarDados(Posto posto) throws Exception {
		
		if(posto==null) {
			throw new Exception("Não existe conta com esse login");
		}
	}

	@Override
	public Posto buscarPostoPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Posto atualizarPerfil(Posto posto) {
		posto = postoDAO.save(posto);
		return posto;
		
	}
	
}
