package models;

import javax.persistence.Entity;

import enums.TipoDownload;
import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Download extends Model {

	@Required
	public TipoDownload tipo;
	
	@Required
	public String titulo;
	
	@Required
	public String marca;
	
	@Required
	public String modelo;
	
	@Required
	public Blob arquivo;
	
}
