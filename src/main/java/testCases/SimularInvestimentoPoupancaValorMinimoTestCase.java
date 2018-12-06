package testCases;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import support.Config;
import support.Drivers;
import support.Generator;
import support.Report;
import support.Screenshot;
import tasks.SimularInvestimentoPoupancaTasks;
import verificationPoints.ValidarValoresVerificationPoint;

public class SimularInvestimentoPoupancaValorMinimoTestCase {
	
	private static final String SYSTEM_URL = Config.get("environment.sicredi.prod");
	private static final String IMAGEPATH = Config.get("screenshot.pasta");
	private WebDriver driver;
	private SimularInvestimentoPoupancaTasks simular; 
	private ValidarValoresVerificationPoint validar;
	
	@Before
	public void setUp() {
		Report.startTest("Simulação de investimento na Poupança com Valor Minimo.");
		
		this.driver = Drivers.getChromeDriver();
		this.driver.get(SYSTEM_URL);
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		this.simular = new SimularInvestimentoPoupancaTasks(driver);
		validar = new ValidarValoresVerificationPoint();
	}
	
	@Test
	public void testMain() throws InterruptedException {
		simular.setValorAplicar("19,00");
		simular.setValorInvestimento("19,00");
		String screenshotArquivo1 = IMAGEPATH + Generator.dataHoraParaArquivo() +  ".png";
		Screenshot.Tirar(driver, screenshotArquivo1);
		Report.log(Status.FAIL, "Digitou valo inferior a ser aplicado", screenshotArquivo1);
		String mensagemrecebida = simular.mensagemValorMinimo();
		String mensagemesperada = "Valor mínimo de 20.00";
		validar.validarMensagemValorMinimo(mensagemrecebida, mensagemesperada);
	}
	
	@After
	public void tearDown() {
		Report.close();
		this.driver.quit();
	}

}
