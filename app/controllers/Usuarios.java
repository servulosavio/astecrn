package controllers;

import models.Usuario;
import play.mvc.Controller;

public class Usuarios extends Controller {
		
		public static void login(String login, String senha) {
			Usuario usuario = Usuario.find("login = ? and senha = ?", login, senha).first();
			if(usuario == null) {
				renderTemplate("/Application/index.html");
			} else {
				renderTemplate("/Application/gerenciador.html");
			}
		}
//			Application.gerenciador();
			

}
