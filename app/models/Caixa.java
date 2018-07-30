package models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import enums.Movimentacao;
import play.db.jpa.Model;

@Entity
public class Caixa extends Model {
	
	@Enumerated(EnumType.STRING)
	public Movimentacao movimentacao;
	public String descricao;
	
	@Temporal(TemporalType.DATE)
	public Date data;
	
	public BigDecimal valor;
	
	
	
	
}
