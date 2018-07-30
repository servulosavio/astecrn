package models;

import javax.persistence.Entity;

import enums.TipoDownload;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Download extends Model {

	public TipoDownload tipo;
	public String titulo;
	public String marca;
	public String modelo;
	public Blob arquivo;
	
}
