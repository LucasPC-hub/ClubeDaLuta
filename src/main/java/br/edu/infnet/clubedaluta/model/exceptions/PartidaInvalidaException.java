package br.edu.infnet.clubedaluta.model.exceptions;

public class PartidaInvalidaException extends PartidaException  {

    public PartidaInvalidaException() {
        super("A partida deve ter dois jogadores.");
    }
}
