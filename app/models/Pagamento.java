package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@Entity
public class Pagamento extends Model {
	
	public String descricao;
	
	public String semestre;
	
	@Temporal(TemporalType.DATE)
	public Date vencimento;
	
	@Temporal(TemporalType.DATE)
	public Date recebimento;
	
	public double valor;
	
	@OneToOne
	public Associado associado;
	
}
