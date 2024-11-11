package com.pedro.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.helpdesk.domain.Tecnico;
import com.pedro.helpdesk.repositories.TecnicoRepository;

@Service // Específica para classes de serviço, facilitando a leitura do código.
public class TecnicoService {

	@Autowired // Injeção automática de dependência
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
