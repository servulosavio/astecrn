package controllers;

import java.util.List;

import models.Assistencia;
import models.Associado;
import play.mvc.Controller;
import play.mvc.With;


@With(Sessao.class)

public class Assistencias extends Controller {
	 
	public static void nova_assistencia(Assistencia assistencia) {
		render(assistencia);
	}
	
	public static void salvar(Assistencia assistencia) {
		assistencia.save();
		flash.success("Cadastro Salvo com Sucesso!");
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
		listar_assistencias();
	}
}
