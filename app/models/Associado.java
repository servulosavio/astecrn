package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Associado extends Usuario {
	
	public String nome;
	public String cpf;
	public String rg;
	public String dt_nascimento;
	public String estado_civil;	
	public String telefone;
	public String cidade;
	Assistencia assistencia;
	
	

}
