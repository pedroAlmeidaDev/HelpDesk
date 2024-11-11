package com.pedro.helpdesk.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.helpdesk.domain.Tecnico;
import com.pedro.helpdesk.services.TecnicoService;

@RestController // Indica que a classe é um controlador e que os métodos nela retornarão dados JSON/XML
@RequestMapping(value = "/tecnicos") // É uma anotação mais geral para mapear URLs para métodos ou classes de um controlador
public class TecnicoResource {
	
	
	@Autowired // Injeção automática de dependência
	TecnicoService service;
	
	@GetMapping(value = "/{id}") // É uma anotação especializada, introduzida para simplificar o uso do @RequestMapping em métodos HTTP GET
	public ResponseEntity<Tecnico> findById(@PathVariable Integer id){ // Captura valores dinâmicos da URL para uso no método.
		Tecnico obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
