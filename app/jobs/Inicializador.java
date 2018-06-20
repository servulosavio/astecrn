package jobs;

import enums.Status;
import models.Assistencia;
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
			usuario.status = Status.ATIVO;
			usuario.save();
		}
		
		if (Assistencia.count() == 0) {
			Assistencia assistencia1 = new Assistencia();
			assistencia1.razaoSocial = "S S DE QUEIROZ MEDEIROS - ME";
			assistencia1.nomeFantasia = "S MUSIC DIGITAL";
			assistencia1.cnpj = "21579844000109";
			assistencia1.telefone = "849996672388";
			assistencia1.rua = "RUA ANTÔNIO LEITE";
			assistencia1.numero = "343";
			assistencia1.complemento = "LOJA 2";
			assistencia1.bairro = "CENTRO";
			assistencia1.cep = "59805000";
			assistencia1.cidade = "Lucrécia";
			assistencia1.estado = "RN";
			assistencia1.save();
			
			Assistencia assistencia2 = new Assistencia();
			assistencia2.razaoSocial = "A A TESTE LTDA";
			assistencia2.nomeFantasia = "ASSISTENCIA TESTE";
			assistencia2.cnpj = "09577884000100";
			assistencia2.telefone = "84999000008";
			assistencia2.rua = "RUA CHICO DE SÁ";
			assistencia2.numero = "40";
			assistencia2.complemento = "ALTO DA EMA";
			assistencia2.bairro = "CENTRO";
			assistencia2.cep = "59790000";
			assistencia2.cidade = "Mossoró";
			assistencia2.estado = "RN";
			assistencia2.save();
			
		}
	}
}
