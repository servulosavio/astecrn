package models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import enums.Status;
import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Usuario extends Model {
	
	@Required
	public String login;
	
	@Required
	public String senha;
	public Blob foto;
	public Blob documentos;
	
	@Enumerated(EnumType.STRING)
	public Status status;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return login;
	}
	
}




