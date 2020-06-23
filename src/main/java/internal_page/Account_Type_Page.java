package internal_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Wait;

public class Account_Type_Page {
	WebDriver driver;
	
	public Account_Type_Page(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy (how = How.ID, using ="ddlAccountType") WebElement AccountType;
	@FindBy (how = How.XPATH, using ="//div[contains(text(),'NC Quick Pass Personal')]") WebElement QuickPassPersonal;
	@FindBy (how = How.XPATH, using ="//div[contains(text(),'NC Quick Pass Business')]") WebElement QuickPassBusiness;
	@FindBy (how = How.XPATH, using ="//div[contains(text(),'Government')]") WebElement Government;
	@FindBy (how = How.XPATH, using ="//div[contains(text(),'First Responder')]") WebElement FirstResponder;
	@FindBy (how = How.XPATH, using ="//div[contains(text(),'HOV Only')]") WebElement HOVOnly;
	@FindBy (how = How.XPATH, using ="//div[contains(text(),'Registered License Plate')]") WebElement RegisteredLicPlate;
	@FindBy (how = How.XPATH, using ="//div[contains(text(),'Transit')]") WebElement Transit;
	
	@FindBy (how = How.ID, using ="ddlAccountTypeOption") WebElement AccountTypeOption;
	@FindBy (how = How.XPATH, using ="//span/div[contains(text(),'Prepaid')]") WebElement Prepaid;
	@FindBy (how = How.XPATH, using ="//span[contains(text(),'NEXT')]") WebElement Next;

	
	
	
	public void QuickPassPersonal() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.id("ddlAccountType"));
		Wait.waitForElementToBeClicable(driver, 10, By.id("ddlAccountType"));
		Thread.sleep(1000);
		AccountType.click();
		Wait.waitForElement(driver, 20, By.xpath("//div[contains(text(),'NC Quick Pass Personal')]"));
		QuickPassPersonal.click();
		//Next.click();
	  
		
	}
	public void QuickPassBusiness() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.id("ddlAccountType"));
		Wait.waitForElementToBeClicable(driver, 10, By.id("ddlAccountType"));
		Thread.sleep(2000);
		AccountType.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'NC Quick Pass Business')]"));
		QuickPassBusiness.click();
		//Next.click();
		
		
		
	}
	public void GovernmentAccount() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.id("ddlAccountType"));
		Wait.waitForElementToBeClicable(driver, 10, By.id("ddlAccountType"));
		Thread.sleep(2000);
		AccountType.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'Government')]"));
		Government.click();
		
	}
	public void FirstResponderAccount() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.id("ddlAccountType"));
		Wait.waitForElementToBeClicable(driver, 10, By.id("ddlAccountType"));		Thread.sleep(2000);
		AccountType.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'First Responder')]"));
		FirstResponder.click();
		
	}
	public void HOVOnlAccount() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.id("ddlAccountType"));
		Wait.waitForElementToBeClicable(driver, 10, By.id("ddlAccountType"));
		Thread.sleep(2000);
		AccountType.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'HOV Only')]"));
		HOVOnly.click();
		
	}
	public void RegisteredLicPlateAccount() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.id("ddlAccountType"));
		Wait.waitForElementToBeClicable(driver, 10, By.id("ddlAccountType"));
		Thread.sleep(2000);
		AccountType.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'Registered License Plate')]"));
		RegisteredLicPlate.click();
		
	}
	public void TransitAccount() throws InterruptedException {
		Wait.waitForElement(driver, 10, By.id("ddlAccountType"));
		Wait.waitForElementToBeClicable(driver, 10, By.id("ddlAccountType"));
		Thread.sleep(2000);
		AccountType.click();
		Wait.waitForElement(driver, 10, By.xpath("//div[contains(text(),'Transit')]"));
		Transit.click();
		
	}
}



