package controllers;

import java.util.List;

import models.Cliente;
import play.mvc.Controller;

public class Clientes extends Controller{
	
	public static void form(Cliente cliente) {
		render(cliente);
	}
	
	public static void salvar(Cliente cliente) {
		cliente.save();
		listar();
	}
	
	public static void editar(Long id) {
		Cliente cliente = Cliente.findById(id);
		renderTemplate("Clientes/form.html", cliente);
	}
	
	public static void detalhes(Cliente cliente) {
		render(cliente);
	}
	
	public static void listar() {
		List<Cliente> clientes = Cliente.findAll();
		render(clientes);
	}
	
	public static void remover(Long id) {
		Cliente cliente = Cliente.findById(id);
		cliente.delete();
		listar();
	}
	
	public static void associados() {
		List<Cliente> clientes = Cliente.findAll();
		render(clientes);
	}
	

}
