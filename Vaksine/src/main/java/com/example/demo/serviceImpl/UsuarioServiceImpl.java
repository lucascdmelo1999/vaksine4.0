package com.example.demo.serviceImpl;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UsuarioDAO;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import com.example.demo.util.Util;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private EmailServicelmpl emailService;
	
//	@Autowired
//	private CartaoVacinaDAO cartaoDAO;
	
		
		//Usuario usuarioComEmailExistente = this.usuarioDAO.findByEmail(usuario.getEmail());
		
			//if (usuarioComEmailExistente == null) {
			//	this.usuarioDAO.save(usuario);	
				//return true;
			//}
		//return false;
		
		//}
	public Usuario verificacaoCPF(String cpf) {
		return usuarioDAO.verificacaoCPF(cpf);
	}

	public Usuario verificacaoEmail(String email) {
		return usuarioDAO.verificacaoEmail(email);
	}
	public Usuario findByEmail(String email) {
		return usuarioDAO.findByEmailIgnoreCase(email);
	}
	
	public Usuario findUsuarioByEmail(String email) {
		return usuarioDAO.findByEmailIgnoreCase(email);
	}
	
	public Usuario findUsuarioByCpf(String cpf) {
		return usuarioDAO.findByCpfIgnoreCase(cpf);
	}
	
	public boolean salvarUsuario(Usuario usuario)throws ServiceException, MessagingException {
		
		// Verificar a existencia de um participante com o cpf
		
		if (this.verificacaoEmail(usuario.getEmail()) != null) {
			throw new ServiceException("Já existe um usuário com este e-mail");
		}
		else if (this.verificacaoCPF(usuario.getCpf()) != null) {
			throw new ServiceException("Já existe um usuário com este cpf");
		}  else {
				usuario.setToken(UUID.randomUUID().toString());
				System.out.println(UUID.randomUUID().toString());
				String senhaCriptografada;
				try {
					senhaCriptografada = Util.criptografarSenha(usuario.getSenha());
					usuario.setSenha(senhaCriptografada);
				} catch (Exception e) {
					// TODO: handle exception
				}
				this.emailService.enviarConfirmacaoDeConta(usuario);		
				//usuario.setCartaoVacina(cartao);
				
				this.usuarioDAO.save(usuario);
				return true;
				}
	}
	
	public Usuario logarUsuario(String email, String senha) throws ServiceException, NoSuchAlgorithmException, UnsupportedEncodingException {	
		
		String senhaCriptografada = Util.criptografarSenha(senha);
		Usuario usuario = this.usuarioDAO.UsuarioLogin(email, senhaCriptografada);


		return usuario;
	}

	
	public Usuario editarPerfil(Usuario usuario,HttpSession session) {
		Usuario usuarioLogado=(Usuario)session.getAttribute("usuario");
		Usuario user = this.usuarioDAO.findByid(usuarioLogado.getId());
			
		user.setCpf(usuario.getCpf());
		user.setDataNas(usuario.getDataNas());
		user.setEmail(usuario.getEmail());
		user.setNome(usuario.getNome());
		user.setNomeMae(usuario.getNome());
		user.setNomePai(usuario.getNomePai());
		user.setTipoSanguineo(usuario.getTipoSanguineo());
		user.setTelefone(usuario.getTelefone());
		user.setSenha(usuario.getSenha());	
		
		return user;
	}


	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Usuario> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Usuario> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Usuario> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Usuario> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Usuario> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Usuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Usuario> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Usuario> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Usuario entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Usuario> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Usuario> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Usuario> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Usuario> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Usuario> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	//@Override
	//public boolean salvarAgente(Usuario usuario) {
		// TODO Auto-generated method stub
		//return false;
	//}

}
