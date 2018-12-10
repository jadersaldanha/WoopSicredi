package com.regressionTestSuite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.api.SimularInvestimentoPoupancaApiTestCase;
import com.support.Report;
import com.testCases.SimularInvestimentoPoupancaTestCase;
import com.testCases.SimularInvestimentoPoupancaValorMinimoTestCase;


@RunWith(Suite.class)
@SuiteClasses({
	SimularInvestimentoPoupancaTestCase.class,
	SimularInvestimentoPoupancaValorMinimoTestCase.class,
	SimularInvestimentoPoupancaApiTestCase.class
})

public class SimularInvestimentoPoupancaRegressionTestSuite {
	
	public static void main(String[] args) {
		JUnitCore.runClasses(SimularInvestimentoPoupancaRegressionTestSuite.class);
	}
	
	@BeforeClass
	public static void setUp() {
		Report.create("Sicredi", "Simulação de Investimento na Poupança.");
	}

	@AfterClass
	public static void tearDown() {
		Report.close();
	}

}




