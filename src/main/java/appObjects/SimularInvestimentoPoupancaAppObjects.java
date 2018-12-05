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
	
	//btn btnAmarelo btnSimular

}
