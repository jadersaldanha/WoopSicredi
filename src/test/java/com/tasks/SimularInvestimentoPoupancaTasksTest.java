package com.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appObjects.SimularInvestimentoPoupancaAppObjects;

public class SimularInvestimentoPoupancaTasksTest {
	
	private final SimularInvestimentoPoupancaAppObjects simular;
	private WebDriver driver;
	
	public SimularInvestimentoPoupancaTasksTest (WebDriver driver) {
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
	
	public String mensagemInvestimento () {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div[2]/span[1]"))));
		return this.simular.getMensagemInvestimento().getText();
	}

	public String valorInvestimentoFinal () {
		return this.simular.getValorInvestimentoFinal().getText();
	}
	
	public String mensagemValorMinimo () {
		return this.simular.getMensagemValorMinimo().getText();
	}
}
