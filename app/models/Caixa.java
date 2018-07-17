package models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enums.Movimentacao;
import play.db.jpa.Model;

@Entity
public class Caixa extends Model {
	
	/*public BigDecimal saldo;
	public BigDecimal creditos;
	public BigDecimal debitos;*/

	public Movimentacao movimentacao;
	public String descricao;
	
	@Temporal(TemporalType.DATE)
	public Date data;
	
	public BigDecimal valor;
	
	
}
