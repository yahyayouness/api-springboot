package com.socgen.agence.fgad.rest.client;

import java.net.URI;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.socgen.agence.fgad.dto.DocumentsDTO;

public class DocumentsRestClient {

	private Logger logger = LoggerFactory.getLogger(DocumentsRestClient.class);

	private RestTemplate documentClient;

	@Value("${documents.resource.uri}")
	private String uriDocuments;
	
	public DocumentsRestClient() {
	}

	public void postDocument(final DocumentsDTO document, final MediaType contentType) {

		logger.info("Start inject document {} ", document);

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(contentType));
		headers.setContentType(contentType);
		HttpEntity<DocumentsDTO> entity = new HttpEntity<>(document, headers);

		URI locationUri = documentClient.postForLocation(uriDocuments, entity, DocumentsDTO.class);

		logger.info("End inject document with location {} ", locationUri);

	}

	public void getDocuments(final DocumentsDTO document, final MediaType contentType) {

		logger.info("Start inject document {} ", document);

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> documentsMap = restTemplate.getForObject(uriDocuments, List.class);

		if (documentsMap != null) {
			for (LinkedHashMap<String, Object> map : documentsMap) {
				logger.info("Document : id=" + map.get("id") + ", Name=" + map.get("name"));
			}
		} else {
			logger.info("Start inject document {} ", document);
		}

	}

}
