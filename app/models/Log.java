package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Log extends Model {
	
	public String usuario;
	
	public Date data;
	
	public String acao;
	
}
