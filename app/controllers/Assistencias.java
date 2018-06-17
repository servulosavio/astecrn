package controllers;

import java.util.List;

import models.Assistencia;
import play.mvc.Controller;

public class Assistencias extends Controller {
	 
	public static void nova_assistencia(Assistencia assistencia) {
		render(assistencia);
	}
	
	public static void salvar(Assistencia assistencia) {
		assistencia.save();
		listar_assistencias();
		
	}
	
	public static void editar(Long id) {
		Assistencia assistencia = Assistencia.findById(id);
		renderTemplate("Assistencias/nova_assistencia.html", assistencia);
	}
	
	public static void detalhes(Long id) {
		Assistencia assistencia = Assistencia.findById(id);
		renderTemplate("Assistencia/detalhes.html", assistencia);
	}
	
	public static void listar_assistencias() {
		List<Assistencia> assistencias = Assistencia.findAll();
		render(assistencias);
	}
	
	public static void remover(Long id) {
		Assistencia assistencia = Assistencia.findById(id);
		assistencia.delete();
		listar_assistencias();
	}
	
}
