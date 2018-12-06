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
	
	public WebElement getMensagemInvestimento () {
		return driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div[2]/span[1]"));
	}
	
	public WebElement getValorInvestimentoFinal () {
		return driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div[2]/span[2]"));
	}
	
	public WebElement getMensagemValorMinimo () {
		return driver.findElement(By.id("valorAplicar-error"));
	}
}
