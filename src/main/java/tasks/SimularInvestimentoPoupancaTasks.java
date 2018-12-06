package tasks;

import org.openqa.selenium.WebDriver;

import appObjects.SimularInvestimentoPoupancaAppObjects;


public class SimularInvestimentoPoupancaTasks {
	
	private final SimularInvestimentoPoupancaAppObjects simular;
	private WebDriver driver;
	
	public SimularInvestimentoPoupancaTasks (WebDriver driver) {
		this.driver = driver;
		this.simular = new SimularInvestimentoPoupancaAppObjects(driver); 
	}
	
	public void setValorAplicar (String valoraplicado) {
		this.simular.getValorAplicarTextField().sendKeys(valoraplicado);
	}
	
	public void setValorInvestimento (String valorInvestir) {
		this.simular.getValorInvestimento().sendKeys(valorInvestir);
	}
	
	public void setMesesInvestimento (String tempo) {
		this.simular.getMesesInvestimento().sendKeys(tempo);
	}
	
	public void clicarSimular () {
		this.simular.getSimularButton().click();
	}

}
