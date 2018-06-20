package controllers;

import models.Pagamento;
import play.mvc.Controller;

public class Pagamentos extends Controller {
	
	public static void novo_pagamento(Pagamento pagamento) {
		render();
	}
	
	public static void salvar(Pagamento pagamento) {
		pagamento.save();
		Application.gerenciador();
	}

}
