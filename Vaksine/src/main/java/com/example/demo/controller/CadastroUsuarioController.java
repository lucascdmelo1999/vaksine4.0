package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.UsuarioDAO;
import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

@Controller
public class CadastroUsuarioController {
	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioDAO usuarioDAO;

	@GetMapping("/cadUsuario")
	public String cadastro(Model model, Usuario usuario) {

		return "cadastro-usuario";

	}

	@PostMapping("/cad")
	public String cadastrar(@Valid Usuario usuario, BindingResult result, RedirectAttributes redirectAttributes,
			String email) {


		redirectAttributes.addFlashAttribute("message", "Failed");
		redirectAttributes.addFlashAttribute("alertClass", "alert-danger");

		if (result.hasErrors()) {
			return "redirect:/cadUsuario";
		}
		boolean retorno = this.usuarioService.salvarUsuario(usuario);
		if (retorno == false) {
			redirectAttributes.addFlashAttribute("message", "Já existe um Usuario com este email");
			redirectAttributes.addFlashAttribute("usuario", usuario);
			return "redirect:/cadUsuario";

		}

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setSubject("Confirmação de conta");
		msg.setText("obg");

		javaMailSender.send(msg);

		redirectAttributes.addFlashAttribute("message", "Cadastro realizado com sucesso");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "redirect:/cadUsuario";

	}

}
