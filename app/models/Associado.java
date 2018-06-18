package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@Entity
public class Associado extends Usuario {
	
	public String nome;
	public String cpf;
	public String rg;
	
	@Temporal(TemporalType.DATE)
	public Date dt_nascimento;
	
	public String estado_civil;	
	public String telefone;
	public String cidade;
	
	@ManyToOne
	public Assistencia assistencia;
	
	@Override
	public String toString() {
		return nome;
	}
	

}
