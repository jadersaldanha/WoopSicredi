package com.regressionTestSuite;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.api.SimularInvestimentoPoupancaApiTestCase;
import com.support.ReportTest;
import com.testCases.SimularInvestimentoPoupancaTestCaseTest;
import com.testCases.SimularInvestimentoPoupancaValorMinimoTestCaseTest;


@RunWith(Suite.class)
@SuiteClasses({
	SimularInvestimentoPoupancaTestCaseTest.class,
	SimularInvestimentoPoupancaValorMinimoTestCaseTest.class,
	SimularInvestimentoPoupancaApiTestCase.class
})

public class SimularInvestimentoPoupancaRegressionTestSuiteTest {
	
	public static void main(String[] args) {
		JUnitCore.runClasses(SimularInvestimentoPoupancaRegressionTestSuite.class);
	}
	
	@BeforeClass
	public static void setUp() {
		ReportTest.create("Sicredi", "Simulação de Investimento na Poupança.");
	}

	@AfterClass
	public static void tearDown() {
		ReportTest.close();
	}

}




