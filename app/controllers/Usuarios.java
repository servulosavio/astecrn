package controllers;

import models.Usuario;
import play.mvc.Controller;

public class Usuarios extends Controller {

		public static void login(Usuario usuario) {
			if (usuario.getLogin().equals("admin") && usuario.getSenha().equals("123")) {
				renderTemplate("/Application/gerenciador.html");
				//redirect("@{Application.gerenciador}");
			} else {
				System.out.println("Usuário ou Senha inválidos");
			}
			
		}

}
