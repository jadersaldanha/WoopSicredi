package com.verificationPoints;

import static org.junit.Assert.fail;

import com.support.Report;

public class ValidarValoresVerificationPointTest {
	
	public void validarMensagemdeTempoeInvestimento (String recebida, String esperada) {
    	if(recebida.equals(esperada)) {
    		Report.logPass("Mensagem ok! "+esperada);
    	} else {
			Report.logFail("Fail, Mensagem recebida: "+recebida);
    		fail("Verificar Status.");
    	}
    }
	
	public void validarValorTotalInvestimento (String valorrecebido, String valoresperado) {
    	if(valorrecebido.equals(valoresperado)) {
    		Report.logPass("Valor esperado de acordo com recebido! Valor esperado: "+valoresperado);
    	} else {
			Report.logFail("Valor não foi exibido na tela de acordo com esperado: "+valorrecebido);
    		fail("Verificar Cálculo.");
    	}
    }
	
	public void validarMensagemValorMinimo (String valorrecebido, String valoresperado) {
    	if(valorrecebido.equals(valoresperado)) {
    		Report.logPass("Mensagem exibida com sucesso! \""+valoresperado+"\"");
    	} else {
			Report.logFail("Mensagem exibida incorretamente!"+valorrecebido);
    		fail("Verificar.");
    	}
    }
}
