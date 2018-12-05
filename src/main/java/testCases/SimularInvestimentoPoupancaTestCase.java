package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import support.Config;
import support.CsvDatapool;
import support.Drivers;
import support.Generator;
import support.IDatapool;
import support.Report;
import support.Screenshot;
import tasks.SimularInvestimentoPoupancaTasks;

public class SimularInvestimentoPoupancaTestCase {
	private static final String SYSTEM_URL = Config.get("environment.sicredi.prod");
	private static final String DATAPOOL = Config.get("datapool.pasta");
	private static final String IMAGEPATH = Config.get("screenshot.pasta");
	private WebDriver driver;
	private SimularInvestimentoPoupancaTasks simular; 
	private IDatapool datapool;
	//private ValidarAcessodeUsuarioVerificationPoint validar;
	
	@Before
	public void setUp() {
		Report.startTest("Simulação de investimento na Poupança.");
		
		this.driver = Drivers.getChromeDriver();
		this.driver.get(SYSTEM_URL);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		datapool = new CsvDatapool(DATAPOOL);
		this.simular = new SimularInvestimentoPoupancaTasks(driver);
	}
	
	@Test
	public void testMain() throws InterruptedException {
		simular.setValorAplicar(datapool.getValue("valorAplicar"));
		String screenshotArquivo1 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
		Screenshot.Tirar(driver, screenshotArquivo1);
		Report.log(Status.PASS, "Digitou valor a ser aplicado", screenshotArquivo1);
		//validar.validarMensagemErro("Ocorreu um erro de conexão. Por favor, verifique seu dados e tente novamente.");	
	}
	
	@After
	public void tearDown() {
		Report.close();
		this.driver.quit();
	}
}
