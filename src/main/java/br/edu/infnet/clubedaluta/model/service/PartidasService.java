package br.edu.infnet.clubedaluta.model.service;


import br.edu.infnet.clubedaluta.model.domain.Partidas;
import br.edu.infnet.clubedaluta.model.domain.Usuario;
import br.edu.infnet.clubedaluta.model.repository.PartidasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class PartidasService {
    @Autowired
    private PartidasRepository partidasRepository;

    public Partidas incluir(Partidas partida) {
        return partidasRepository.save(partida);
    }

    public void excluir(Integer key) {
        partidasRepository.deleteById(key);
    }

    public List<Partidas> obterLista(){
        return (List<Partidas>) partidasRepository.findAll();
    }

    @Transactional
    public void atualizarVencedor(Integer id, Usuario vencedor) {
        Partidas partida = partidasRepository.findById(id).orElse(null);
        if (partida != null) {
            partida.setVencedor(vencedor);
            partidasRepository.save(partida);
        }
    }
    }
