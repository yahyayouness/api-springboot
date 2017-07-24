package com.socgen.agence.fgad.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * Classe contenant la configuration commune entre tous les environnements.
 * 
 * @author you-octo
 *
 */
@Configuration
@ConfigurationProperties("project")
public class CommonConfiguration {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
