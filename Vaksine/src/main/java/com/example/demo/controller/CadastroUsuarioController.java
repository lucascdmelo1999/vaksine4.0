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

import com.example.demo.dao.UsuarioDAO;
import com.example.demo.model.Agente;
import com.example.demo.model.Usuario;
import com.example.demo.serviceImpl.UsuarioServiceImpl;


@Controller
public class CadastroUsuarioController {
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private UsuarioServiceImpl usuarioService;

@Autowired
private UsuarioDAO usuarioDAO;

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


		redirectAttributes.addFlashAttribute("message", "Failed");
		redirectAttributes.addFlashAttribute("alertClass", "alert-danger");

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
		/*SimpleMailMessage msg = new SimpleMailMessage();
				msg.setTo(email);
				msg.setSubject("Confirmação de conta");
				msg.setText("obg");

				javaMailSender.send(msg);
		redirectAttributes.addFlashAttribute("Usuário cadastrado", true);*/
		return "redirect:/cadUsuario";
	}
		
		
		
	@PostMapping("/participanteLogin")
	public String usuarioLogin(HttpServletRequest request, Usuario usuario, @RequestParam(name = "retorno", required = false) String retorno, RedirectAttributes ra, HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		String redirect = "redirect:/paginainicial";
		if (retorno != null) {
			redirect = "redirect:" + retorno;
		}

		try {
			if(usuario.getCpf().equals("000.000.000-00") && usuario.getSenha().equals("123")) {
				return "loginAdm";
			}else {
				
				usuario = this.usuarioService.logarUsuario(usuario.getCpf(), usuario.getSenha());
				session.setAttribute("usuarioLogado", usuario);
				ra.addFlashAttribute("mensagem", "logado");
				System.out.println(session);
			}
		} catch (ServiceException e) {
			ra.addFlashAttribute("mensagemErro", e.getMessage());
			System.out.println(e.getMessage());

			return "redirect:/loginusuario";
		}

		ra.addFlashAttribute("loginEfetuado", true);
		return redirect;
	}

		
	@GetMapping("/deslogar")
	public String deslogar(Usuario usuario,HttpSession session) {
		session.invalidate();
		System.out.println(session);

		return "redirect:/paginainicial";
	}
	
	@PostMapping("/perfil/editar")
	public String editarPefil(@ModelAttribute Usuario usuario,RedirectAttributes ra,HttpSession session) {

		Usuario usuarioSessao = (Usuario) session.getAttribute("usuarioLogado");
		usuario.setId(usuarioSessao.getId());
		usuario = this.usuarioService.editarPerfil(usuario,session);
		this.usuarioService.save(usuario);
		session.setAttribute("usuarioLogado", usuario);
		ra.addFlashAttribute("sucesso", "Alteração realizada com sucesso");
		
		return"redirect:/editarPerfil";
	}
	
	@GetMapping("/editarPerfil")
	public ModelAndView exibirEditarPerfil(HttpSession session,RedirectAttributes ra) {
		
		ModelAndView mv= new ModelAndView("cadastro-usuario");
		if (session.getAttribute("usuarioLogado")==null) {
			
			ra.addFlashAttribute("acessoNegado", true);
			ra.addFlashAttribute("retorno", "/editarPefil");
		mv.setViewName("/redirect:/participanteLogin");
		return mv;
		
		}
		Usuario usuario=(Usuario) session.getAttribute("usuarioLogado");
		mv.addObject(usuario);
		return mv;
	}
	
	@GetMapping("/perfilusuario")
	public String perfilusuario() {
		return"/perfil-usuario";
	}
}

