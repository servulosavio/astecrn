package models;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Aviso extends Model {
	
	@Required
	public String assunto;
	
	@Required
	public String mensagem;
	
	
	public Blob anexo;
	

}
