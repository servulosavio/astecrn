package models;

import play.db.jpa.Model;

public class Usuario extends Model {
	
	private String login = "admin";
	private String senha = "123";
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}




