package acesso;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import com.example.demo.model.Agente;
import com.example.demo.model.Funcao;
import com.example.demo.model.Posto;
import com.example.demo.model.Usuario;

//public class Acesso implements HandlerInterceptor {

	//private static final boolean Controlador_Acesso = true;

	//private static final String[] RECURSOS_Livres = { "/paginainicial", "/contato", "/quemsomos", "/cadUsuario","/cad",
			//"/usuariosLogin", "/naoencontrada", "/loginusuario" ,"/ativarConta","/deslogar","/ativarConta","/confirmacaoEmail"};
//
	//private static final String RECURSOS_Login = "/usuariosLogin";

	//private static final String[] RECURSOS_User = {"/ativarConta", "/perfil/editar","/editarPerfil","/perfilusuario","/cartao"};

	//private static final String[] RECURSOS_Agente = { "/vacinaform", "/cadastroposto", "/editarFormVacina",
		//	"/vacinacaoDeletar", "/vacinalist", "/pesquisarvacina", "vacinaCadastro", "/vacinaEditar", "/editarvacina",
		//	"/deletarvacina" };
//
	//private static final String[] RECURSOS_Posto = { "/posto", "/cadAgente", "/cadastroAgente" };

	//@Override
	//public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		//	throws Exception {

		// libera tudo na pasta static
		//if (handler instanceof ResourceHttpRequestHandler) {
		//	return true;
		//}
//
		// para acessar qualquer pagina dessa aplicação, o usuário precisa estar
		// autenticado
		//for (String recurso : RECURSOS_Livres) {

			//for (String re : RECURSOS_User) {
				//if (request.getRequestURL().toString().endsWith(recurso)
					//	&& !request.getRequestURL().toString().contains(re)) {

					//return true;
				//}
		//	}
			//for (String re : RECURSOS_Agente) {
				//if (request.getRequestURL().toString().endsWith(recurso)
					//	&& !request.getRequestURL().toString().contains(re)) {
					//return true;

			//	}
		//	}

			//for (String re : RECURSOS_Posto) {
			//	if (request.getRequestURL().toString().endsWith(recurso)
					//	&& !request.getRequestURL().toString().contains(re)) {
					//return true;

				//}
		//	}

	//	}

		//if (request.getRequestURL().toString().endsWith(RECURSOS_Login)
				//&& request.getSession().getAttribute("usuario") == null) {

			//return true;
	//	}

		//if (request.getSession().getAttribute("usuario") == null) {

			//request.getRequestDispatcher("/naoencontrada").forward(request, response);
			//return false;
		//}
			
		//if (request.getSession().getAttribute("usuario") instanceof Usuario) {
			//Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			
			//System.out.println( usuario.getFuncao());
			//System.out.println(Funcao.Usuario);
			//for (String re : RECURSOS_User) {
				//if (request.getRequestURL().toString().contains(re) && usuario.getFuncao().equals(Funcao.Usuario)) {

				//	return true;

				//}
			//}
	//	}

		//if (request.getSession().getAttribute("usuario") instanceof Agente) {
		//	Agente agente = (Agente) request.getSession().getAttribute("usuario");
			//for (String re : RECURSOS_Agente) {
				//if (request.getRequestURL().toString().contains(re) && agente.getFuncao().equals(Funcao.Agente)) {

					//return true;
				//}
			//}
	//	}
////
		//if (request.getSession().getAttribute("usuario") instanceof Posto) {
			//Posto posto = (Posto) request.getSession().getAttribute("usuario");
			//for (String re : RECURSOS_Posto) {
			//	if (request.getRequestURL().toString().contains(re) && posto.getFuncao().equals(Funcao.Posto)) {

				//	//return true;
				//}
			//}
		//}
		//	request.getRequestDispatcher("/naoencontrada").forward(request, response);
		
		//return false;

		
//	}
//}
