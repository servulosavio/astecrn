package models;

import javax.persistence.Entity;

import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Aviso extends Model {
	
	public String assunto;
	public String mensagem;
	public Blob anexo;
	

}
