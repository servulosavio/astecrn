package interceptors;

import annotations.Administrador;
import controllers.Application;
import controllers.Sessao;
import controllers.Usuarios;
import enums.TipoUsuario;
import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller {
	
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

}
