package controllers;

import enums.Status;
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
	
	public static void login(String login, String senha) {
		Usuario usuario = Usuario.find("login = ? and senha = ?", login, senha).first();
		if(usuario == null) {
			flash.error("Usuário ou Senha inválidos, favor tente novamente");
			Application.login();
		} 
		if (usuario.status == Status.INATIVO) {
			flash.error("Usuário inativo, contate o administrador");
			Application.login();
		}else {
			session.put("usuario", usuario);
			/*session.put("nome", usuario.);*/
			session.put("login", usuario.login);
			Usuarios.gerenciador();
		}
	}
	
	public static void logout() {
		session.clear();
		Application.index();
	}

}
