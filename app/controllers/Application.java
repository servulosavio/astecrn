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
    	/*String usuarioNome = Associado.class.toString();
    	render(usuarioNome);*/
    	render();
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