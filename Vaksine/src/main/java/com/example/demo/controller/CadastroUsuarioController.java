package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.AgenteDAO;
import com.example.demo.dao.PostoDAO;
import com.example.demo.dao.UsuarioDAO;
import com.example.demo.dao.VacinaDAO;
import com.example.demo.model.Agente;
import com.example.demo.model.Email;
import com.example.demo.model.Posto;
import com.example.demo.model.Usuario;
import com.example.demo.serviceImpl.AgenteServiceImpl;
import com.example.demo.serviceImpl.EmailServicelmpl;
import com.example.demo.serviceImpl.PostoServiceImpl;
import com.example.demo.serviceImpl.UsuarioServiceImpl;


@Controller
public class CadastroUsuarioController {
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@Autowired
	private AgenteServiceImpl agenteService;

	
	@Autowired
	private PostoDAO postoDAO;
	
	@Autowired
	private PostoServiceImpl postoService;
	
	@Autowired
	private AgenteDAO agenteDAO;

	@Autowired
	private EmailServicelmpl emailService;

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private VacinaDAO vacinaDAO;


	@GetMapping("/ind-usuario")
	public String agente (Agente agente) {
		return "/perfil-usuario";
	}


	@GetMapping("/cadUsuario")
	public String cadastro(Model model, Usuario usuario) {

		return "cadastro-usuario";

	}

	@PostMapping("/cad")
	public String cadastrar(@Valid Usuario usuario, BindingResult result, RedirectAttributes redirectAttributes, Errors errors){

		if (result.hasErrors()) {
			return "redirect:/cadUsuario";
		}
		else {
			try {
				
				this.usuarioService.salvarUsuario(usuario);
				redirectAttributes.addFlashAttribute("message", "Usuário cadastrado com sucesso!");
			} catch (ServiceException | MessagingException e) {
				redirectAttributes.addFlashAttribute("message", "Não foi possível criar usuário: " + e.getMessage());
				System.out.println(e.getMessage());
				redirectAttributes.addFlashAttribute("usuario", usuario);
                 
				return "redirect:/cadUsuario";
			}
		}
		
		return "redirect:/confirmacaoEmail";
	}
	
	@GetMapping("/ativarConta")
	public String ativarConta(@RequestParam(name = "token", required = false) String token, RedirectAttributes ra) throws ServiceException, MessagingException {

		if (token == "" || token == null) {
			ra.addFlashAttribute("alertErro", "Token de ativação inválido");
			
			return "redirect:/";
		}

		Email email = this.emailService.findByToken(token);

//		
//		if (this.emailService.validarVencimento(email)) {
			Usuario usuario = this.usuarioService.verificacaoEmail(email.getEmailDestinatario());
			System.out.println(usuario.getEmail());
			usuario.setAtivo(1);
			System.out.println("aqui");

			usuario.setNome(usuario.getNome());
			this.usuarioDAO.save(usuario);
//		} else {
//			ra.addFlashAttribute("alertErro", "Token de ativação vencido, por favor re-envie o email de ativação");
//			return "redirect:/cadastro/ativar";
//		}

		ra.addFlashAttribute("alertSucesso", "Conta Ativada com sucesso!");
		return "redirect:/loginusuario";
	}
		
		
	@PostMapping("/usuariosLogin")
	public String usuarioLogin(HttpServletRequest request, Usuario usuario, @RequestParam(name = "retorno", required = false) String retorno, RedirectAttributes ra, HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		
		String tela ="";
		try {
			
			boolean usuarioativo = false;
			boolean postoativo = false;
			boolean agenteativo = false;
			int contador = 0;
			
			
			Usuario usuariologin = this.usuarioService.logarUsuario(usuario.getEmail(), usuario.getSenha());
			Posto posto = this.postoService.logarPosto(usuario.getEmail(), usuario.getSenha());
			Agente agente = this.agenteService.logarAgente(usuario.getEmail(), usuario.getSenha());
			if(usuariologin != null && usuariologin.getAtivo() == 1) {
				usuarioativo = true;
				session.setAttribute("usuario", usuariologin);
				System.out.println(session+"ususario");
				ra.addFlashAttribute("usuario", "login com sucesso");

				contador ++;
				tela = "redirect:/paginainicial";
			}
			
			if(posto != null) {
				postoativo = true;
				session.setAttribute("postoLogado", posto);
				ra.addFlashAttribute("posto", "login com sucesso");
				contador ++;
				System.out.println(session +"posto");

				tela = "redirect:/admposto";
			}
			
			if(agente != null) {
				agenteativo = true;
				session.setAttribute("agentelogado", agente);
				ra.addFlashAttribute("agente", "logado");
				contador ++;
				System.out.println(session+"agente");
				tela = "redirect:/admposto";
			}
			
			
			
			if(!usuarioativo && !postoativo && !agenteativo) {
				throw new ServiceException("Login/senha não encontrados");
			}
			
			if(contador > 1) {
				tela = "redirect:/admlogin";
				//ra.addFlashAttribute("usuarioexibir", usuarioativo);
				//ra.addFlashAttribute("postoexibir", postoativo);
				//ra.addFlashAttribute("agenteexibir", agenteativo);

			}
			
			
			
			
		} catch (ServiceException e) {
			ra.addFlashAttribute("mensagemErro", e.getMessage());
			System.out.println(e.getMessage());

			return "redirect:/loginusuario";
		}


		return tela;
	}

	
		
	@GetMapping("/deslogar")
	public String deslogar(Usuario usuario,HttpSession session) {
		session.invalidate();
		System.out.println(session);

		return "redirect:/paginainicial";
	}
	
	@PostMapping("/perfil/editar")
	public String editarPefil(@ModelAttribute Usuario usuario,RedirectAttributes ra,HttpSession session, BindingResult result) {
		
		if (result.hasErrors()) {
			return "redirect:/editalPerfil";
		}

		Usuario usuarioSessao = (Usuario) session.getAttribute("usuario");
		usuario.setId(usuarioSessao.getId());
		usuario = this.usuarioService.editarPerfil(usuario,session);
		session.setAttribute("usuario", usuario);
		ra.addFlashAttribute("sucesso", "Alteração realizada com sucesso");
		
		return"redirect:/perfilusuario";
	}
	
	@GetMapping("/editarPerfil")
	public ModelAndView exibirEditarPerfil(HttpSession session,RedirectAttributes ra) {
		
		ModelAndView mv= new ModelAndView("editar-perfil");
		if (session.getAttribute("usuario")==null) {
			
			ra.addFlashAttribute("acessoNegado", true);
			ra.addFlashAttribute("retorno", "/editarPefil");
		mv.setViewName("/redirect:/usuariosLogin");
		return mv;
		
		}
			Object usuario;
			Usuario usuario1=(Usuario) session.getAttribute("usuario");
		
			mv.addObject(usuario1);
			return mv;
	
		
	}
	
	
	
	
	
	@GetMapping("/perfilusuario")
	public String perfilusuario() {
		return"/perfil-usuario";
	}
}
