package internal_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Wait;

public class Confirm_Page {
WebDriver driver;
	
	public Confirm_Page(WebDriver driver) {
		this.driver = driver;
	
	}
	
	@FindBy (how = How.XPATH, using ="//span[contains(text(),'NEXT')]") WebElement Next;
	
	public void ConfirmInfo() throws InterruptedException {
	
		Wait.waitForElement(driver, 10, By.xpath("//h3[contains(text(),'Contact Info')]"));
		Wait.waitForElement(driver, 10, By.xpath("//span[contains(text(),'NEXT')]"));
		Wait.waitForElementToBeClicable(driver, 10, By.xpath("//span[contains(text(),'NEXT')]"));
		Thread.sleep(500);
	
}
}
