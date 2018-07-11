package controllers;

import java.util.Date;
import java.util.List;

import enums.SituacaoPagamento;
import models.Associado;
import models.Pagamento;
import play.mvc.Controller;
import play.mvc.With;

@With(Sessao.class)

public class Pagamentos extends Controller {
	
	public static void novo_pagamento(Pagamento pagamento) {
		List<Associado> associados = Associado.findAll();
		pagamento.situacaoPagamento = SituacaoPagamento.ABERTO;
		render(associados, pagamento);
	}
	
	public static void salvar(Pagamento pagamento,List<String> associdadoIDs) {
		String IDs = "-1";
		if(associdadoIDs != null)
			IDs = String.join(", ", associdadoIDs);
			
		String query = "select a from Associado a where a.id in (" + IDs + ")";			
		List<Associado> associados = Associado.find(query).fetch();
		for(Associado associado: associados) {
			Pagamento p = new Pagamento();
			p.descricao = pagamento.descricao;
			p.semestre = pagamento.semestre;
			p.valor = pagamento.valor;
			p.vencimento = pagamento.vencimento;
			p.situacaoPagamento = SituacaoPagamento.ABERTO;
			p.associado = associado;
			p.save();
			associado.pagamentos.add(p);
			associado.save();
		}

		Pagamentos.listar_pagamento();
	}
	
	public static void listar_pagamento() {
		List<Pagamento> pagamentos = Pagamento.findAll();
		render(pagamentos);
	}
	
	public static void receber_pagamento(Long id) {
		Pagamento pagamento = Pagamento.findById(id);
		pagamento.situacaoPagamento = SituacaoPagamento.QUITADO;
		pagamento.recebimento = new Date();	
		pagamento.save();
		Pagamentos.listar_pagamento();
	}

}
