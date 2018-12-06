package verificationPoints;

import static org.junit.Assert.fail;

import support.Report;

public class ServiceVerificationPoint {
	
	public ServiceVerificationPoint () {}
	
	public void validarStatusServico(int statusCode, int expected) {
    	if(statusCode == expected) {
    		Report.logPass("Teste do Serviço Ok! Resposta: "+expected);
    	} else {
			Report.logFail("Teste do Serviço Not Ok! Resposta: "+statusCode);
    		fail("Verificar Status.");
    	}
    }

	public void validaResponse(String respostaesperada, String respostarecebida) {
    	if(respostaesperada.equals(respostarecebida)) {
    		Report.logPass("Fez o Get e a resposta esperada foi de acordo com a obtida: " +respostarecebida);
    	} else {
			Report.logFail("Não obteve a resposta esperada. Resposta recebida: " +respostarecebida);
    		fail("Verificar response.");
    	}
    }

}
