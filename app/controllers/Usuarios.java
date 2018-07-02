package controllers;

import models.Assistencia;
import models.Associado;
import models.Usuario;
import play.mvc.Controller;
import play.mvc.With;

@With(Sessao.class)

public class Usuarios extends Controller {
		
	public static void gerenciador() {
    	long assistenciasCount = Assistencia.count();
    	long associadosCount = Associado.count();
//    	String usuario.login(); = Associado.class.toString();
//    	render(usuarioNome);*
    	System.out.println(session.get("usuario"));
    	render(assistenciasCount, associadosCount);
    }
		
		

}
