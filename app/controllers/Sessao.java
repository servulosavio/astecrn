package controllers;

import models.Usuario;
import play.mvc.Controller;

public class Sessao extends Controller {
	
	public static void login(String login, String senha) {
		Usuario usuario = Usuario.find("login = ? and senha = ?", login, senha).first();
		if(usuario == null) {
			flash.error("Login ou Senha inválidos");
			Application.index();
		} else {
			Application.gerenciador();
		}
	}
	
	public static void logout() {
		Application.index();
	}

}
