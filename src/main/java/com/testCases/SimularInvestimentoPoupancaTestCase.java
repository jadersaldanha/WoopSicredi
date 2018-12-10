package com.testCases;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.support.Config;
import com.support.CsvDatapool;
import com.support.Drivers;
import com.support.Generator;
import com.support.IDatapool;
import com.support.Report;
import com.support.Screenshot;
import com.tasks.SimularInvestimentoPoupancaTasks;
import com.verificationPoints.ValidarValoresVerificationPoint;

public class SimularInvestimentoPoupancaTestCase {
	private static final String SYSTEM_URL = Config.get("environment.sicredi.prod");
	private static final String DATAPOOL = Config.get("datapool.pasta");
	private static final String IMAGEPATH = Config.get("screenshot.pasta");
	private WebDriver driver;
	private SimularInvestimentoPoupancaTasks simular; 
	private IDatapool datapool;
	private ValidarValoresVerificationPoint validar;
	
	@Before
	public void setUp() {
		Report.startTest("Simula��o de investimento na Poupan�a.");
		
		this.driver = Drivers.getChromeDriver();
		this.driver.get(SYSTEM_URL);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		datapool = new CsvDatapool(DATAPOOL);
		this.simular = new SimularInvestimentoPoupancaTasks(driver);
		validar = new ValidarValoresVerificationPoint();
	}
	
	@Test
	public void testMain() throws InterruptedException {
		simular.setValorAplicar(datapool.getValue("valorAplicar"));
		String screenshotArquivo1 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
		Screenshot.Tirar(driver, screenshotArquivo1);
		Report.log(Status.PASS, "Digitou valor a ser aplicado", screenshotArquivo1);
		
		simular.setValorInvestimento(datapool.getValue("valorInvestir"));
		String screenshotArquivo2 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
		Screenshot.Tirar(driver, screenshotArquivo2);
		Report.log(Status.PASS, "Digitou valor a ser a investido", screenshotArquivo2);
		
		simular.setMesesInvestimento(datapool.getValue("tempo"));
		String screenshotArquivo3 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
		Screenshot.Tirar(driver, screenshotArquivo3);
		Report.log(Status.PASS, "Digitou tempo de aplica��o", screenshotArquivo3);
		
		simular.clicarSimular();
		
		String mensagemrecebida = simular.mensagemInvestimento();
		String mensagemesperada = "Em 24 meses voc� ter� guardado";
		validar.validarMensagemdeTempoeInvestimento(mensagemrecebida, mensagemesperada);
		String valorRecebido = simular.valorInvestimentoFinal();
		String valoresperado = "R$ 2.564";
		validar.validarValorTotalInvestimento(valorRecebido, valoresperado);
	}
	
	@After
	public void tearDown() {
		Report.close();
		this.driver.quit();
	}
}
