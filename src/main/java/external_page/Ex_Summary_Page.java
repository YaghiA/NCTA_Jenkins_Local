package external_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Wait;

public class Ex_Summary_Page {
	
		WebDriver driver;
		
		public Ex_Summary_Page(WebDriver driver) {
			this.driver = driver;
			}
		
		
		@FindBy (how = How.XPATH, using ="//md-checkbox[@ng-model='chkPaymentReceiptEmail']/div[@class='md-container md-ink-ripple']") WebElement EmailRecieptCheckbox;
		@FindBy (how = How.XPATH, using ="//md-checkbox[@ng-model='chkSummaryReceiptEmail']/div[@class='md-container md-ink-ripple']") WebElement EmailSummaryCheckbox;
		@FindBy (how = How.XPATH, using ="//strong[contains(text(),'Payment Receipt')]") WebElement PrintAccRecieptButton;
		@FindBy (how = How.XPATH, using ="//strong[contains(text(),'Account Summary')]") WebElement PrintAccSummaryButton;
		
		public void accountSummary() throws InterruptedException{
			Wait.waitForElement(driver, 20, By.xpath("//strong[contains(text(),'Account Summary')]"));
			EmailRecieptCheckbox.click();
			EmailSummaryCheckbox.click();
			
			String MainWindow=driver.getWindowHandle();
			PrintAccRecieptButton.click();
			Thread.sleep(5000);
			driver.switchTo().window(MainWindow);
			PrintAccSummaryButton.click();
			Thread.sleep(5000);
			driver.switchTo().window(MainWindow);
		}
}
