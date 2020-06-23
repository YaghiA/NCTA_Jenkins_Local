package internal_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Wait;

public class Contact_Page {
	WebDriver driver;

	public Contact_Page(WebDriver driver) {
		this.driver = driver;
	}

	// Contact Tab - Name & Address Element Library
	@FindBy(how = How.ID, using = "txtBusinessName")
	WebElement BusinessName;
	@FindBy(how = How.ID, using = "txtFirstName")
	WebElement FirstName;
	@FindBy(how = How.ID, using = "txtLastName")
	WebElement LastName;
	@FindBy(how = How.ID, using = "create_ddlCountry")
	WebElement Country;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'United States')]")
	WebElement UnitedState;
	@FindBy(how = How.ID, using = "create_textentryprimaryStreetAddress")
	WebElement StreetAdress;
	@FindBy(how = How.ID, using = "create_txtCityname")
	WebElement CityName;
	@FindBy(how = How.ID, using = "create_ddlState")
	WebElement State;
	@FindBy(how = How.XPATH, using = "//div[text()='North Carolina']")
	WebElement NorthCarolina;
	@FindBy(how = How.XPATH, using = "//span[text()='Accept']")
	WebElement AcceptAddressVerification;
	@FindBy(how = How.ID, using = "create_zipCodeCtrl")
	WebElement ZipCode;
	@FindBy(how = How.ID, using = "chkOptionalAddNameAccount")
	WebElement AdditionaNameCheckBox;

	// Contact Tab - Phone & Email Element Library

	@FindBy(how = How.ID, using = "txtPrimaryPhone")
	WebElement PrimaryPhone;
	@FindBy(how = How.ID, using = "ddlPhoneTypePrimary")
	WebElement PhoneType;
	@FindBy(how = How.XPATH, using = "//md-option[@id='ddlPhoneTypePrimary_1']/div[1]")
	WebElement PrimaryPhoneTypeMobile;
	@FindBy(how = How.ID, using = "txtAlternatePhone")
	WebElement AlternatePhone;
	@FindBy(how = How.ID, using = "ddlPhoneTypeAlternate")
	WebElement AlternatePhoneType;
	@FindBy(how = How.XPATH, using = "//md-option[@id='ddlPhoneTypeAlternate_2']/div[text()='Work']")
	WebElement AlternatePhoneTypeWork;
	@FindBy(how = How.ID, using = "txtEmail")
	WebElement EmailAddress;
	@FindBy(how = How.ID, using = "txtEmailConfirm")
	WebElement ConfEmailAddress;

	// Contact Tab - Additional Name on account Element Library

	@FindBy(how = How.XPATH, using = "//md-checkbox[@id='chkOptionalAddNameAccount']/div[@class='md-container md-ink-ripple']")
	WebElement AddNameCheckBox;
	@FindBy(how = How.XPATH, using = "//input[@message-id='multipleAdditionalContactFirstName']")
	WebElement AdditionalFirstName;
	@FindBy(how = How.XPATH, using = "//input[@message-id='multipleAdditionalContactlastname']")
	WebElement AdditionalLastName;

	// Contact Tab - Correspondence Element Library

	@FindBy(how = How.XPATH, using = "//md-radio-button[@id='rbtCorrespondencePref7']/div[1]")
	WebElement EmailRadioButton;
	@FindBy(how = How.XPATH, using = "//md-radio-button[@id='rbtCorrespondencePref9']/div[1]")
	WebElement MailRadioButton;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'NEXT')]")
	WebElement NextButton;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'OK')]")
	WebElement DoublicateButton;

	public void InputPersonalNameAndAddress(String firstName, String lastName, String streetAddress, String cityName,
			String zipCode) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("txtFirstName"));
		Wait.waitForElementToBeClicable(driver, 20, By.id("txtFirstName"));
		FirstName.click();
		Thread.sleep(500);
		FirstName.sendKeys(firstName);
		Thread.sleep(500);
		LastName.sendKeys(lastName);
		Thread.sleep(500);
		StreetAdress.sendKeys(streetAddress);
		Thread.sleep(500);
		CityName.sendKeys(cityName);
		Thread.sleep(500);
		ZipCode.click();
		Wait.waitForElementToBeClicable(driver, 10, By.id("create_ddlState"));

		Actions action = new Actions(driver);
		action.click(State).perform();
		Thread.sleep(1000);
		action.click(FirstName).perform();
		Thread.sleep(1000);
		action.click(State).perform();
		Wait.waitForElement(driver, 10, By.xpath("//div[text()='North Carolina']"));
		Wait.waitForElementToBeClicable(driver, 10, By.xpath("//div[text()='North Carolina']"));
		action.click(NorthCarolina).perform();

		try {
			Wait.waitForElement(driver, 5, By.xpath("//span[text()='Accept']"));
			Thread.sleep(1000);
			Wait.waitForElementToBeClicable(driver, 1, By.xpath("//span[text()='Accept']"));
			action.click(AcceptAddressVerification).perform();
		} catch (Exception e) {
			ZipCode.sendKeys(zipCode);
		}

	}

	public void InputBusinessNameAndAddress(String businessName, String firstName, String lastName,
			String additionalFirstName, String additionalLastName, String streetAddress, String cityName,
			String zipCode) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("txtBusinessName"));
		Thread.sleep(1000);
		BusinessName.sendKeys(businessName);
		Wait.waitForElement(driver, 20, By.id("txtFirstName"));
		Wait.waitForElementToBeClicable(driver, 20, By.id("txtFirstName"));
		FirstName.sendKeys(firstName);
		Thread.sleep(500);
		LastName.sendKeys(lastName);
		Thread.sleep(500);
		StreetAdress.sendKeys(streetAddress);
		Thread.sleep(500);
		CityName.sendKeys(cityName);
		Thread.sleep(500);
		ZipCode.click();
		Wait.waitForElementToBeClicable(driver, 10, By.id("create_ddlState"));
		Actions action = new Actions(driver);
		action.click(State).perform();
		Thread.sleep(1000);
		action.click(FirstName).perform();
		Thread.sleep(1000);
		action.click(State).perform();
		Wait.waitForElement(driver, 10, By.xpath("//div[text()='North Carolina']"));
		Wait.waitForElementToBeClicable(driver, 10, By.xpath("//div[text()='North Carolina']"));
		action.click(NorthCarolina).perform();

		try {
			Wait.waitForElement(driver, 20, By.xpath("//span[text()='Accept']"));
			Thread.sleep(3000);
			Wait.waitForElementToBeClicable(driver, 10, By.xpath("//span[text()='Accept']"));
			action.click(AcceptAddressVerification).perform();
		} catch (Exception e) {
			ZipCode.sendKeys(zipCode);
		}
	}

	public void InputEmailAndPhone(String primaryPhone, String emailAddress, String confEmailAddress)
			throws InterruptedException {
		Thread.sleep(500);
		PrimaryPhone.sendKeys(primaryPhone);
		Actions action = new Actions(driver);
		action.click(PhoneType).perform();
		Thread.sleep(2000);
		action.click(EmailAddress).perform();
		Thread.sleep(2000);
		action.click(PhoneType).perform();
		Wait.waitForElement(driver, 10, By.xpath("//md-option[@id='ddlPhoneTypePrimary_1']/div[1]"));
		Thread.sleep(1000);
		action.click(PrimaryPhoneTypeMobile).perform();
		Thread.sleep(1000);
		action.click(EmailAddress).perform();
		EmailAddress.sendKeys(emailAddress);
		action.click(ConfEmailAddress).perform();
		ConfEmailAddress.sendKeys(confEmailAddress);

	}

	public void AlternatePhone(String alternatePhone) throws InterruptedException {
		Thread.sleep(500);
		AlternatePhone.sendKeys(alternatePhone);
		Thread.sleep(1000);
		AlternatePhoneType.click();
		Thread.sleep(500);
		AlternatePhoneTypeWork.click();
	}

	public void AdditionalNameOnAccount(String additionalFirstName, String additionalLastName) {
		AddNameCheckBox.click();
		Wait.waitForElement(driver, 10, By.xpath("//input[@message-id='multipleAdditionalContactFirstName']"));
		AdditionalFirstName.sendKeys(additionalFirstName);
		AdditionalLastName.sendKeys(additionalLastName);
	}

	public void CustomerCorrespondencePreferences() throws InterruptedException {
		Thread.sleep(1000);
		EmailRadioButton.click();
		MailRadioButton.click();

	}

}
