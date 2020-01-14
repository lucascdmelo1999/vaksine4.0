package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@Controller
public class CadastroUsuarioController {
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private UsuarioService usuarioService;



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
			usuario = this.usuarioService.logarUsuario(usuario.getCpf(), usuario.getSenha());
			session.setAttribute("usuarioLogado", usuario);
			ra.addFlashAttribute("mensagem", "logado");
			System.out.println(session);
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
	

	}

