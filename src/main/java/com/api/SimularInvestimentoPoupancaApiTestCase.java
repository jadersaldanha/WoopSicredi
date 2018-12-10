package com.api;

import static io.restassured.RestAssured.given;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.support.Config;
import com.support.Report;
import com.verificationPoints.ServiceVerificationPoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class SimularInvestimentoPoupancaApiTestCase {
	private ServiceVerificationPoint verifica;
	private static final String RESPONSEAPIGET = Config.get("response.sicredi.api");
	
	@Before
	public void setUp() {
		Report.startTest("Teste de Serviço Api Sicredi - Simulador de Investimento Poupança");		
		this.verifica = new ServiceVerificationPoint();
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
		Report.close();
	}
}
