package api;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import support.Config;
import support.Report;
import verificationPoints.ServiceVerificationPoint;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
