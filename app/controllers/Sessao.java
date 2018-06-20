package controllers;

import enums.Status;
import models.Usuario;
import play.mvc.Controller;

public class Sessao extends Controller {
	
	public static void login(String login, String senha) {
		Usuario usuario = Usuario.find("login = ? and senha = ?", login, senha).first();
		if(usuario == null) {
			flash.error("Usuário ou Senha inválidos, favor tente novamente");
			session.put("usuario", usuario);
			Application.login();
		} 
		if (usuario.status == Status.INATIVO) {
			flash.error("Usuário inativo, contate o administrador");
			Application.login();
		}else {
			Application.gerenciador();
		}
	}
	
	public static void logout() {
		Application.index();
	}

}
