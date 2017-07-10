/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.socgen.agence.fgad.rest;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.springframework.stereotype.Component;

import com.socgen.agence.fgad.business.DocumentsBS;

@Component
@Path("/v1/documents")
public class DocumentsResource {

	private final DocumentsBS documentsBS;


	public DocumentsResource(DocumentsBS documentsBS) {
		super();
		this.documentsBS = documentsBS;
	}

	
	@GET
	public String getDocuments(@QueryParam("input") @NotNull String input) {
		
		final String result=documentsBS.message();
		return new StringBuilder(input).append(result).toString();
	}

}
