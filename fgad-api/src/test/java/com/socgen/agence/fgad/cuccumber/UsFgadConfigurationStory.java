package com.socgen.agence.fgad.cuccumber;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.springframework.http.HttpStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UsFgadConfigurationStory extends SpringIntegrationTest{

	@When("^the fgad user calls /fgad/api/config$")
	public void the_client_issues_GET_version() throws Throwable {
		System.out.println("when");
		executeGet("http://localhost:5555/fgad/api/config");
	}

	@Then("^the fgad user receives status code of (\\d+)$")
	public void the_client_receives_status_code_of(int statusCode) throws Throwable {
		HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
		assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
		System.out.println("then");
	}

	@And("^the fgad user receives uri document (.+)$")
	public void the_client_receives_uri_document_body(String version) throws Throwable {
		String body = latestResponse.getBody();
		System.out.println(body);
	}

}
