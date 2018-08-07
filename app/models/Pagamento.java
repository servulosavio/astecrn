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
import play.data.validation.Min;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Pagamento extends Model {
	
	@Required
	public String descricao;
	
	@Required
	public String semestre;
	
	
	public SituacaoPagamento situacaoPagamento;
	
	@Required
	@Temporal(TemporalType.DATE)
	public Date vencimento;
	
	
	@Temporal(TemporalType.DATE)
	public Date recebimento;
	
	@Required
	public BigDecimal valor;
	
	//PRECISO REQUERER AO MENOS UM ASSOCIADO
	
	@ManyToOne
	@JoinColumn(name="associado_id")
	public Associado associado;
	
}
