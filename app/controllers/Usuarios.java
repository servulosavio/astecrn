package controllers;

import models.Usuario;
import play.mvc.Controller;

public class Usuarios extends Controller {
		
		public static void login(String login, String senha) {
			Usuario usuario = Usuario.find("login = ? and senha = ?", login, senha).first();
			if(usuario == null) {
				Application.index();
			} else {
				Application.gerenciador();
			}
		}
		
		public static void logout() {
			Application.index();
		}
		
		

}
