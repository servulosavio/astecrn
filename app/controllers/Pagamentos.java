package controllers;

import java.util.Date;
import java.util.List;

import org.apache.commons.mail.HtmlEmail;

import enums.SituacaoPagamento;
import models.Associado;
import models.Contato;
import models.Pagamento;
import play.data.validation.Valid;
import play.libs.Mail;
import play.mvc.Controller;
import play.mvc.With;

@With(Sessao.class)

public class Pagamentos extends Controller {
	
	public static void novo_pagamento(Pagamento pagamento) {
		List<Associado> associados = Associado.findAll();
		pagamento.situacaoPagamento = SituacaoPagamento.ABERTO;
		render(associados, pagamento);
	}
	
	public static void salvar(@Valid Pagamento pagamento,List<String> associadoIDs) {
		
		System.out.println(validation.hasErrors());
		
		if (associadoIDs == null) {
			validation.addError("associadoIDs", "Selecione os associados que realizarão este pagamento");			
		}
		
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			novo_pagamento(pagamento);
		}
		
		String IDs = "-1";
//		if(associadoIDs != null)
//			IDs = String.join(", ", associadoIDs);
		
		
		
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
		flash.success("Pagamento Criado com Sucesso!");
		Pagamentos.listar_pagamento();
	}
	
	public static void listar_pagamento() {
		List<Pagamento> pagamentos = Pagamento.find("order by vencimento").fetch();
		render(pagamentos);
	}
	
	public static void receber_pagamento(Long id) {
		Pagamento pagamento = Pagamento.findById(id);
		pagamento.situacaoPagamento = SituacaoPagamento.QUITADO;
		pagamento.recebimento = new Date();	
		pagamento.save();
		Caixas.creditar(pagamento.valor, "RECEBIMENTO DE CONTAS: " + pagamento.associado.nome);
		flash.success("Pagamento Criado com Sucesso!");
		Pagamentos.listar_pagamento();
	}
	
	public static void enviar_cobranca(Long id) {
		
		Pagamento pagamento = Pagamento.findById(id);
		HtmlEmail emailHtml = new HtmlEmail();
		try {
			emailHtml.setFrom("astec@gmail.com");
			emailHtml.addTo(pagamento.associado.login);
			emailHtml.setSubject("Pagamento em atraso");
			emailHtml.setHtmlMsg("Prezado " + pagamento.associado.nome 
					+ ", informamos que consta em atraso o pagamento '" + pagamento.descricao 
					+ "' com vencimento em " + pagamento.vencimento 
					+ " no valor de " + pagamento.valor);
			Mail.send(emailHtml); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		flash.success("Mensagem Enviada com Sucesso!");
		listar_pagamento();
		
		
//		email.save();
//		detalhes(email.id);
	}

}
