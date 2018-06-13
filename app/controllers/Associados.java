package controllers;

import java.util.List;

import models.Associado;
import models.Cliente;
import play.mvc.Controller;

public class Associados extends Controller {
	
	public static void novo(Associado associado) {
		render(associado);
	}
	
	public static void salvar(Associado associado) {
		associado.save();
		listar();
		
	}
	
	public static void editar(Long id) {
		Associado associado = Associado.findById(id);
		renderTemplate("Associados/novo.html", associado);
	}
	
	public static void detalhes(Associado associado) {
		render(associado);
	}
	
	public static void listar() {
		List<Associado> associados = Associado.findAll();
		render(associados);
	}
	
	public static void remover(Long id) {
		Associado associado = Associado.findById(id);
		associado.delete();
		listar();
	}
	
	public static void associados() {
		List<Associado> associados = Associado.findAll();
		render(associados);
	}
	
}
