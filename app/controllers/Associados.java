package controllers;

import java.util.Date;
import java.util.List;



import org.eclipse.jdt.internal.codeassist.impl.AssistCompilationUnit;

import annotations.Administrador;
import enums.Movimentacao;
import enums.Status;
import enums.TipoUsuario;
import interceptors.Seguranca;
import models.Assistencia;
import models.Associado;
import models.Log;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;


@With(Sessao.class)

public class Associados extends Controller {
	
	@Administrador
	public static void novo(Associado associado) {
		List<Assistencia> assistencias = Assistencia.findAll();
		render(associado, assistencias);
	}
	
	@Administrador
	public static void salvar(@Valid Associado associado) {
		System.out.println(params.get("excluirFoto"));
		System.out.println(validation.hasErrors());
			
		
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			novo(associado);
		}
		
		if(params.get("excluirFoto") != null) {
			associado.foto.getFile().delete();
		}
		if(params.get("status") != null) {
			associado.status = Status.ATIVO;
		} else {
			associado.status = Status.INATIVO;
		}
		
		
		if (associado.tipoUsuario.equals(TipoUsuario.ADMINISTRADOR)){
			associado.tipoUsuario = TipoUsuario.ADMINISTRADOR;			
		}else {
			associado.tipoUsuario = TipoUsuario.ASSOCIADO;
		}
			
		
		associado.save();
		flash.success("Cadastro Salvo com Sucesso!");
		Log log = new Log() ;
		log.acao = "CADASTROU/EDITOU O ASSOCIADO: " + associado;
		log.data = new Date();
		log.usuario = session.get("usuario");
		log.save();
		listar();
		
	}
	
	@Administrador
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
	
	@Administrador
	public static void inativar(Long id) {
		Associado associado = Associado.findById(id);
		associado.status = Status.INATIVO;
		associado.save();
		flash.success("O Associado foi Inativado com Sucesso!");
		Log log = new Log() ;
		log.acao = "INATIVOU O ASSOCIADO: " + associado;
		log.data = new Date();
		log.usuario = session.get("usuario");
		log.save();
		listar();
	}
	
	@Administrador
	public static void ativar(Long id) {
		Associado associado = Associado.findById(id);
		associado.status = Status.ATIVO;
		associado.save();
		flash.success("O Associado foi Ativado com Sucesso!");
		Log log = new Log() ;
		log.acao = "ATIVOU O ASSOCIADO: " + associado;
		log.data = new Date();
		log.usuario = session.get("usuario");
		log.save();
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
	
	public  static  void  documentosAssociados(Long  id) {
	    Associado associado = Associado.findById(id);
	    notFoundIfNull(associado);
	    response.setContentTypeIfNotSet(associado.documentos.type());
	    renderBinary(associado.documentos.get());
	}
	
	
}
