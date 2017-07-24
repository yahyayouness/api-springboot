package com.socgen.agence.fgad.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class TestProfileApplicationDEV {

	/**
	 * CAS DE TEST DROIT: ASSERT URI AVEC UN DNS DE PRODUCTION
	 */
	private  final String URI_DOCUMENT_DEV = "http://dfadlx01.dns21.socgen:8080/ged-dfc-api/fgad/api/clients/synchrone";

	/**
	 * CAS DE TEST DROIT: ASSERT URI TIMEOUT DE PRODUCTION
	 */
	private  final String TIMEOUT_CLIENT_DEV = "10000";

	private  final String FGAD_API = "FGAD API";

	final  Logger LOG = LoggerFactory.getLogger(TestProfileApplicationDEV.class);

	@Autowired
	private ConfigurationResource configurationDEV;

	@Autowired
	private CommonConfiguration commonConfigurationProperties;

	
	@PostConstruct
	void afterPropertiesSet() throws Throwable {

		LOG.info("uri document resource: " + this.configurationDEV.getUriDocumentResource());
		LOG.info("timeout document resource: " + this.configurationDEV.getConnectionTimeOut());
		
		LOG.info("Common project name: " + this.commonConfigurationProperties.getName());

//		assertNotNull(configurationDEV);
//		assertEquals(URI_DOCUMENT_DEV, configurationDEV.getUriDocumentResource());
//		assertEquals(TIMEOUT_CLIENT_DEV, configurationDEV.getConnectionTimeOut());
//
//		assertNotNull(commonConfigurationProperties);
//		assertEquals(FGAD_API, commonConfigurationProperties.getName());

	}

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder(TestProfileApplicationDEV.class).profiles("default","dev").run(args);

	}
}
