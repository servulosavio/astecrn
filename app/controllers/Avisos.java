package controllers;

import java.util.List;

import models.Assistencia;
import models.Associado;
import models.Aviso;
import play.data.validation.Valid;
import play.mvc.Controller;

public class Avisos extends Controller {
	
	public static void novo_aviso() {
		render();
	}
	
	public static void salvar(@Valid Aviso aviso) {
		
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			novo_aviso();
		}
		
		aviso.save();
		flash.success("Aviso Salvo com Sucesso!");
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
		flash.success("Aviso Removido com Sucesso!");
		listar_avisos();
	}
	
	
	public  static  void  anexoAvisos(Long  id) {
	    Aviso aviso = Aviso.findById(id);
	    notFoundIfNull(aviso);
	    response.setContentTypeIfNotSet(aviso.anexo.type());
	    renderBinary(aviso.anexo.get());
	}
	
}
