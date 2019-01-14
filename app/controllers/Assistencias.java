package controllers;

import java.util.Date;
import java.util.List;

import models.Assistencia;
import models.Associado;
import models.Log;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;


@With(Sessao.class)

public class Assistencias extends Controller {
	 
	public static void nova_assistencia(Assistencia assistencia) {
		render(assistencia);
	}
	
	public static void salvar(@Valid Assistencia assistencia) {
		
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			nova_assistencia(assistencia);
		}
		
		assistencia.save();
		flash.success("Cadastro Salvo com Sucesso!");
		Log log = new Log() ;
		log.acao = "CADASTROU/EDITOU A ASSISTÊNCIA: " + assistencia;
		log.data = new Date();
		log.usuario = session.get("usuario");
		log.save();
		listar_assistencias();
		
	}
	
	public static void editar(Long id) {
		Assistencia assistencia = Assistencia.findById(id);
		renderTemplate("Assistencias/nova_assistencia.html", assistencia);
	}
	
	public static void detalhes(Long id) {
		Assistencia assistencia = Assistencia.findById(id);
		renderTemplate("Assistencias/detalhes_assistencia.html", assistencia);
	}
	
	public static void listar_assistencias() {
		List<Assistencia> assistencias = Assistencia.findAll();
		render(assistencias);
	}
	
	public static void remover(Long id) {
		Assistencia assistencia = Assistencia.findById(id);
		for(Associado associado: assistencia.associados) {
			associado.assistencia = null;
			associado.save();
		}	
		assistencia.delete();
		flash.success("Cadastro Removido com Sucesso!");
		Log log = new Log() ;
		log.acao = "REMOVEU A ASSISTÊNCIA: " + assistencia;
		log.data = new Date();
		log.usuario = session.get("usuario");
		log.save();
		listar_assistencias();
	}
}
