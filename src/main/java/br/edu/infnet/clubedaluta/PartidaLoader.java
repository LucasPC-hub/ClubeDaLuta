package br.edu.infnet.clubedaluta;

import br.edu.infnet.clubedaluta.model.domain.Partidas;
import br.edu.infnet.clubedaluta.model.domain.Usuario;
import br.edu.infnet.clubedaluta.model.service.PartidasService;
import br.edu.infnet.clubedaluta.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Order(2)
@Component
public class PartidaLoader implements ApplicationRunner {

    @Autowired
    private PartidasService partidasService;
    @Autowired
    private UsuarioService usuarioService;
    private List<Usuario> participantesLoader= new ArrayList<>();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 2; i++) {
            Usuario usuario = new Usuario("Participante " + i, "participante"+i+"@email.com", "0"+i);
            usuario.setIsAdm(false);
            usuario.setDiscord("Participante"+i);
            usuario.setClasse("DK");

            usuarioService.incluir(usuario);
            participantesLoader.add(usuario);

        }
        System.out.println(participantesLoader);
        Partidas partida = new Partidas();
        partida.setParticipantes(participantesLoader);
        partida.setData(String.valueOf(LocalDate.now()));
        partida.setHora(String.valueOf(LocalTime.now()));

        System.out.println(partida);
        partidasService.incluir(partida);
    }
}
