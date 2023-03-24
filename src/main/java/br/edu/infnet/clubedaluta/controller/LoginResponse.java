package br.edu.infnet.clubedaluta.controller;

import br.edu.infnet.clubedaluta.model.domain.Usuario;

public class LoginResponse {
    private boolean sucesso;
    private Usuario usuario;

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LoginResponse(boolean sucesso, Usuario usuario) {
        this.sucesso = sucesso;
        this.usuario = usuario;
    }
}
