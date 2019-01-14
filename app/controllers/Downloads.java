package controllers;

import java.util.Date;
import java.util.List;

import models.Aviso;
import models.Download;
import models.Log;
import play.data.validation.Valid;
import play.mvc.Controller;
import play.mvc.With;

@With(Sessao.class)

public class Downloads extends Controller {
	
	public static void novo_download() {
		render();
	}
	
	public static void salvar(@Valid Download download) {
		
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			novo_download();
		}
		
		download.save();
		flash.success("Aviso Salvo com Sucesso!");
		Log log = new Log() ;
		log.acao = "CADASTROU/EDITOU O ARQUIVO: " + download.titulo;
		log.data = new Date();
		log.usuario = session.get("usuario");
		log.save();
		listar_downloads();
	}
	
	public static void listar_downloads() {
		List<Download> downloads = Download.findAll();
		render(downloads);
	}
	
	public static void detalhes_downloads(Long id) {
		Download download = Download.findById(id);
		renderTemplate("Avisos/detalhes_aviso.html", download);
	}
	
	public static void editar_download(Long id) {
		Download download = Download.findById(id);
		List<Download> downloads = Download.findAll();
		renderTemplate("Avisos/novo_aviso.html", download, downloads);
	}
	
	public static void remover_downloads(Long id) {
		Download download = Download.findById(id);
		download.delete();
		flash.success("Aviso Removido com Sucesso!");
		Log log = new Log() ;
		log.acao = "REMOVEU O ARQUIVO: " + download.titulo;
		log.data = new Date();
		log.usuario = session.get("usuario");
		log.save();
		listar_downloads();
	}
	
	public  static  void  anexoDownloads(Long  id) {
	    Download download = Download.findById(id);
	    notFoundIfNull(download);
	    response.setContentTypeIfNotSet(download.arquivo.type());
	    renderBinary(download.arquivo.get());
	    Log log = new Log() ;
		log.acao = "FEZ DOWNLOAD DO ARQUIVO: " + download.titulo;
		log.data = new Date();
		log.usuario = session.get("usuario");
		log.save();
	}

}
