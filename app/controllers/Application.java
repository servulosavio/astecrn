package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void gerenciador() {
    	long assistenciasCount = Assistencia.count();
    	long associadosCount = Associado.count();
//    	String usuario.login(); = Associado.class.toString();
//    	render(usuarioNome);*
    	System.out.println(session.get("usuario"));
    	render(assistenciasCount, associadosCount);
    }
    
    public static void contato() {
    	render();
    }
    
    public static void associados() {
		List<Associado> associados = Associado.findAll();
		render(associados);
	}
    
    public static void login() {
        render();
    }
    
    

}