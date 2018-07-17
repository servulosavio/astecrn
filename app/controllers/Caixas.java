package controllers;

import java.math.BigDecimal;
import java.util.Date;

import enums.Movimentacao;
import models.Caixa;
import play.mvc.Controller;

public class Caixas extends Controller {
	
	
	
	public static void creditar(BigDecimal valor, String descricao) {
		Caixa caixa = new Caixa();
		caixa.movimentacao = caixa.movimentacao.ENTRADA;
		caixa.descricao = descricao;
		caixa.data = new Date();
		caixa.valor = valor;
		caixa.save();
	}
	
	public static void debitar(BigDecimal valor) {
		Caixa caixa = new Caixa();
		caixa.movimentacao = caixa.movimentacao.SAIDA;
		caixa.data = new Date();
		caixa.valor = valor.negate();
		caixa.save();
	}
	
}
