package br.edu.infnet.clubedaluta.model.service;


import br.edu.infnet.clubedaluta.model.domain.Partidas;
import br.edu.infnet.clubedaluta.model.domain.Usuario;
import br.edu.infnet.clubedaluta.model.exceptions.PartidaInvalidaException;
import br.edu.infnet.clubedaluta.model.exceptions.PartidaNotFoundException;
import br.edu.infnet.clubedaluta.model.exceptions.VencedorInvalidoException;
import br.edu.infnet.clubedaluta.model.repository.PartidasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class PartidasService {
    @Autowired
    private PartidasRepository partidasRepository;

    public Partidas incluir(Partidas partida) throws PartidaInvalidaException {
        if(partida.getParticipantes().get(0) == null || partida.getParticipantes().get(1) == null) {
            throw new PartidaInvalidaException();
        }
        return partidasRepository.save(partida);
    }

    public void excluir(Integer key) throws PartidaNotFoundException {
        Partidas partida = partidasRepository.findById(key).orElse(null);
        if(partida == null) {
            throw new PartidaNotFoundException(key);
        }
        partidasRepository.deleteById(key);
    }

    public List<Partidas> obterLista(){
        return (List<Partidas>) partidasRepository.findAll();
    }

    @Transactional
    public void atualizarVencedor(Integer id, Usuario vencedor) throws PartidaNotFoundException, VencedorInvalidoException {
        Partidas partida = partidasRepository.findById(id).orElseThrow(()-> new PartidaNotFoundException(id));
        if (partida != null) {
            partida.setVencedor(vencedor);
            partidasRepository.save(partida);
        }
    }
    }
