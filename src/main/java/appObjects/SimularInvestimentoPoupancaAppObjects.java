package appObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimularInvestimentoPoupancaAppObjects {
	
	private WebDriver driver; 
	
	public SimularInvestimentoPoupancaAppObjects (WebDriver driver) {
		this.driver = driver;		
	}

	public WebElement getValorAplicarTextField () {
		return driver.findElement(By.id("valorAplicar"));
	}
	
	public WebElement getValorInvestimento () {
		return driver.findElement(By.id("valorInvestir"));
	}
	
	public WebElement getMesesInvestimento () {
		return driver.findElement(By.id("tempo"));
	}
	
	public WebElement getSimularButton () {
		return driver.findElement(By.className("simular"));
	}
	
	//btn btnAmarelo btnSimular

}
