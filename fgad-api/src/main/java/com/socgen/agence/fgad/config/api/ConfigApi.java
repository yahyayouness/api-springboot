
package com.socgen.agence.fgad.config.api;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.socgen.agence.fgad.config.CommonConfiguration;
import com.socgen.agence.fgad.config.ConfigurationResource;

/**
 * Ressource qui permet d'injecter dans la GED clients un document de manière
 * synchrone dans le but de le conserver, de le rechercher et le restituer.
 * 'https://dfadlx01.dns21-3.socgen/fgad/api/V1/bddf/operCustomers/documents’
 *
 */
@Component
@Path("/config")
@Produces("application/json")
@Consumes("application/json")
public class ConfigApi {

	/**
	 * Logger for resource documents.
	 */
	final static Logger LOG = LoggerFactory.getLogger(ConfigApi.class);

	/**
	 * Configuration.
	 */
	private ConfigurationResource configurationProjectProperties;
	
	/**
	 * Configuration.
	 */
	private CommonConfiguration commonConfiguration;

	@Autowired
	public ConfigApi(ConfigurationResource configurationProjectProperties,CommonConfiguration commonConfiguration) {
		LOG.info("Initializing Application through constructor");
		this.configurationProjectProperties = configurationProjectProperties;
		this.commonConfiguration=commonConfiguration;
	}

	/**
	 * Endpoint for retrieving document.
	 *
	 * @return
	 */
	@GET
	public Map<String,Map<String,String>> getDocuments() {

		LOG.info("CONFIG : Get configuration : {}", configurationProjectProperties.getUriDocumentResource());
		
		Map<String, Map<String, String>> hashMapConfiguration = new HashMap<>();
		Map<String, String> mapCommonConfiguration=new HashMap<>();
		mapCommonConfiguration.put("projectName", commonConfiguration.getName());
		Map<String, String> mapSpecificConfiguration=new HashMap<>();
		mapSpecificConfiguration.put("uriDocumentResource",configurationProjectProperties.getUriDocumentResource());
		mapSpecificConfiguration.put("connectionTimeout",configurationProjectProperties.getConnectionTimeOut());
		
		hashMapConfiguration.put("commonConfiguration", mapCommonConfiguration);
		hashMapConfiguration.put("specificConfiguration", mapSpecificConfiguration);
		
		return hashMapConfiguration;
	}

}
