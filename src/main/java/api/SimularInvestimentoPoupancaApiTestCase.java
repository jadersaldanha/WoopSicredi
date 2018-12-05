package api;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import support.Report;
import verificationPoints.ServiceVerificationPoint;

import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SimularInvestimentoPoupancaApiTestCase {
	private ServiceVerificationPoint verifica;
	
	@Before
	public void setUp() {
		Report.startTest("Teste de Servio Api E-commerce");		
		this.verifica = new ServiceVerificationPoint();
	}
	
    @Test
    public void testMain() {     
    	
    	String uriBase = "https://postman-echo.com/get";
    	RequestSpecification request = RestAssured.given();
    	
    	
    	request.relaxedHTTPSValidation()
    	.param("foo1", "bar1")
    	.param("foo2", "bar2")
    	.when()
    	.get(uriBase)
    	.then()
    	.statusCode(200) // O status http retornado foi 200
    	.contentType(ContentType.JSON) // O response foi retornado no formato JSON
    	.body("headers.host", is("postman-echo.com")) // A chave "host" possui exatamente o valor "postman-echo.com"
    	.body("args.foo1", containsString("bar")); //A chave "foo1" contém o valor "bar"

    	
    	Response response = request.get("https://postman-echo.com/get");
    	
    	int statusCode = response.getStatusCode();
    	System.out.println(statusCode);
    	//int expected = 200;
    	//verifica.validarStatusServico(statusCode, expected);
    }

    @After
	public void tearDown() {
		Report.close();
	}


}
