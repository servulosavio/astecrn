package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@Entity
public class Pagamento extends Model {
	
	public String semestre;
	
	@Temporal(TemporalType.DATE)
	public Date vencimento;
	
	public String valor;
	
	public List<Associado> devedores;
	public List<Associado> pagos;
	
}
