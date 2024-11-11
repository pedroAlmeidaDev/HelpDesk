package com.pedro.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pedro.helpdesk.services.DBService;

@Configuration // Indica que a classe contém definições de beans e configurações do Spring
@Profile("dev") // Controlar quais beans ou configurações devem ser carregados dependendo do perfil de ambiente
public class DevConfig {

	@Autowired // Injeção automática de dependência
	private DBService dbservice;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;
	
	
	@Bean // Declara um método dentro de uma classe anotada com @Configuration
	public boolean instanciaDB() {
		if(value.equals("create")) {
			this.dbservice.instanciaDB();
		}
		
		return false;
	}
}
