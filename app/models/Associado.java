package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@Entity
public class Associado extends Usuario {
	
	public String nome;
	public String cpf;
	public String rg;
	
	@Temporal(TemporalType.DATE)
	public Date dtNascimento;
	
	public String estado_civil;	
	public String telefone;
	public String cidade;
	
	@ManyToOne
	public Assistencia assistencia;
	
	/*@OneToMany
	public List<Pagamento> pagamentos;*/
	
	@Override
	public String toString() {
		return nome;
	}
	
	

}
