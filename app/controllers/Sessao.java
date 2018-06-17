package controllers;

import models.Usuario;
import play.mvc.Controller;

public class Sessao extends Controller {
	
	public static void login(String login, String senha) {
		Usuario usuario = Usuario.find("login = ? and senha = ?", login, senha).first();
		if(usuario == null) {
			flash.error("Usuário ou Senha inválidos, favor tente novamente");
			Application.login();
		} else {
			Application.gerenciador();
		}
	}
	
	public static void logout() {
		Application.index();
	}

}
