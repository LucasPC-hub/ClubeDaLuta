package br.edu.infnet.clubedaluta.model.exceptions;

public class VencedorInvalidoException extends PartidaException {
    public VencedorInvalidoException() {
        super("O vencedor deve ser um dos jogadores da partida.");
    }
}
