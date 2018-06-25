package controllers;

import java.util.List;

import org.eclipse.jdt.internal.codeassist.impl.AssistCompilationUnit;

import enums.Status;
import models.Assistencia;
import models.Associado;
import play.mvc.Controller;
import play.mvc.With;

@With(Sessao.class)

public class Associados extends Controller {
	
	public static void novo(Associado associado) {
		List<Assistencia> assistencias = Assistencia.findAll();
		render(associado, assistencias);
	}
	
	public static void salvar(Associado associado) {
		System.out.println(params.get("excluirFoto"));
		if(params.get("excluirFoto") != null) {
			associado.foto.getFile().delete();
		}
		if(params.get("status") != null) {
			associado.status = Status.ATIVO;
		} else {
			associado.status = Status.INATIVO;
		}
		associado.save();
		listar();
		
	}
	
	public static void editar(Long id) {
		Associado associado = Associado.findById(id);
		List<Assistencia> assistencias = Assistencia.findAll();
		renderTemplate("Associados/novo.html", associado, assistencias);
	}
	
	public static void detalhes(Long id) {
		Associado associado = Associado.findById(id);
		renderTemplate("Associados/detalhes.html", associado);
	}
	
	public static void listar() {
		List<Associado> associados = Associado.findAll();
		List<Assistencia> assistencias = Assistencia.findAll();
		render(associados, assistencias);
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
	
	public  static  void  fotoAssociados(Long  id) {
	    Associado associado = Associado.findById(id);
	    notFoundIfNull(associado);
	    response.setContentTypeIfNotSet(associado.foto.type());
	    renderBinary(associado.foto.get());
	}
	
	
}
