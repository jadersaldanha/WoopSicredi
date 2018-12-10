package com.verificationPoints;

import static org.junit.Assert.fail;

import com.support.Report;

public class ServiceVerificationPointTest {
	
	public ServiceVerificationPointTest () {}
	
	public void validarStatusServico(int statusCode, int expected) {
    	if(statusCode == expected) {
    		Report.logPass("Teste do Servi�o Ok! Resposta: "+expected);
    	} else {
			Report.logFail("Teste do Servi�o Not Ok! Resposta: "+statusCode);
    		fail("Verificar Status.");
    	}
    }

	public void validaResponse(String respostaesperada, String respostarecebida) {
    	if(respostaesperada.equals(respostarecebida)) {
    		Report.logPass("Fez o Get e a resposta esperada foi de acordo com a obtida: " +respostarecebida);
    	} else {
			Report.logFail("N�o obteve a resposta esperada. Resposta recebida: " +respostarecebida);
    		fail("Verificar response.");
    	}
    }

}
