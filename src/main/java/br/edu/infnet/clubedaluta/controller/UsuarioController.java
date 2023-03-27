package br.edu.infnet.clubedaluta.controller;

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


	@GetMapping(value = "/usuario/lista")
	public ResponseEntity<?> telaLista() {
		List<Usuario> resource = usuarioService.obterLista();
		return ResponseEntity.ok(resource);
	}

	@PostMapping(value = "/usuario/incluir")
	public ResponseEntity<?> incluir(@RequestBody Usuario usuario) {

		Usuario resource =usuarioService.incluir(usuario);
		return ResponseEntity.ok(resource);

	}
		
	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		usuarioService.excluir(id);

		return "redirect:/usuario/lista";
	}
}