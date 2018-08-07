package models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enums.Movimentacao;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Caixa extends Model {
	
	@Required
	@Enumerated(EnumType.STRING)
	public Movimentacao movimentacao;
	
	@Required
	public String descricao;
	
	
	@Temporal(TemporalType.DATE)
	public Date data;
	
	@Required
	public BigDecimal valor;
	
	
	
	
}
