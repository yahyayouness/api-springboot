
package com.socgen.agence.fgad.rest;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.socgen.agence.fgad.business.DocumentsBS;
import com.socgen.agence.fgad.dto.DocumentsDTO;

/**
 * Ressource qui permet d'injecter dans la GED clients un document de manière
 * synchrone dans le but de le conserver, de le rechercher et le restituer.
 * 'https://dfadlx01.dns21-3.socgen/fgad/api/V1/bddf/operCustomers/documents’
 *
 */
@Component
@Path("/fgad/api/v1/bddf/{domain}/documents")
@Produces("application/json")
@Consumes("application/json")
public class DocumentsResource {

	/**
	 * Logger for resource documents.
	 */
	final static Logger LOG = LoggerFactory.getLogger(DocumentsResource.class);

	/**
	 * Business service that contain business rules of manipulating documents.
	 */
	private final DocumentsBS documentsBS;

	public DocumentsResource(DocumentsBS documentsBS) {
		super();
		this.documentsBS = documentsBS;
	}

	/**
	 * Endpoint for retrieving document.
	 *
	 * @return
	 */
	@GET
	public DocumentsDTO getDocuments() {

		LOG.info("REST : Start retrieving Document");
		DocumentsDTO result = null;
		URI uri = null;

		try {

			result = documentsBS.injectDocuments(null, uri);
		} catch (Exception e) {
			LOG.error("Error when injecting documents : ", e);
		}
		LOG.info("REST : End retrieving Document");

		return result;
	}

	/**
	 * Endpoint for posting document with synchronous method.
	 *
	 * @param document
	 * @return
	 */
	@POST
	public DocumentsDTO postDocumentsSynchrone(final DocumentsDTO document) {

		LOG.info("Start injecting Document :  {}", document);

		// FIXME ADD VALIDATE INPUTS

		URI uri = null;
		DocumentsDTO result = null;
		try {
			result = documentsBS.injectDocuments(document, uri);
		} catch (Exception e) {
			LOG.error("Error when injecting documents : ", e);
		}

		LOG.info("End injecting Document with uri  :  {}", (null != uri) ? uri.toString() : "uri non rensignée");
		return result;
	}

}
