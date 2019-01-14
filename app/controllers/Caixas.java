package controllers;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.mysql.fabric.xmlrpc.base.Value;

import enums.Movimentacao;
/*import jdk.nashorn.internal.objects.annotations.Where;*/
import models.Caixa;
import models.Log;
import models.Pagamento;
import play.data.validation.Valid;
import play.db.jpa.JPA;
import play.mvc.Controller;
import play.mvc.With;

@With(Sessao.class)

public class Caixas extends Controller {
	
	public static void listar_caixa() {
		BigDecimal saldo = getSaldo();
		List<Caixa> caixas = Caixa.findAll();
		render(caixas, saldo);
	}
	
	public static void lancamento_caixa() {
		render();
	}
	
	public static void lancamento(@Valid Caixa caixa) {
		
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			lancamento_caixa();
		}
		
		System.out.println(caixa.movimentacao.toString());
		if (caixa.movimentacao.equals(Movimentacao.ENTRADA)){
			creditar(caixa.valor, caixa.descricao);			
		}else {
			debitar(caixa.valor, caixa.descricao);
		}
	}
	
	
	public static void creditar(BigDecimal valor, String descricao) {
		Caixa caixa = new Caixa();
		caixa.movimentacao = caixa.movimentacao.ENTRADA;
		caixa.descricao = descricao;
		caixa.data = new Date();
		caixa.valor = valor;
		caixa.save();
		flash.success("Valor Creditado com Sucesso!");
		Log log = new Log() ;
		log.acao = "EFETUOU O LANÇAMENTO DO CRÉDITO: " + caixa.descricao;
		log.data = new Date();
		log.usuario = session.get("usuario");
		log.save();
		listar_caixa();
	}
	
	public static void debitar(BigDecimal valor, String descricao) {
		Caixa caixa = new Caixa();
		caixa.movimentacao = caixa.movimentacao.SAIDA;
		caixa.descricao = descricao;
		caixa.data = new Date();
		caixa.valor = valor.negate();
		caixa.save();
		flash.success("Valor Debitado com Sucesso!");
		Log log = new Log() ;
		log.acao = "EFETUOU O LANÇAMENTO DO DÉBITO: " + caixa.descricao;
		log.data = new Date();
		log.usuario = session.get("usuario");
		log.save();
		listar_caixa();
	}
	
	public static BigDecimal getSaldo() {
		String query = "SELECT SUM(valor) FROM Caixa";
		EntityManager em = JPA.em();
		BigDecimal saldo = (BigDecimal) em.createQuery(query).getSingleResult();
		return saldo;
	}
}
