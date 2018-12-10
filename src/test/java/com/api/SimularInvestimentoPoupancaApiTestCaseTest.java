package com.api;

import static io.restassured.RestAssured.given;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.support.ConfigTest;
import com.support.ReportTest;
import com.verificationPoints.ServiceVerificationPointTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class SimularInvestimentoPoupancaApiTestCaseTest {
	private ServiceVerificationPointTest verifica;
	private static final String RESPONSEAPIGET = ConfigTest.get("response.sicredi.api");
	
	@Before
	public void setUp() {
		ReportTest.startTest("Teste de Serviço Api Sicredi - Simulador de Investimento Poupança");		
		this.verifica = new ServiceVerificationPointTest();
	}
	
	@Test
	public void testeGetSicrediAPI() {
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)				
				.when()
				.get("http://5b847b30db24a100142dce1b.mockapi.io/api/v1/simulador");
	
		verifica.validarStatusServico(response.getStatusCode(), 200);
		verifica.validaResponse(RESPONSEAPIGET, response.asString());
	}

    @After
	public void tearDown() {
		ReportTest.close();
	}
}
