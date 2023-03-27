package br.edu.infnet.clubedaluta.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name="TPartidas")
public class Partidas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String data;
    private String hora;
    @JsonIgnoreProperties("partidas")
    @ManyToMany
    @JoinTable(name = "tpartidas_participantes",
            joinColumns = @JoinColumn(name = "partida_id"),
            inverseJoinColumns = @JoinColumn(name = "participante_id"))
    private List<Usuario> participantes = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario vencedor;

    public Partidas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public List<Usuario> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Usuario> participantes) {
        this.participantes = participantes;
    }

    public Usuario getVencedor() {
        return vencedor;
    }

    public void setVencedor(Usuario vencedor) {
        this.vencedor = vencedor;
    }

    public Partidas(Integer id, String data, String hora, List<Usuario> participantes, Usuario vencedor) {
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.participantes = participantes;
        this.vencedor = vencedor;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Partidas.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("data='" + data + "'")
                .add("hora='" + hora + "'")
                .add("participantes=" + participantes)
                .add("vencedor=" + vencedor)
                .toString();
    }
}
