package com.pedro.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pedro.helpdesk.Perfil;
import com.pedro.helpdesk.dtos.ClienteDTO;

@Entity //Indica que a classe vai ser a tabela
public class Cliente extends Pessoa {
	
	public static final long serialVersionUID = 1L;
	
	@JsonIgnore // Evita a serialização
	@OneToMany(mappedBy = "cliente") // Um para muitos
	private List<Chamado> chamados = new ArrayList<>();

	public Cliente() {
		super();
		addPerfil(Perfil.CLIENTE);
	}

	public Cliente(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
	}
	
	public Cliente (ClienteDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamado) {
		this.chamados = chamado;
	}
	
	
		
}
