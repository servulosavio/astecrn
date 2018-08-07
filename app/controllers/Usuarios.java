package controllers;

import java.math.BigDecimal;
import java.util.List;

import annotations.Administrador;
import interceptors.Seguranca;
import models.Assistencia;
import models.Associado;
import models.Aviso;
import models.Usuario;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Usuarios extends Controller {
	
	
	public static void gerenciador() {
    	long assistenciasCount = Assistencia.count();
    	long associadosCount = Associado.count();
    	BigDecimal saldo = Caixas.getSaldo();
    	List<Aviso> avisos = Aviso.findAll();

		
//    	String usuario.login(); = Associado.class.toString();
//    	render(usuarioNome);*
    	System.out.println(session.get("usuario"));
    	render(assistenciasCount, associadosCount, avisos, saldo);
    }
	
	public  static  void  foto(Long  id) {
		Usuario usuarios = Usuario.findById(id);
        notFoundIfNull(usuarios);
        response.setContentTypeIfNotSet(usuarios.foto.type());
        renderBinary(usuarios.foto.get());
	}
		
		

}
