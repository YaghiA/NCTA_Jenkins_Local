package external_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Wait;

public class Ex_BillingInfo {
	WebDriver driver;
	
	public Ex_BillingInfo(WebDriver driver) {
		this.driver = driver;
		}
	//CreditCard
	@FindBy (how = How.ID, using ="ddlBillingType") WebElement BillingTypeDropbDown;
	@FindBy (how = How.XPATH, using ="//div[contains(text(),'Credit Card')]") WebElement CreditCard;
	@FindBy (how = How.ID, using ="ccnumfield") WebElement CardNumberField;
	@FindBy (how = How.ID, using ="ddlExpiryMonth") WebElement ExMonthDropbDown;
	@FindBy (how = How.ID, using ="ddlExpiryMonth_9") WebElement October;
	@FindBy (how = How.ID, using ="ddlExpiryYear") WebElement ExYearDropbDown;
	@FindBy (how = How.ID, using ="ddlExpiryYear_5") WebElement Year2025;
	@FindBy (how = How.ID, using ="txtCVVCode") WebElement CVV;
	@FindBy (how = How.ID, using ="txtNameOnCard") WebElement NameOnCard;
	@FindBy (how = How.ID, using ="txtNickName") WebElement NickName;
	@FindBy (how = How.XPATH, using ="//md-checkbox[@id='txtAdressSameAsPrimary']/div") WebElement SameAddCheckBox;
	
	//ACH
	@FindBy (how = How.XPATH, using ="//div[contains(text(),'ACH')]") WebElement ACH;
	@FindBy (how = How.ID, using ="txtBankName") WebElement BankName;
	@FindBy (how = How.ID, using ="txtRoutingNumber") WebElement RoutingNum;
	@FindBy (how = How.ID, using ="ddlAcccountType") WebElement AccountTypeDropDown;
	@FindBy (how = How.XPATH, using ="//div[contains(text(),'ACH-Checking')]") WebElement Checking;
	@FindBy (how = How.ID, using ="txtAcccountNumber") WebElement AccountNum;
	@FindBy (how = How.ID, using ="txtAcccountHolderName") WebElement AccountName;
	
	//Check Or Cash
	@FindBy (how = How.XPATH, using ="//div[contains(text(),'Manual')]") WebElement CheckOrCash;
	
	
	
	public void billingVisa() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.id("ddlBillingType"));
		BillingTypeDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'Credit Card')]"));
		CreditCard.click();
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
	public void billingMasterCard() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.id("ddlBillingType"));
		BillingTypeDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'Credit Card')]"));
		CreditCard.click();
		
		Thread.sleep(2000);
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
	public void billingDiscover() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.id("ddlBillingType"));
		BillingTypeDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'Credit Card')]"));
		CreditCard.click();
		Thread.sleep(2000);
		driver.switchTo().frame("tokenframe");
		Wait.waitForElement(driver, 20, By.id("ccnumfield"));
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
	public void billingAmex() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.id("ddlBillingType"));
		BillingTypeDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'Credit Card')]"));
		CreditCard.click();
		Thread.sleep(2000);
		driver.switchTo().frame("tokenframe");
		Wait.waitForElement(driver, 20, By.id("ccnumfield"));
		
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
	
	public void billingACH_BOF() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.id("ddlBillingType"));
		BillingTypeDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'ACH')]"));
		ACH.click();
		Wait.waitForElement(driver, 10, By.id("txtBankName"));
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
	
	public void billingACH_Chase() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.id("ddlBillingType"));
		BillingTypeDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'ACH')]"));
		ACH.click();
		Wait.waitForElement(driver, 10, By.id("txtBankName"));
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
	
	public void BillingCheck() {
		Wait.waitForElement(driver, 10, By.id("ddlBillingType"));
		BillingTypeDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'Manual')]"));
		CheckOrCash.click();
	}
	public void BillingCash() {
		Wait.waitForElement(driver, 10, By.id("ddlBillingType"));
		BillingTypeDropbDown.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'Manual')]"));
		CheckOrCash.click();
	}
}
