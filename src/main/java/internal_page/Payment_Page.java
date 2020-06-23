package internal_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Wait;

public class Payment_Page {

	WebDriver driver;

	public Payment_Page(WebDriver driver) {
		this.driver = driver;
	}

	//h3[contains(text(),'Contact Info')
	
	//Credit Card Element Library
	@FindBy(how = How.ID, using = "ddPaymentType")
	WebElement PaymentTypeDropDown;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Credit Card')]")
	WebElement CreditCard;
	@FindBy(how = How.XPATH, using = "//md-select[@id='_existingCreditCards']/md-select-value[@class='md-select-value']")
	WebElement CCPaymentInfoDropDown;
	@FindBy(how = How.ID, using = "ddlexistingCreditCards1")
	WebElement NewCreditCard;
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
	@FindBy(how = How.ID, using = "_txtCVVCode")
	WebElement CVV;

	@FindBy(how = How.ID, using = "_txtNameOnCard")
	WebElement NameOnCard;
	
	
	
	//ACH Element Library
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Bank Account (ACH)')]")
	WebElement ACH;
	@FindBy(how = How.XPATH, using = "//md-select[@id='_existingBankAccounts']/md-select-value[@class='md-select-value']")
	WebElement ACHPaymentInfoDropDown;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'New Bank')]")
	WebElement NewACH;
	@FindBy(how = How.ID, using = "_txtBankName")
	WebElement BankName;
	@FindBy(how = How.ID, using = "_txtRoutingNumber")
	WebElement RoutingNumber;
	@FindBy(how = How.ID, using = "_ddlAcccountType")
	WebElement AccountTypeDropDown;
	@FindBy(how = How.XPATH, using = "//md-option[@id='ddlAcccountType_2']/div[contains(text(),'ACH-Checking')]")
	WebElement ACHChecking;
	@FindBy(how = How.ID, using = "_txtAcccountNumber")
	WebElement AccountNumber;
	@FindBy(how = How.ID, using = "_txtAcccountHolderName")
	WebElement AccountHolderName;
	
	
	//Check Element Library
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Check')]")
	WebElement Check;
	@FindBy(how = How.ID, using = "_txtPayerName")
	WebElement PayerName;
	@FindBy(how = How.ID, using = "_txtMOCHKNumber")
	WebElement CheckNumber;
	@FindBy(how = How.XPATH, using = "//div[@class='md-container md-ink-ripple']")
	WebElement ECheckbox;
	@FindBy(how = How.ID, using = "_txtECheckRoutingNumber")
	WebElement RoutingNum;
	@FindBy(how = How.ID, using = "_txtECheckAcccountNumber")
	WebElement AccountNum;
	@FindBy(how = How.XPATH, using = "//span[@class='k-icon k-i-calendar']")
	WebElement Calender;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'May')]")
	WebElement MonthMay;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'29')]")
	WebElement Day29;
	
	
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Cash')]")
	WebElement Cash;
	
	
	@FindBy(how = How.XPATH, using = "//md-checkbox[@id='txtAdressSameAsPrimary']/div[@class='md-container md-ink-ripple']")
	WebElement SameAdrressCheckBox;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'NEXT')]")
	WebElement NextButton;
	@FindBy (how = How.XPATH, using ="//span[contains(text(),'OK')]") WebElement DoublicateButton;
	
	public void Payment_CC_Visa( String nameOnCard) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("ddPaymentType"));
		PaymentTypeDropDown.click();
		Wait.waitForElement(driver, 5, By.xpath("//div[contains(text(),'Credit Card')]"));
		CreditCard.click();
		Wait.waitForElement(driver, 5, By.xpath("//md-select[@id='_existingCreditCards']/md-select-value[@class='md-select-value']"));
		CCPaymentInfoDropDown.click();
		Thread.sleep(1000);
		NewCreditCard.click();
		// Wait.waitForElement(driver, 20, By.id("tokenform"));

		driver.switchTo().frame("tokenframe");
		Thread.sleep(1000);
		CardNumberField.sendKeys("4788250000121443");
		driver.switchTo().defaultContent();
		Thread.sleep(500);
		
		
		Actions action = new Actions(driver);
		try{ExpMonthDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'May')]"));
		May.click();}
		catch(Exception j ) {
		NameOnCard.click();
		action.click(ExpMonthDropDown).perform();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'May')]"));
		May.click();
	}
		
		Thread.sleep(1000);
		ExpYearDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'2024')]"));
		Year2024.click();
		Thread.sleep(1000);
		CVV.sendKeys("999");
		NameOnCard.sendKeys(nameOnCard);
		SameAdrressCheckBox.click();
		Thread.sleep(2000);
	}
	
	public void Payment_CC_MasterCard( String nameOnCard) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("ddPaymentType"));
		PaymentTypeDropDown.click();
		Wait.waitForElement(driver, 5, By.xpath("//div[contains(text(),'Credit Card')]"));
		CreditCard.click();
		Wait.waitForElement(driver, 5, By.xpath("//md-select[@id='_existingCreditCards']/md-select-value[@class='md-select-value']"));
		CCPaymentInfoDropDown.click();
		Thread.sleep(1000);
		NewCreditCard.click();
		// Wait.waitForElement(driver, 20, By.id("tokenform"));

		driver.switchTo().frame("tokenframe");
		Thread.sleep(1000);
		CardNumberField.sendKeys("5454545454545454");
		driver.switchTo().defaultContent();
		Thread.sleep(500);
		ExpMonthDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'May')]"));
		May.click();
		Thread.sleep(1000);
		ExpYearDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'2024')]"));
		Year2024.click();
		Thread.sleep(1000);
		CVV.sendKeys("999");
		NameOnCard.sendKeys(nameOnCard);
		SameAdrressCheckBox.click();
		Thread.sleep(2000);
	}
	
	public void Payment_CC_Discover( String nameOnCard) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("ddPaymentType"));
		PaymentTypeDropDown.click();
		Wait.waitForElement(driver, 5, By.xpath("//div[contains(text(),'Credit Card')]"));
		CreditCard.click();
		Wait.waitForElement(driver, 5, By.xpath("//md-select[@id='_existingCreditCards']/md-select-value[@class='md-select-value']"));
		CCPaymentInfoDropDown.click();
		Thread.sleep(1000);
		NewCreditCard.click();
		// Wait.waitForElement(driver, 20, By.id("tokenform"));

		driver.switchTo().frame("tokenframe");
		Thread.sleep(1000);
		CardNumberField.sendKeys("6011000995500000");
		driver.switchTo().defaultContent();
		Thread.sleep(500);
		ExpMonthDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'May')]"));
		May.click();
		Thread.sleep(1000);
		ExpYearDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'2024')]"));
		Year2024.click();
		Thread.sleep(1000);
		CVV.sendKeys("999");
		NameOnCard.sendKeys(nameOnCard);
		SameAdrressCheckBox.click();
		Thread.sleep(2000);
	}
	
	
	public void Payment_CC_Amex(String nameOnCard) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("ddPaymentType"));
		PaymentTypeDropDown.click();
		Wait.waitForElement(driver, 5, By.xpath("//div[contains(text(),'Credit Card')]"));
		CreditCard.click();
		Wait.waitForElement(driver, 5, By.xpath("//md-select[@id='_existingCreditCards']/md-select-value[@class='md-select-value']"));
		CCPaymentInfoDropDown.click();
		Thread.sleep(1000);
		NewCreditCard.click();
		// Wait.waitForElement(driver, 20, By.id("tokenform"));

		driver.switchTo().frame("tokenframe");
		Thread.sleep(1000);
		CardNumberField.sendKeys("371449635398431");
		driver.switchTo().defaultContent();
		Thread.sleep(500);
		ExpMonthDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'May')]"));
		May.click();
		Thread.sleep(1000);
		ExpYearDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'2024')]"));
		Year2024.click();
		Thread.sleep(1000);
		CVV.sendKeys("999");
		NameOnCard.sendKeys(nameOnCard);
		SameAdrressCheckBox.click();
		Thread.sleep(2000);
	}
	
	
	
	public void Payment_ACH_BOF(String accountHolderName) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("ddPaymentType"));
		PaymentTypeDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'Bank Account (ACH)')]"));
		Thread.sleep(500);
		ACH.click();
		Wait.waitForElement(driver, 10, By.xpath("//md-select[@id='_existingBankAccounts']/md-select-value[@class='md-select-value']"));
		ACHPaymentInfoDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath(" //div[contains(text(),'New Bank')]"));
		NewACH.click();
		BankName.sendKeys("BOF");
		Thread.sleep(1000);
		
		RoutingNumber.click();
		Thread.sleep(1000);
		RoutingNumber.sendKeys("021000021");
		Thread.sleep(500);
		AccountTypeDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//md-option[@id='ddlAcccountType_2']/div[contains(text(),'ACH-Checking')]"));
		Thread.sleep(1000);
		ACHChecking.click();
		Thread.sleep(1000);
		AccountNumber.click();
		Thread.sleep(1000);
		AccountNumber.sendKeys("123456789");
		AccountHolderName.sendKeys(accountHolderName);
		SameAdrressCheckBox.click();
		Thread.sleep(2000);
		}
	
	public void Payment_ACH_Chase(String accountHolderName) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("ddPaymentType"));
		PaymentTypeDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'Bank Account (ACH)')]"));
		Thread.sleep(500);
		ACH.click();
		Wait.waitForElement(driver, 10, By.xpath("//md-select[@id='_existingBankAccounts']/md-select-value[@class='md-select-value']"));
		ACHPaymentInfoDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath(" //div[contains(text(),'New Bank')]"));
		NewACH.click();
		BankName.sendKeys("BOF");
		Thread.sleep(1000);
		
		RoutingNumber.click();
		Thread.sleep(1000);
		RoutingNumber.sendKeys("111000614");
		Thread.sleep(500);
		AccountTypeDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//md-option[@id='ddlAcccountType_2']/div[contains(text(),'ACH-Checking')]"));
		Thread.sleep(1000);
		ACHChecking.click();
		Thread.sleep(1000);
		AccountNumber.click();
		Thread.sleep(1000);
		AccountNumber.sendKeys("123456789");
		AccountHolderName.sendKeys(accountHolderName);
		SameAdrressCheckBox.click();
		Thread.sleep(2000);
		}
	
	public void Payment_Check(String payerName) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("ddPaymentType"));
		Thread.sleep(1000);
		PaymentTypeDropDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'Check')]"));
		Check.click();
		Wait.waitForElement(driver, 10, By.id("_txtPayerName"));
		PayerName.sendKeys(payerName);
		CheckNumber.sendKeys("123456789");
		ECheckbox.click();
		Wait.waitForElement(driver, 20, By.id("_txtECheckRoutingNumber"));
		RoutingNum.sendKeys("021000021");
		AccountNum.sendKeys("132456789");
		Calender.click();
		Wait.waitForElement(driver, 10, By.xpath("//span[contains(text(),'May')]"));
		MonthMay.click();
		Day29.click();
		Thread.sleep(1000);
		
	}
	
public void Payment_Cash() throws InterruptedException {
	Wait.waitForElement(driver, 20, By.id("ddPaymentType"));
	PaymentTypeDropDown.click();
	Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'Cash')]"));
	Cash.click();
	Thread.sleep(1000);
	
		
	}
	}
	
