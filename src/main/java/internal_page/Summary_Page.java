package internal_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Wait;

public class Summary_Page {
	WebDriver driver;

	public Summary_Page(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//span[@translate='SUMMARY_LBL_EMAILRECEIPT']/preceding::div[@class='md-container md-ink-ripple']")
	WebElement EmailReceipt;
	@FindBy(how = How.XPATH, using = "//md-checkbox[@ng-model='$ctrl.chkSummaryReceiptEmail']/div[@class='md-container md-ink-ripple']")
	WebElement EmailAccSummary;
	@FindBy(how = How.XPATH, using = "//button[@ng-click='$ctrl.printPaymentReport()']/i")
	WebElement PrintReceipt;
	@FindBy(how = How.XPATH, using = "//button[@ng-click='$ctrl.printSummaryReport()']/i")
	WebElement PrintAccSummary;
	@FindBy(how = How.XPATH, using = "//button[@ng-click='$ctrl.sendAccountSummary()']/div")
	WebElement SendEmailButton;
	@FindBy(how = How.XPATH, using = "//span[text()='FINISH']")
	WebElement FinishButton;

	public void PrintEmailRecieptAndSummary() throws InterruptedException {
		Wait.waitForElement(driver, 30, By.xpath(
				"//span[@translate='SUMMARY_LBL_EMAILRECEIPT']/preceding::div[@class='md-container md-ink-ripple']"));
		EmailReceipt.click();
		EmailAccSummary.click();
		String MainWindow=driver.getWindowHandle();
		PrintReceipt.click();
		Thread.sleep(5000);
		driver.switchTo().window(MainWindow);
		PrintAccSummary.click();
		Thread.sleep(5000);
		driver.switchTo().window(MainWindow);
		
	}
	public void PrintAndEmailSummaryOnly() throws InterruptedException {
		Wait.waitForElement(driver, 30, By.xpath(
				"//md-checkbox[@ng-model='$ctrl.chkSummaryReceiptEmail']/div[@class='md-container md-ink-ripple']"));
		EmailAccSummary.click();
		String MainWindow=driver.getWindowHandle();
		PrintAccSummary.click();
		Thread.sleep(5000);
		driver.switchTo().window(MainWindow);
}
}