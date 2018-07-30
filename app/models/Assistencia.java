package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Assistencia extends Model {
	
	public String razaoSocial;
	public String nomeFantasia;
	public String cnpj;
	public String telefone;
	public String rua;
	public String numero;
	public String complemento;
	public String bairro;
	public String cep;
	public String cidade;
	public String estado;
	
	@Override
	public String toString() {
		return nomeFantasia;
	}
	
	@OneToMany(mappedBy="assistencia")
	public List<Associado> associados;

}
