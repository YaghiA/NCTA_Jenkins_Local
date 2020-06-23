package external_page;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Wait;

public class Ex_Profile_Page {
WebDriver driver;
DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
Date date = new Date();
String dateFormatted = dateFormat.format(date);
Random Rnd = new Random();
int RndNm1 = Rnd.nextInt(9999);
int RndNm2 = Rnd.nextInt(9999);
int RndNm3 = Rnd.nextInt(9999);


	public Ex_Profile_Page(WebDriver driver) {
	this.driver = driver;
	}
@FindBy (how = How.ID, using ="txtBusinessName") WebElement BusinessName;
@FindBy (how = How.ID, using ="txtFirstName") WebElement FirstName;
@FindBy (how = How.ID, using ="txtLastName") WebElement LastName;
@FindBy (how = How.ID, using ="create_textentryprimaryStreetAddress") WebElement StreetAddress;
@FindBy (how = How.ID, using ="txtCity") WebElement City;
@FindBy (how = How.ID, using ="zipCodeCtrl") WebElement Zipcode;
@FindBy (how = How.XPATH, using ="//span[text()='Accept']") WebElement AcceptAddressVerification;
@FindBy (how = How.ID, using ="txtPrimaryPhone") WebElement PrimaryPhone;
@FindBy (how = How.ID, using ="ddlPhoneTypePrimary") WebElement PhoneTypeDropDown;
@FindBy (how = How.ID, using ="ddlPhoneTypePrimary_2") WebElement PhoneTypeHome;
@FindBy (how = How.ID, using ="txtEmail") WebElement Email;
@FindBy (how = How.ID, using ="txtEmailConfirm") WebElement RetypeEmail;
@FindBy (how = How.ID, using ="chkCorrespondenceEmail") WebElement correspondenceCheckBox;


public void fillBusinessPersonalInfo() throws InterruptedException {
	Wait.waitForElement(driver, 20, By.id("txtBusinessName"));
	BusinessName.sendKeys("RX Business");
	FirstName.sendKeys("RXUAT");
	LastName.sendKeys(dateFormatted);
	StreetAddress.sendKeys("10604 Catara Dr");
	City.sendKeys("Raleigh");
	Zipcode.sendKeys("27614");
	PrimaryPhone.click();
	try{Wait.waitForElement(driver, 20, By.xpath("//span[text()='Accept']"));
	Thread.sleep(1000);
	AcceptAddressVerification.click();}
	catch(TimeoutException e ) {}
	Thread.sleep(2000);
	PrimaryPhone.click();
	PrimaryPhone.sendKeys("1"+RndNm1+RndNm2+RndNm3);
	PhoneTypeDropDown.click();
	Thread.sleep(1000);
	PhoneTypeHome.click();
	Thread.sleep(1000);
	Email.sendKeys("RX"+RndNm1+"EX"+RndNm2+"@Yopmail.com");
	Thread.sleep(1000);
	RetypeEmail.sendKeys("RX"+RndNm1+"EX"+RndNm2+"@Yopmail.com");
	correspondenceCheckBox.click();
	
}
public void fillPersonalPersonalInfo(String firstName , String lastName , String StrAddress , String city ,String zipcode , String phoneNumber , String email) throws InterruptedException{
	
	Wait.waitForElement(driver, 20, By.id("txtFirstName"));
	FirstName.click();
	Thread.sleep(2000);
	FirstName.sendKeys(firstName);
	LastName.sendKeys(lastName);
	StreetAddress.sendKeys(StrAddress);
	City.sendKeys(city);
	Zipcode.sendKeys(zipcode);
	PrimaryPhone.click();
	try{Wait.waitForElement(driver, 20, By.xpath("//span[text()='Accept']"));
	Thread.sleep(1000);
	AcceptAddressVerification.click();}
	catch(TimeoutException e ) {}
	Thread.sleep(2000);
	PrimaryPhone.click();
	PrimaryPhone.sendKeys(phoneNumber);
	PhoneTypeDropDown.click();
	Thread.sleep(1000);
	PhoneTypeHome.click();
	Thread.sleep(1000);
	Email.sendKeys(email);
	Thread.sleep(1000);
	RetypeEmail.sendKeys(email);
	correspondenceCheckBox.click();
	
}
}
