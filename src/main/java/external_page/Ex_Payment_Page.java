package external_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Wait;






public class Ex_Payment_Page {
	WebDriver driver;

	public Ex_Payment_Page(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy (how = How.XPATH, using ="//md-select[@name='ddPaymentType']") WebElement PaymentTypeDropbDown;


	// CreditCard
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Credit Card')]")
	WebElement CreditCard;
	@FindBy(how = How.ID, using = "existingCreditCards")
	WebElement NewCCDropbDown;
	@FindBy(how = How.XPATH, using = "//md-option/div[contains(text(),'New Credit Card')]")
	WebElement NewCCAccount;
	@FindBy(how = How.ID, using = "ccnumfield")
	WebElement CardNumberField;
	@FindBy(how = How.ID, using = "ddlExpiryMonth")
	WebElement ExMonthDropbDown;
	@FindBy(how = How.ID, using = "ddlExpiryMonth_9")
	WebElement October;
	@FindBy(how = How.ID, using = "ddlExpiryYear")
	WebElement ExYearDropbDown;
	@FindBy(how = How.ID, using = "ddlExpiryYear_5")
	WebElement Year2025;
	@FindBy(how = How.ID, using = "txtCVVCode")
	WebElement CVV;
	@FindBy(how = How.ID, using = "txtNameOnCard")
	WebElement NameOnCard;
	@FindBy(how = How.ID, using = "txtNickName")
	WebElement NickName;
	@FindBy(how = How.XPATH, using = "//md-checkbox[@id='txtAdressSameAsPrimary']/div")
	WebElement SameAddCheckBox;

	// ACH
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'ACH')]")
	WebElement ACH;
	
	@FindBy(how = How.ID, using = "existingBankAccounts")
	WebElement NewBankDropbDown;
	@FindBy(how = How.XPATH, using = "//md-option/div[contains(text(),'New Bank Account')]")
	WebElement NewBankAccount;
	
	@FindBy(how = How.ID, using = "txtBankName")
	WebElement BankName;
	@FindBy(how = How.ID, using = "txtRoutingNumber")
	WebElement RoutingNum;
	@FindBy(how = How.ID, using = "ddlAcccountType")
	WebElement AccountTypeDropDown;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'ACH-Checking')]")
	WebElement Checking;
	@FindBy(how = How.ID, using = "txtAcccountNumber")
	WebElement AccountNum;
	@FindBy(how = How.ID, using = "txtAcccountHolderName")
	WebElement AccountName;

	public void SameBillingPaymentConfirmation_ACH() {
		Wait.waitForElement(driver, 10, By.name("ddPaymentType"));

	}
	public void SameBillingPaymentConfirmation_CC() {
		Wait.waitForElement(driver, 10, By.name("ddPaymentType"));
		Wait.waitForElement(driver, 10, By.id("txtCVVCode"));
		CVV.sendKeys("999");
	}

	public void PaymentVisa() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.xpath("//md-select[@name='ddPaymentType']"));
		PaymentTypeDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'Credit Card')]"));
		CreditCard.click();
		Wait.waitForElement(driver, 10, By.id("existingCreditCards"));
		NewCCDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//md-select-value/span/div[contains(text(),'New Credit Card')]"));
		Thread.sleep(1000);
		NewCCAccount.click();
		Thread.sleep(2000);
		driver.switchTo().frame("tokenframe");
		Wait.waitForElement(driver, 20, By.id("ccnumfield"));
		CardNumberField.sendKeys("4788250000121443");
		driver.switchTo().defaultContent();
		ExMonthDropbDown.click();
		Thread.sleep(1000);
		October.click();
		ExYearDropbDown.click();
		Thread.sleep(1000);
		Year2025.click();
		CVV.sendKeys("999");
		NameOnCard.sendKeys("RX Build");
		NickName.sendKeys("UAT");
		SameAddCheckBox.click();
	}

	public void PaymentMasterCard() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.xpath("//md-select[@name='ddPaymentType']"));
		PaymentTypeDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'Credit Card')]"));
		CreditCard.click();
		Wait.waitForElement(driver, 10, By.id("existingCreditCards"));
		NewCCDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//md-option/div[contains(text(),'New Credit Card')]"));
		Thread.sleep(2000);
		NewCCAccount.click();
		
		driver.switchTo().frame("tokenframe");
		Wait.waitForElement(driver, 20, By.id("ccnumfield"));
		CardNumberField.sendKeys("5454545454545454");
		driver.switchTo().defaultContent();
		ExMonthDropbDown.click();
		Thread.sleep(1000);
		October.click();
		ExYearDropbDown.click();
		Thread.sleep(1000);
		Year2025.click();
		CVV.sendKeys("999");
		NameOnCard.sendKeys("RX Build");
		NickName.sendKeys("UAT");
		SameAddCheckBox.click();
	}

	public void PaymentDiscover() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.xpath("//md-select[@name='ddPaymentType']"));
		PaymentTypeDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'Credit Card')]"));
		CreditCard.click();
		Wait.waitForElement(driver, 10, By.id("existingCreditCards"));
		NewCCDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//md-select-value/span/div[contains(text(),'New Credit Card')]"));
		NewCCAccount.click();
		Thread.sleep(2000);
		driver.switchTo().frame("tokenframe");
		Wait.waitForElement(driver, 20, By.id("tokenframe"));
		CardNumberField.sendKeys("6011000995500000");
		driver.switchTo().defaultContent();
		ExMonthDropbDown.click();
		Thread.sleep(1000);
		October.click();
		ExYearDropbDown.click();
		Thread.sleep(1000);
		Year2025.click();
		CVV.sendKeys("999");
		NameOnCard.sendKeys("RX Build");
		NickName.sendKeys("UAT");
		SameAddCheckBox.click();
	}

	public void PaymentAmex() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.xpath("//md-select[@name='ddPaymentType']"));
		PaymentTypeDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'Credit Card')]"));
		CreditCard.click();
		Wait.waitForElement(driver, 10, By.id("existingCreditCards"));
		NewCCDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//md-select-value/span/div[contains(text(),'New Credit Card')]"));
		NewCCAccount.click();
		Thread.sleep(2000);
		
		driver.switchTo().frame("tokenframe");
		Wait.waitForElement(driver, 20, By.id("tokenframe"));

		CardNumberField.sendKeys("371449635398431");

		driver.switchTo().defaultContent();
		ExMonthDropbDown.click();
		Thread.sleep(1000);
		October.click();
		ExYearDropbDown.click();
		Thread.sleep(1000);
		Year2025.click();
		CVV.sendKeys("999");
		NameOnCard.sendKeys("RX Build");
		NickName.sendKeys("UAT");
		SameAddCheckBox.click();
	}

	public void ACH_BOF_Payement() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.xpath("//md-select[@name='ddPaymentType']"));
		PaymentTypeDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'ACH')]"));
		ACH.click();
		Wait.waitForElement(driver, 10, By.id("existingBankAccounts"));
		NewBankDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//md-option/div[contains(text(),'New Bank Account')]"));
		NewBankAccount.click();
		Thread.sleep(2000);
		BankName.sendKeys("BOF");
		Thread.sleep(1000);
		RoutingNum.sendKeys("021000021");
		Thread.sleep(1000);
		AccountTypeDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'ACH-Checking')]"));
		Thread.sleep(1000);
		Checking.click();
		Thread.sleep(1000);
		AccountNum.sendKeys("123456789");
		AccountName.sendKeys("RXX Build");
		NickName.sendKeys("UAT");
		SameAddCheckBox.click();

	}

	public void ACH_Chase_Payemnt() throws InterruptedException {

		Wait.waitForElement(driver, 10, By.xpath("//md-select[@name='ddPaymentType']"));
		PaymentTypeDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'ACH')]"));
		ACH.click();
		Wait.waitForElement(driver, 10, By.id("existingBankAccounts"));
		NewBankDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//md-option/div[contains(text(),'New Bank Account')]"));
		NewBankAccount.click();
		Thread.sleep(2000);
		BankName.sendKeys("Chase");
		Thread.sleep(1000);
		RoutingNum.sendKeys("111000614");
		Thread.sleep(1000);
		AccountTypeDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'ACH-Checking')]"));
		Checking.click();
		AccountNum.sendKeys("123456789");
		AccountName.sendKeys("RXX Build");
		NickName.sendKeys("UAT");
		SameAddCheckBox.click();
	}

}
