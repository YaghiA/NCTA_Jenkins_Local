package external_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Wait;

public class External_Terms_Page {
	WebDriver driver;
	
	public External_Terms_Page(WebDriver driver) {
		this.driver = driver;
		}
	@FindBy (how = How.XPATH, using ="//md-select[@ng-disabled='customerAccountTypeDataSource.length==1']") WebElement AccountTypeDropDown;
	@FindBy (how = How.XPATH, using ="//md-option/div[contains(text(),'NC Quick Pass Business')]") WebElement QPBusiness;
	@FindBy (how = How.XPATH, using ="//md-option/div[contains(text(),'NC Quick Pass Personal')]") WebElement QPPesrsonal;
	@FindBy (how = How.XPATH, using ="//md-checkbox[@ng-model='chkTermsAndConditions']/div[@class='md-container md-ink-ripple']") WebElement TirmsCheckBox;
	@FindBy (how = How.ID, using ="btnNext") WebElement ContinueButton;
	
	public void choseBusinessAndAccept() {
	Wait.waitForElement(driver, 30, By.xpath("//md-select[@ng-disabled='customerAccountTypeDataSource.length==1']"));
		AccountTypeDropDown.click();
		Wait.waitForElement(driver, 20, By.xpath("//md-option/div[contains(text(),'NC Quick Pass Business')]"));
		QPBusiness.click();
		TirmsCheckBox.click();
		ContinueButton.click();
	}
	
	public void chosePersoalAndAccept() throws InterruptedException {
	Thread.sleep(10000);
		Wait.waitForElement(driver, 30, By.xpath("//md-select[@ng-disabled='customerAccountTypeDataSource.length==1']"));
		
	AccountTypeDropDown.click();
		Wait.waitForElement(driver, 20, By.xpath("//md-option/div[contains(text(),'NC Quick Pass Personal')]"));
		QPPesrsonal.click();
		TirmsCheckBox.click();
		ContinueButton.click();
	}
}
