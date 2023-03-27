package br.edu.infnet.clubedaluta.model.repository;

import br.edu.infnet.clubedaluta.model.domain.Partidas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidasRepository extends CrudRepository<Partidas,Integer> {

}
