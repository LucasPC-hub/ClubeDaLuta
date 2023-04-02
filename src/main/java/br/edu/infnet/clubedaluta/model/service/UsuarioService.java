package br.edu.infnet.clubedaluta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.clubedaluta.model.domain.Usuario;
import br.edu.infnet.clubedaluta.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario incluir(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public void excluir(Integer key) throws Exception {
		Usuario usuario = usuarioRepository.findById(key).orElseThrow(() -> new Exception("Usuário não encontrado."));
		usuarioRepository.deleteById(key);
	}
	public Usuario retornarUsuario(int id) throws Exception {
		return usuarioRepository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado."));
	}
	public List<Usuario> obterLista(){
		return (List<Usuario>) usuarioRepository.findAll();
	}

}