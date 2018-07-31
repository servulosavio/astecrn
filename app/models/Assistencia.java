package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Assistencia extends Model {
	
	@Required
	public String razaoSocial;
	
	@Required
	public String nomeFantasia;
	
	@Required
	public String cnpj;
	
	@Required
	public String telefone;
	
	@Required
	public String rua;
	
	@Required
	public String numero;
	
	public String complemento;
	
	@Required
	public String bairro;
	
	@Required
	public String cep;
	
	@Required
	public String cidade;
	
	@Required
	public String estado;
	
	@Override
	public String toString() {
		return nomeFantasia;
	}
	
	@OneToMany(mappedBy="assistencia")
	public List<Associado> associados;

}
