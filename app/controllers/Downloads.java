package controllers;

import java.util.List;

import models.Aviso;
import models.Download;
import play.mvc.Controller;

public class Downloads extends Controller {
	
	public static void novo_download() {
		render();
	}
	
	public static void salvar(Download download) {
		download.save();
		flash.success("Aviso Salvo com Sucesso!");
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
		listar_downloads();
	}
	
	public  static  void  anexoDownloads(Long  id) {
	    Download download = Download.findById(id);
	    notFoundIfNull(download);
	    response.setContentTypeIfNotSet(download.arquivo.type());
	    renderBinary(download.arquivo.get());
	}

}
