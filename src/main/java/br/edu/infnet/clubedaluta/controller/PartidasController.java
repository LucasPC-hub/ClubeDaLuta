package br.edu.infnet.clubedaluta.controller;


import br.edu.infnet.clubedaluta.model.domain.Partidas;
import br.edu.infnet.clubedaluta.model.domain.Usuario;
import br.edu.infnet.clubedaluta.model.exceptions.PartidaInvalidaException;
import br.edu.infnet.clubedaluta.model.exceptions.PartidaNotFoundException;
import br.edu.infnet.clubedaluta.model.exceptions.VencedorInvalidoException;
import br.edu.infnet.clubedaluta.model.service.PartidasService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api")
public class PartidasController {
    @Autowired
    private PartidasService partidasService;
    ObjectMapper objectMapper = new ObjectMapper();
    @GetMapping(value = "/partidas/lista")
    public ResponseEntity<?> telaLista() {
        List<Partidas> resource = partidasService.obterLista();
        return ResponseEntity.ok(resource);
    }

    @PostMapping(value = "/partida/incluir")
    public ResponseEntity<?> incluir(@RequestBody Partidas partida) throws PartidaInvalidaException {

        Partidas resource =partidasService.incluir(partida);
        return ResponseEntity.ok(resource);
    }
    @PostMapping(value = "/partida/incluirVencedor")
    public ResponseEntity<?> incluirVencedor(@RequestBody Map<String, Object> payload) throws PartidaNotFoundException, VencedorInvalidoException {
        Partidas partida1 = objectMapper.convertValue(payload.get("partida"), Partidas.class);
        Usuario vencedor = objectMapper.convertValue(payload.get("vencedor"), Usuario.class);
        Integer id = partida1.getId();
        partidasService.atualizarVencedor(id,vencedor);
        String message = ("Partida "+id+ " atualizada");
        return ResponseEntity.ok().body("{\"message\": \"" + message + "\"}");
    }
    @PostMapping(value = "/partida/excluir")
    public ResponseEntity<?>  excluir(@RequestBody int id) throws PartidaNotFoundException {

        partidasService.excluir(id);
        String message = ("Partida "+id+ " excluido");
        return ResponseEntity.ok().body("{\"message\": \"" + message + "\"}");
    }
}
