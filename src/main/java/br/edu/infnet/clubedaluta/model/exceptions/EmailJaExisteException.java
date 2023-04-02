package br.edu.infnet.clubedaluta.model.exceptions;

public class EmailJaExisteException extends UsuarioException {
    public EmailJaExisteException(String email) {
        super("Email "+email+"  ja está cadastrado");
    }
}
