package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Associado extends Usuario {
	
	@Required
	public String nome;
	
	@Required
	public String cpf;
	
	@Required
	public String rg;
	
	@Required
	@Temporal(TemporalType.DATE)
	public Date dtNascimento;
	
	@Required
	public String estado_civil;	
	
	@Required
	public String telefone;
	
	@Required
	public String cidade;
	
	@Required
	@ManyToOne
	public Assistencia assistencia;
	
	@OneToMany(mappedBy="associado")
	public List<Pagamento> pagamentos;
	
	@Override
	public String toString() {
		return nome;
	}
	
	
	 
}
