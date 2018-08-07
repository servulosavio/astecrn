package controllers;

import annotations.Administrador;
import enums.Status;
import enums.TipoUsuario;
import models.Usuario;
import play.mvc.Before;
import play.mvc.Controller;

public class Sessao extends Controller {
	
	@Before(unless="login")
	static void checarAutenticacao() {
		if (session.get("usuario") == null) {
			flash.error("É necessário fazer login");
			Application.login();
		}
	}
	
	@Before
	static void checarAdministrador() {
		
		String usuario = session.get("usuario");
		String tipo = session.get("tipo");
//		Admin admin = getControllerAnnotation(Admin.class);
		
		boolean seguranca = getControllerAnnotation(Administrador.class) != null ||
				   			getActionAnnotation(Administrador.class) != null;
		
		System.out.println(tipo);
		System.out.println(seguranca);
		System.out.println(usuario);
		if(seguranca && usuario == null) {
			flash.error("Por favor, entre com seu login e senha.");
			Application.login();
		}
		if(seguranca && tipo.equals(TipoUsuario.ASSOCIADO.toString())) {
			flash.error("Usuário sem permissão para essa tarefa");
			Usuarios.gerenciador();
		}
		
		

	}

	
	public static void login(String login, String senha) {
		Usuario usuario = Usuario.find("login = ? and senha = ?", login, senha).first();
		if(usuario == null) {
			flash.error("Usuário ou Senha inválidos, favor tente novamente");
			Application.login();
		} 
		if (usuario.status == Status.INATIVO) {
			flash.error("Usuário inativo, contate o administrador");
			Application.login();
		}
		
//		if (usuario.tipoUsuario == TipoUsuario.ASSOCIADO) {
//			session.put("usuario", usuario);
//			/*session.put("nome", usuario.);*/
//			session.put("login", usuario.login);
//			Usuarios.associados();			
//		}
		
		else {
			session.put("usuario", usuario);
			session.put("tipo", usuario.tipoUsuario);
			session.put("login", usuario.login);
			session.put("foto", usuario.foto);
			Usuarios.gerenciador();
		}
	}
	
	public static void logout() {
		session.clear();
		Application.index();
	}

}
