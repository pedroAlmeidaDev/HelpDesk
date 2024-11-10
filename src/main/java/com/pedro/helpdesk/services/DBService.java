package com.pedro.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.helpdesk.Perfil;
import com.pedro.helpdesk.Prioridade;
import com.pedro.helpdesk.Status;
import com.pedro.helpdesk.domain.Chamado;
import com.pedro.helpdesk.domain.Cliente;
import com.pedro.helpdesk.domain.Tecnico;
import com.pedro.helpdesk.repositories.ChamadoRepository;
import com.pedro.helpdesk.repositories.ClienteRepository;
import com.pedro.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {

		Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "347.846.070-05", "valdir@mail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "Linus Torvalds", "673.276.190-03", "torvalds@mail.com", "123");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", cli1,
				tec1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));

	}

}
