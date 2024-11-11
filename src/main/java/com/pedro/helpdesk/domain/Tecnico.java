package com.pedro.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pedro.helpdesk.Perfil;

@Entity //Indica que a classe vai ser a tabela
public class Tecnico extends Pessoa {
	
	public static final long serialVersionUID = 1L;
	
	@JsonIgnore // Evita a serialização
	@OneToMany(mappedBy = "tecnico") // Um para muitos
	private List<Chamado> chamados = new ArrayList<>();

	public Tecnico() {
		super();
		addPerfil(Perfil.TECNICO);
	}

	public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamado) {
		this.chamados = chamado;
	}
	
	
	
}
