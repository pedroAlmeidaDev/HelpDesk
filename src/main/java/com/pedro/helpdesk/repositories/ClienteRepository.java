package com.pedro.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedro.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
