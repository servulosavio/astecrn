package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Cliente extends Model {
	
	public String nome;
	public String cpf;
	public String rg;
	public Date dt_nascimento;
	public enum estado_civil {
		SOLTEIRO, CASADO, DIVORCIADO, VIUVO;
	}
	
	public String telefone;
	public String cidade;
	public String assistencia;

}
