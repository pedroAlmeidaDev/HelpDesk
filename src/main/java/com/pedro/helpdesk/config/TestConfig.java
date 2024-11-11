package com.pedro.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pedro.helpdesk.services.DBService;

@Configuration // Indica que a classe contém definições de beans e configurações do Spring
@Profile("test") // Controlar quais beans ou configurações devem ser carregados dependendo do perfil de ambiente
public class TestConfig {

	@Autowired // Injeção automática de dependência
	private DBService dbservice;

	@Bean // Declara um método dentro de uma classe anotada com @Configuration
	public void instanciaDB() {
		this.dbservice.instanciaDB();
	}
}
