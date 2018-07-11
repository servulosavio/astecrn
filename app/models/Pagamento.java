package models;

import java.math.BigDecimal;
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

import enums.SituacaoPagamento;
import play.db.jpa.Model;

@Entity
public class Pagamento extends Model {
	
	public String descricao;
	
	public String semestre;
	
	public SituacaoPagamento situacaoPagamento;
	
	@Temporal(TemporalType.DATE)
	public Date vencimento;
	
	@Temporal(TemporalType.DATE)
	public Date recebimento;
	
	public BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name="associado_id")
	public Associado associado;
	
}
