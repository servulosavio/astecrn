package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Usuario extends Model {
	
	public String login;
	public String senha;
	public boolean estado;
	
}




