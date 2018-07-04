package controllers;

import java.util.List;

import models.Assistencia;
import models.Associado;
import models.Aviso;
import play.mvc.Controller;

public class Avisos extends Controller {
	
	public static void novo_aviso() {
		render();
	}
	
	public static void salvar(Aviso aviso) {
		aviso.save();
		listar_avisos();
	}
	
	public static void listar_avisos() {
		List<Aviso> avisos = Aviso.findAll();
		render(avisos);
	}
	
	public static void detalhes_aviso(Long id) {
		Aviso aviso = Aviso.findById(id);
		renderTemplate("Avisos/detalhes_aviso.html", aviso);
	}
	
	public static void editar_aviso(Long id) {
		Aviso aviso = Aviso.findById(id);
		List<Aviso> avisos = Aviso.findAll();
		renderTemplate("Avisos/novo_aviso.html", aviso, avisos);
	}
	
	public static void remover_aviso(Long id) {
		Aviso aviso = Aviso.findById(id);
		aviso.delete();
		listar_avisos();
	}
	
	
}
