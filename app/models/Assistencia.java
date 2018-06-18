package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Assistencia extends Model {
	
	public String razaoSocial;
	public String nomeFantasia;
	public String cnpj;
	public String telefone;
	public String rua;
	public int numero;
	public String complemento;
	public String bairro;
	public String cep;
	public String cidade;
	public String estado;
	
	@Override
	public String toString() {
		return nomeFantasia;
	}

}
