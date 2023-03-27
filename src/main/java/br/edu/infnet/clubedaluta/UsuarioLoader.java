package br.edu.infnet.clubedaluta;

import br.edu.infnet.clubedaluta.model.domain.Usuario;
import br.edu.infnet.clubedaluta.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Usuario userAdmin = new Usuario("Administrador ", "admin@admin.com", "123");
		userAdmin.setClasse("adm");
		userAdmin.setDiscord("adm");
		userAdmin.setIsAdm(true);
		usuarioService.incluir(userAdmin);

		System.out.println("Inclusão do administrador "+userAdmin.getFamilia()+" realizada com sucesso!!!");

	}
}
