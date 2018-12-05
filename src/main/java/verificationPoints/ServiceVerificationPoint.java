package verificationPoints;

import static org.junit.Assert.fail;

import support.Report;

public class ServiceVerificationPoint {
	
	public ServiceVerificationPoint () {
		
	}
	
	public void validarStatusServico(int statusCode, int expected) {
    	if(statusCode == expected) {
    		Report.logPass("Fez a busca corretamente.");
    	} else {
			Report.logFail("No exibiu a mensagem corretamente.");
    		fail("No exibiu a mensagem corretamente.");
    	}
    }


}
