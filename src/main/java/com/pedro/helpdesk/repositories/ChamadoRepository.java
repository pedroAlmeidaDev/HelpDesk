package com.pedro.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
