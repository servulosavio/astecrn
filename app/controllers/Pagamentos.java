package controllers;

import java.util.List;

import models.Associado;
import models.Pagamento;
import play.mvc.Controller;
import play.mvc.With;

@With(Sessao.class)

public class Pagamentos extends Controller {
	
	public static void novo_pagamento(Pagamento pagamento) {
		List<Associado> associados = Associado.findAll();
		render(associados, pagamento);
	}
	
	public static void salvar(Pagamento pagamento, String valor) {
		
		System.out.println(valor);
		
		// tratar valor
		
		
		pagamento.save();
		Usuarios.gerenciador();
	}
	
	public static void listar_pagamento() {
		List<Pagamento> pagamentos = Pagamento.findAll();
		render(pagamentos);
	}

}
