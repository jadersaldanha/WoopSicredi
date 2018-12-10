package com.testCases;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.support.Config;
import com.support.Drivers;
import com.support.Generator;
import com.support.Report;
import com.support.Screenshot;
import com.tasks.SimularInvestimentoPoupancaTasks;
import com.verificationPoints.ValidarValoresVerificationPointTest;

public class SimularInvestimentoPoupancaValorMinimoTestCaseTest {
	
	private static final String SYSTEM_URL = Config.get("environment.sicredi.prod");
	private static final String IMAGEPATH = Config.get("screenshot.pasta");
	private WebDriver driver;
	private SimularInvestimentoPoupancaTasks simular; 
	private ValidarValoresVerificationPointTest validar;
	
	@Before
	public void setUp() {
		Report.startTest("Simula��o de investimento na Poupan�a com Valor Minimo.");
		
		this.driver = Drivers.getChromeDriver();
		this.driver.get(SYSTEM_URL);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.simular = new SimularInvestimentoPoupancaTasks(driver);
		validar = new ValidarValoresVerificationPointTest();
	}
	
	@Test
	public void testMain() throws InterruptedException {
		simular.setValorAplicar("19,00");
		simular.setValorInvestimento("19,00");
		String screenshotArquivo1 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
		Screenshot.Tirar(driver, screenshotArquivo1);
		Report.log(Status.FAIL, "Digitou valo inferior a ser aplicado", screenshotArquivo1);
		String mensagemrecebida = simular.mensagemValorMinimo();
		String mensagemesperada = "Valor m�nimo de 20.00";
		validar.validarMensagemValorMinimo(mensagemrecebida, mensagemesperada);
	}
	
	@After
	public void tearDown() {
		Report.close();
		this.driver.quit();
	}

}
