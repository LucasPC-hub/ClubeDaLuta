package br.edu.infnet.clubedaluta.controller;

import br.edu.infnet.clubedaluta.model.domain.Partidas;
import br.edu.infnet.clubedaluta.model.exceptions.EmailJaExisteException;
import br.edu.infnet.clubedaluta.model.service.PartidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import br.edu.infnet.clubedaluta.model.domain.Usuario;
import br.edu.infnet.clubedaluta.model.service.UsuarioService;

import java.util.List;

@Controller
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PartidasService partidasService;

	@GetMapping(value = "/usuario/lista")
	public ResponseEntity<?> telaLista() {
		List<Usuario> resource = usuarioService.obterLista();
		return ResponseEntity.ok(resource);
	}

	@PostMapping(value = "/usuario/incluir")
	public ResponseEntity<?> incluir(@RequestBody Usuario usuario) throws EmailJaExisteException {

		Usuario resource =usuarioService.incluir(usuario);
		return ResponseEntity.ok(resource);

	}
		
	@PostMapping(value = "/usuario/excluir")
	public ResponseEntity<?> excluir(@RequestBody int id) throws Exception {

		Usuario usuario =usuarioService.retornarUsuario(id);
		List<Partidas> partidas = usuario.getPartidas();

		for (Partidas partida:partidas) {

			this.partidasService.excluir(partida.getId());
		}

		usuarioService.excluir(id);
		String message = "Usuario " + id + " excluido";

		return ResponseEntity.ok().body("{\"message\": \"" + message + "\"}");
	}
}