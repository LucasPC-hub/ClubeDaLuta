package br.edu.infnet.clubedaluta.model.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.clubedaluta.model.domain.Usuario;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	@Query("from Usuario u where u.email = :email and u.password = :senha")
	Usuario autenticacao(String email, String senha);

	Optional<Usuario> findByEmail(String email);
}