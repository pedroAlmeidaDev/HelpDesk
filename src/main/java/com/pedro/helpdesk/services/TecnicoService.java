package com.pedro.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedro.helpdesk.domain.Tecnico;
import com.pedro.helpdesk.repositories.TecnicoRepository;
import com.pedro.helpdesk.services.exceptions.ObjectnotFoundException;

@Service // Específica para classes de serviço, facilitando a leitura do código.
public class TecnicoService {

	@Autowired // Injeção automática de dependência
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! " + " id:" + id));
	}

	public List<Tecnico> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
}
