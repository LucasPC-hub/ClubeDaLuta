package br.edu.infnet.clubedaluta.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import javax.persistence.*;

@Entity
@Table(name = "TUsuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String email;
	private String password;
	private String familia;
	private String discord;
	private String classe;

	public boolean isAdm() {
		return isAdm;
	}
	@JsonIgnoreProperties("participantes")
	@ManyToMany(mappedBy = "participantes")
	private List<Partidas> partidas = new ArrayList<>();

	public List<Partidas> getPartidas() {
		return partidas;
	}

	public void setPartidas(List<Partidas> partidas) {
		this.partidas = partidas;
	}

	public void setIsAdm(boolean isAdm) {
		this.isAdm = isAdm;
	}

	private boolean isAdm;

	public Usuario() {
	}

	public Usuario(String email, String password) {
		this();
		this.setEmail(email);
		this.setPassword(password);
	}

	public Usuario(String familia, String email, String password) {
		this(email, password);
		this.setFamilia(familia);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getDiscord() {
		return discord;
	}

	public void setDiscord(String discord) {
		this.discord = discord;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Usuario.class.getSimpleName() + "[", "]")
				.add("id=" + id)
				.add("email='" + email + "'")
				.add("familiia='" + familia + "'")
				.add("discord='" + discord + "'")
				.add("classe='" + classe + "'")
				.add("isAdm='" + isAdm + "'")
				.toString();
	}

	public Usuario(Integer id, String email, String password, String familia, String discord, String classe, boolean isAdm) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.familia = familia;
		this.discord = discord;
		this.classe = classe;
		this.isAdm = isAdm;
	}
}