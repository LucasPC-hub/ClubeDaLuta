package br.edu.infnet.clubedaluta.model.exceptions;

public class UsuarioNotFoundException extends UsuarioException{
    public UsuarioNotFoundException(int id) {
        super("Usuario não encontrado: " +id);
    }
}
