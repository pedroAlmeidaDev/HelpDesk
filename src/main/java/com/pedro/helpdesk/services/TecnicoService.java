package com.pedro.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.pedro.helpdesk.domain.Pessoa;
import com.pedro.helpdesk.domain.Tecnico;
import com.pedro.helpdesk.dtos.TecnicoDTO;
import com.pedro.helpdesk.repositories.PessoaRepository;
import com.pedro.helpdesk.repositories.TecnicoRepository;
import com.pedro.helpdesk.services.exceptions.ObjectnotFoundException;

@Service // Específica para classes de serviço, facilitando a leitura do código.
public class TecnicoService {

	@Autowired // Injeção automática de dependência
	private TecnicoRepository repository;

	@Autowired
	private PessoaRepository pessoaRepository;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! " + " id:" + id));
	}

	public List<Tecnico> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		ValidaPorCPFeEmail(objDTO);
		Tecnico newObj = new Tecnico(objDTO);
		return repository.save(newObj);
	}

	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		objDTO.setId(id);
		Tecnico oldObj = findById(id);
		ValidaPorCPFeEmail(objDTO);
		oldObj = new Tecnico(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Tecnico obj = findById(id);
		if (obj.getChamados().size() > 0) {
			throw new DataIntegrityViolationException("Técnico possui ordens de serviço e não pode ser deletado");

		}
		repository.deleteById(id);
	}

	private void ValidaPorCPFeEmail(TecnicoDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema! ");
		}

		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema! ");
		}

	}

}
