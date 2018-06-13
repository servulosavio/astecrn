package jobs;

import models.Usuario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job{
	
	@Override
	public void doJob() throws Exception {
		if(Usuario.count() == 0) {
			Usuario usuario = new Usuario();
			usuario.login = "admin";
			usuario.senha = "admin";
			usuario.save();
		}
	}

}
