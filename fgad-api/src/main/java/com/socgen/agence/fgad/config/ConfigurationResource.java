package com.socgen.agence.fgad.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("resource")
public class ConfigurationResource {

	/**
	 * Configuration Inputs. URI of resource document to consume with
	 * restTemplate.
	 */
	private String uriDocumentResource;

	/**
	 * Number for connection timeout when calling with restTemplate
	 */
	private String connectionTimeOut;

	/**
	 * the uri of document
	 * @return 
	 */

	public String getUriDocumentResource() {
		return uriDocumentResource;
	}

	public void setUriDocumentResource(String uriDocumentResource) {
		this.uriDocumentResource = uriDocumentResource;
	}

	public String getConnectionTimeOut() {
		return connectionTimeOut;
	}

	public void setConnectionTimeOut(String connectionTimeOut) {
		this.connectionTimeOut = connectionTimeOut;
	}

	@Override
	public String toString() {
		return "ConfigurationResource [uriDocumentResource=" + uriDocumentResource + ", connectionTimeOut="
				+ connectionTimeOut + "]";
	}
	
	
}
