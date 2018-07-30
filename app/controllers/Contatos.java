package controllers;

import java.util.Date;
import java.util.List;

import org.apache.commons.mail.HtmlEmail;

import models.Contato;
import play.data.validation.Valid;
import play.libs.Mail;
import play.mvc.Controller;

public class Contatos extends Controller {
	
	public static void novo_contato() {
		render();
	}
	
	public static void enviar(@Valid Contato email) {
		email.dataEnvio = new Date();
		if(validation.hasErrors()) {
			validation.keep();
			params.flash();
			novo_contato();
		}
		HtmlEmail emailHtml = new HtmlEmail();
		try {
			emailHtml.setFrom(email.de);
			emailHtml.addTo(email.para);
			emailHtml.setSubject(email.assunto);
			emailHtml.setHtmlMsg(email.mensagem);
			Mail.send(emailHtml); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		email.save();
//		detalhes(email.id);
	}
	
	public static void detalhes(Long id) {
		Contato email = Contato.findById(id);
		render(email);
	}
	
	public static void listar() {
		List<Contato> emails = Contato.findAll();
		render(emails);
	}
	

}
