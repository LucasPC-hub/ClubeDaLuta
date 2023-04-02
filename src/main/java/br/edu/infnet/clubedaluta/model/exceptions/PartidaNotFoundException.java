package br.edu.infnet.clubedaluta.model.exceptions;

public class PartidaNotFoundException extends PartidaException {
    public PartidaNotFoundException(Integer id) {
        super("Partida não encontrada: " + id);
    }
}