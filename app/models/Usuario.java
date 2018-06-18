package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enums.Status;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model {
	
	public String login;
	public String senha;
	public Blob foto;
	public Blob documentos;
	
	@Enumerated(EnumType.STRING)
	public Status status;
	
}




