package com.socgen.agence.fgad.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
public class TestProfileApplicationPROD {

	/**
	 * CAS DE TEST DROIT ASSERT URI AVEC UN DNS DE PRODUCTION
	 */
	private  final String URI_DOCUMENT_PROD = "http://pfadlx01.dns21.socgen:8080/ged-dfc-api/fgad/api/clients/synchrone";

	/**
	 * CAS DE TEST DROIT ASSERT URI TIMEOUT DE PRODUCTION
	 */
	private  final String TIMEOUT_CLIENT_PRODUCTION = "10000";

	private  final String FGAD_API = "FGAD API";
	
	final static Logger LOG = LoggerFactory.getLogger(TestProfileApplicationPROD.class);

	@Autowired
	private ConfigurationResource configurationPROD;

	@Autowired
	private CommonConfiguration commonConfigurationProperties;

	
	@PostConstruct
	void afterPropertiesSet() throws Throwable {

		LOG.info("uri document resource: " + this.configurationPROD.getUriDocumentResource());
		LOG.info("timeout document resource: " + this.configurationPROD.getConnectionTimeOut());
		LOG.info("Common project name: " + this.commonConfigurationProperties.getName());

//		assertNotNull(configurationPROD);
//		assertEquals(URI_DOCUMENT_PROD, configurationPROD.getUriDocumentResource());
//		assertEquals(TIMEOUT_CLIENT_PRODUCTION, configurationPROD.getConnectionTimeOut());
//
//		assertNotNull(commonConfigurationProperties);
//		assertEquals(FGAD_API, commonConfigurationProperties.getName());

	}

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder(TestProfileApplicationPROD.class).profiles("prod").run(args);

	}
}
