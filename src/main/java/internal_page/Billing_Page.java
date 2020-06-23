package internal_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Wait;

public class Billing_Page {
	WebDriver driver;

	public Billing_Page(WebDriver driver) {
		this.driver = driver;
	}

	// Credit Card Element Library
	@FindBy(how = How.ID, using = "ddlBillingType")
	WebElement PaymentOptionDropDown;
	@FindBy(how = How.ID, using = "ddlBillingType_1")
	WebElement AutoCreditCard;
	@FindBy(how = How.ID, using = "ccnumfield")
	WebElement CardNumberField;
	@FindBy(how = How.ID, using = "_ddlExpiryMonth")
	WebElement ExpMonthDropDown;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'May')]")
	WebElement May;
	@FindBy(how = How.ID, using = "_ddlExpiryYear")
	WebElement ExpYearDropDown;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'2024')]")
	WebElement Year2024;
	@FindBy(how = How.ID, using = "_txtNameOnCard")
	WebElement NameOnCard;

	// Credit ACH Element Library
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'ACH')]")
	WebElement ACH;
	@FindBy(how = How.ID, using = "_txtBankName")
	WebElement BankName;
	@FindBy(how = How.ID, using = "_txtRoutingNumber")
	WebElement RoutingNumber;
	@FindBy(how = How.ID, using = "_ddlAcccountType")
	WebElement AccountTypeDropDown;
	@FindBy(how = How.XPATH, using = "//md-option/div[contains(text(),'ACH-Checking')]")
	WebElement ACHChecking;
	@FindBy(how = How.ID, using = "_txtAcccountNumber")
	WebElement AccountNumber;
	@FindBy(how = How.ID, using = "_txtAcccountHolderName")
	WebElement AccountHolderName;

	// Check Element Library
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Manual')]")
	WebElement CashOrCheck;

	@FindBy(how = How.XPATH, using = "//div[@class='md-container md-ink-ripple']")
	WebElement SameAdrressCheckBox;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'NEXT')]")
	WebElement NextButton;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'OK')]")
	WebElement DoublicateButton;

	public void Billing_CC_Visa( String nameOnCard) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("ddlBillingType"));
		Wait.waitForElementToBeClicable(driver, 20, By.id("ddlBillingType"));
		Thread.sleep(1000);
		PaymentOptionDropDown.click();
		Wait.waitForElement(driver, 10, By.id("ddlBillingType_1"));
		AutoCreditCard.click();
		Wait.waitForElement(driver, 20, By.id("_ddlExpiryMonth"));
		driver.switchTo().frame("tokenframe");
		Wait.waitForElement(driver, 20, By.id("tokenform"));
		CardNumberField.sendKeys("4788250000121443");
		driver.switchTo().defaultContent();
		
		
		try{ExpMonthDropDown.click();
			Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'May')]"));
		May.click();}
		catch(Exception j ) {
			NameOnCard.click();
			Actions action = new Actions(driver);
			action.click(ExpMonthDropDown).perform();
			Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'May')]"));
			May.click();
		}
		
		Thread.sleep(1000);
		ExpYearDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'2024')]"));
		Year2024.click();
		Thread.sleep(1000);
		NameOnCard.sendKeys(nameOnCard);
		SameAdrressCheckBox.click();
		Thread.sleep(1000);

	}
	
	public void Billing_CC_MAsterCard( String nameOnCard) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("ddlBillingType"));
		Wait.waitForElementToBeClicable(driver, 20, By.id("ddlBillingType"));
		Thread.sleep(1000);
		PaymentOptionDropDown.click();
		Wait.waitForElement(driver, 10, By.id("ddlBillingType_1"));
		AutoCreditCard.click();
		Wait.waitForElement(driver, 20, By.id("_ddlExpiryMonth"));
		driver.switchTo().frame("tokenframe");
		Wait.waitForElement(driver, 20, By.id("tokenform"));
		CardNumberField.sendKeys("5454545454545454");
		driver.switchTo().defaultContent();
		ExpMonthDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'May')]"));
		May.click();
		Thread.sleep(1000);
		ExpYearDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'2024')]"));
		Year2024.click();
		Thread.sleep(1000);
		NameOnCard.sendKeys(nameOnCard);
		SameAdrressCheckBox.click();
		Thread.sleep(1000);

	}
	
	public void Billing_CC_Discover( String nameOnCard) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("ddlBillingType"));
		Wait.waitForElementToBeClicable(driver, 20, By.id("ddlBillingType"));
		Thread.sleep(1000);
		PaymentOptionDropDown.click();
		Wait.waitForElement(driver, 10, By.id("ddlBillingType_1"));
		AutoCreditCard.click();
		Wait.waitForElement(driver, 20, By.id("_ddlExpiryMonth"));
		driver.switchTo().frame("tokenframe");
		Wait.waitForElement(driver, 20, By.id("tokenform"));
		CardNumberField.sendKeys("6011000995500000");
		driver.switchTo().defaultContent();
		ExpMonthDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'May')]"));
		May.click();
		Thread.sleep(1000);
		ExpYearDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'2024')]"));
		Year2024.click();
		Thread.sleep(1000);
		NameOnCard.sendKeys(nameOnCard);
		SameAdrressCheckBox.click();
		Thread.sleep(1000);

	}
	
	public void Billing_CC_Amex( String nameOnCard) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("ddlBillingType"));
		Wait.waitForElementToBeClicable(driver, 20, By.id("ddlBillingType"));
		Thread.sleep(1000);
		PaymentOptionDropDown.click();
		Wait.waitForElement(driver, 10, By.id("ddlBillingType_1"));
		AutoCreditCard.click();
		Wait.waitForElement(driver, 20, By.id("_ddlExpiryMonth"));
		driver.switchTo().frame("tokenframe");
		Wait.waitForElement(driver, 20, By.id("tokenform"));
		CardNumberField.sendKeys("371449635398431");
		driver.switchTo().defaultContent();
		ExpMonthDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'May')]"));
		May.click();
		Thread.sleep(1000);
		ExpYearDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'2024')]"));
		Year2024.click();
		Thread.sleep(1000);
		NameOnCard.sendKeys(nameOnCard);
		SameAdrressCheckBox.click();
		Thread.sleep(1000);

	}


	public void Billing_ACH_BOF( String accountHolderName) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("ddlBillingType"));
		Thread.sleep(1000);
		PaymentOptionDropDown.click();
		Wait.waitForElement(driver, 5, By.xpath("//div[contains(text(),'ACH')]"));
		ACH.click();
		Wait.waitForElement(driver, 20, By.id("_txtBankName"));
		Thread.sleep(1000);
		BankName.sendKeys("BOF");
		Thread.sleep(500);
		RoutingNumber.click();
		Thread.sleep(1000);
		RoutingNumber.click();
		Thread.sleep(1000);
		RoutingNumber.sendKeys("021000021");
		AccountTypeDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//md-option/div[contains(text(),'ACH-Checking')]"));
		ACHChecking.click();
		Thread.sleep(500);
		AccountNumber.click();
		Thread.sleep(1000);
		AccountNumber.sendKeys("123456789");
		AccountHolderName.sendKeys(accountHolderName);
		SameAdrressCheckBox.click();
		Thread.sleep(2000);
	}
	
	public void Billing_ACH_Chase(String accountHolderName) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("ddlBillingType"));
		Thread.sleep(1000);
		PaymentOptionDropDown.click();
		Wait.waitForElement(driver, 5, By.xpath("//div[contains(text(),'ACH')]"));
		ACH.click();
		Wait.waitForElement(driver, 20, By.id("_txtBankName"));
		Thread.sleep(1000);
		BankName.sendKeys("Chase");
		Thread.sleep(500);
		RoutingNumber.click();
		Thread.sleep(1000);
		RoutingNumber.click();
		Thread.sleep(1000);
		RoutingNumber.sendKeys("111000614");
		AccountTypeDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//md-option/div[contains(text(),'ACH-Checking')]"));
		ACHChecking.click();
		Thread.sleep(500);
		AccountNumber.click();
		Thread.sleep(1000);
		AccountNumber.sendKeys("123456789");
		AccountHolderName.sendKeys(accountHolderName);
		SameAdrressCheckBox.click();
		Thread.sleep(2000);
	}

	public void Billing_Check() throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("ddlBillingType"));
		PaymentOptionDropDown.click();
		Thread.sleep(1000);
		CashOrCheck.click();

	}

	public void Billing_Cash() throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("ddlBillingType"));
		Thread.sleep(1000);
		PaymentOptionDropDown.click();
		Thread.sleep(500);
		CashOrCheck.click();
	}
}
