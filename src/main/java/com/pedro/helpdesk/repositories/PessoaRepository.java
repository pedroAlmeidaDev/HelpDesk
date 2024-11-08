package com.pedro.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
