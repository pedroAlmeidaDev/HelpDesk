package com.pedro.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
