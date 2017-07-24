package com.socgen.agence.fgad.business;
 
import java.net.URI;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.socgen.agence.fgad.dto.DocumentsDTO;
import com.socgen.agence.fgad.rest.DocumentsResource;
 
/**
* Business rules for document service.
*
 * @author x162237
*
*/
@Configuration
@Component
public class DocumentsBS {
 
       /**
       * Logger for service documents.
       */
       final static Logger LOG = LoggerFactory.getLogger(DocumentsResource.class);
 
      
       private String uriDocument;
 
 
       /**
       * Service that contain Business rules to injecting documents
       *
        * @param document
       *            : dto contains meta data of the document
       * @return dto document
       * @throws Exception
       *             FIXME ADD RULE FOR EXCEPTION
       */
       public DocumentsDTO injectDocuments(DocumentsDTO document, URI uri) throws Exception {
 
             LOG.info("BUSINESS SERVICE : Start retrieving Document");
 
             final RestTemplate restTemplate = new RestTemplate();
 
             HttpHeaders headers = new HttpHeaders();
             headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
             headers.setContentType(MediaType.APPLICATION_JSON);
 
             HttpEntity<DocumentsDTO> entity = new HttpEntity<>(document, headers);
 
             uri = restTemplate.postForLocation(uriDocument, entity, DocumentsDTO.class);
 
             LOG.info("BUSINESS SERVICE : End retrieving Document");
 
             return document;
       }

}
