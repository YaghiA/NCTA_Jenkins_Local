package external_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Wait;

public class Ex_Confirm_Page {
	WebDriver driver;
	
	public Ex_Confirm_Page(WebDriver driver) {
		this.driver = driver;
		}
	
	
	@FindBy (how = How.ID, using ="confirmForm") WebElement ConfirmForm;
	
	
public void ConfirmInfoPage() {
	Wait.waitForElement(driver, 10, By.id("confirmForm"));
	
	
	
}
}
