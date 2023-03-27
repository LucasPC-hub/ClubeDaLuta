package br.edu.infnet.clubedaluta.controller;


import br.edu.infnet.clubedaluta.model.domain.Partidas;
import br.edu.infnet.clubedaluta.model.service.PartidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class PartidasController {
    @Autowired
    private PartidasService partidasService;
    @GetMapping(value = "/partidas/lista")
    public ResponseEntity<?> telaLista() {
        List<Partidas> resource = partidasService.obterLista();
        return ResponseEntity.ok(resource);
    }

    @PostMapping(value = "/partida/incluir")
    public ResponseEntity<?> incluir(@RequestBody Partidas partida) {

        Partidas resource =partidasService.incluir(partida);
        return ResponseEntity.ok(resource);
    }
}
