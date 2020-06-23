package steps;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import internal_page.Account_Type_Page;
import internal_page.Billing_Page;
import internal_page.Confirm_Page;
import internal_page.Contact_Page;
import internal_page.DashBoard_Page;
import internal_page.Internal_Login_Page;
import internal_page.Payment_Page;
import internal_page.Summary_Page;
import internal_page.PrePaid_Vehicles_Page;
import util.InternalWrite_Data;
import util.Internal_Common;
import util.ReadData_Excel;
import util.Wait;

public class Create_Integrity_NewAccount_Steps extends Internal_Common {

	static WebDriver driver;

	// Call Environment
	
	
	String iEnv = String.valueOf(System.getProperty("iEnv"));
	String eEnv = String.valueOf(System.getProperty("eEnv"));

	// Integrity UserName & Password
	String UserName = String.valueOf(System.getProperty("UserName"));
	String Password = String.valueOf(System.getProperty("Password"));

	// Generate Date & Time
	DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy - HH;mm;ss");
	Date date = new Date();
	String dateFormatted = dateFormat.format(date);
	String date1 = dateFormat.format(date);

	// Data Formatter
	DataFormatter formatter = new DataFormatter();

	// Generate Random String
	String RndString1 = RandomStringUtils.randomAlphabetic(2).toLowerCase();
	String RndString2 = RandomStringUtils.randomAlphabetic(3).toLowerCase();
	String RndString3 = RandomStringUtils.randomAlphabetic(4).toLowerCase();

	// Generate Random Numbers
	Random Rnd = new Random();
	int RndNm = Rnd.nextInt(99);
	int RndNm1 = Rnd.nextInt(999);
	int RndNm2 = Rnd.nextInt(9999);
	int RndNm3 = Rnd.nextInt(9999);
	int RndNm4 = Rnd.nextInt(99999);
	int RndNm5 = Rnd.nextInt(99999);

	// SpreadSheet Reader Object
	ReadData_Excel reader = new ReadData_Excel("./NCTAReadData/UAT_NCTAData.xlsx");

	// Input Test Data
	String AccountNumber;
	String FirstName = "Automation" + RndString1;
	String LastName = "Jun" + RndString2;
	String AdditionalFirstName = "AddFirst" + RndString1;
	String AdditionalLastName = "AddLast" + RndString1;;
	String StrAdress = RndNm1 + " " + "Waterford Square Drive";
	String City = "Charlotte";
	String ZipCode = "28226";
	String PhoneNum = "" + RndNm1 + RndNm2 + RndNm3;
	String AlterPhoneNum = "" + RndNm4 + RndNm3 + RndNm2;
	String Email = FirstName + LastName + "@Yopmail.com";
	String ConfirmEmail = FirstName + LastName + RndNm + "@Yopmail.com";
	String VehicleLicNum = "N" + RndNm + RndNm1;
	String VehicleModel = "NCX";
	String ActualTab = null;

	@After
	public void closeBrowser(Scenario scenario){
	    if(scenario.isFailed()){
	        try{
	 
	            TakesScreenshot screenshot = (TakesScreenshot)driver;
	            File source = screenshot.getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(source, new File("logs/screenshots/" + scenario.getName() + ".png"));
	            System.out.println("Screenshot taken");
	        } catch (Exception e){
	            System.out.println("Exception while taking screenshot " + e.getMessage());
	        }
	    }
	    driver.quit();
	}
	


	@Given("^a valid Integrity user$")
	public void a_valid_Integrity_user() throws Throwable {
//		 UserName = reader.getStringCellData("User_Pass", "User_Name", 2);
// 		Password = reader.getStringCellData("User_Pass", "Password", 2);
//		FirstName = reader.getStringCellData("UAT_QuickPass", "First_Name", RowNumber);
//		LastName = reader.getStringCellData("UAT_QuickPass", "Last_Name", RowNumber);
//		AdditionalFirstName = reader.getStringCellData("UAT_QuickPass", "Additional_FirstName", RowNumber);
//		AdditionalLastName = reader.getStringCellData("UAT_QuickPass", "Additional_LastName", RowNumber);
//		StrAdress = reader.getStringCellData("UAT_QuickPass", "Street_Address", RowNumber);
//		City = reader.getStringCellData("UAT_QuickPass", "City", 2);
//		String ZipCode = formatter.formatCellValue(reader.getIntCellData("UAT_Personal_QuickPass","Zip_Code", RowNumber));
//		PhoneNum = formatter.formatCellValue(reader.getIntCellData("UAT_QuickPass", "Primary_Phone_Number", RowNumber));
//		Email = reader.getStringCellData("UAT_QuickPass", "Email_Address", RowNumber);
//		ConfirmEmail = reader.getStringCellData("UAT_QuickPass", "Email_Address", RowNumber);
//		AlterPhoneNum = formatter.formatCellValue(reader.getIntCellData("UAT_QuickPass", "Alternate_Phone", RowNumber));
//		VehicleLicNum = reader.getStringCellData("UAT_QuickPass", "Lic_Plate", RowNumber);
//		VehicleModel = reader.getStringCellData("UAT_QuickPass", "Model", RowNumber);
	}

	@When("^User goes to NCTA Integrity site and login with valid Credential$")
	public void user_goes_to_NCTA_Integrity_site_and_login_with_valid_Credential() throws Throwable {

		driver = Internal_Common.openBrowser(iEnv);
		Internal_Login_Page intLoginPage = PageFactory.initElements(driver, Internal_Login_Page.class);
		intLoginPage.InputUserNameAndPassword(UserName, Password);

	}

	@Then("^Home page should display$")
	public void home_page_should_display() throws Throwable {
		pageLoad(60);
		Wait.waitForElement(driver, 60, By.xpath("//i[@class='navToggle sideNavSlideout']"));
	}

	@When("^User click on hamburger and click on Create new account$")
	public void user_click_on_hamburger_and_click_on_Create_new_account() throws Throwable {
		pageLoad(60);
		DashBoard_Page dashboard = PageFactory.initElements(driver, DashBoard_Page.class);
		dashboard.NavToCreateAccount();
	}

	@Then("^Account type tab should display$")
	public void account_type_tab_should_display() throws Throwable {
		Thread.sleep(5000);
		try {
			Wait.waitForElement(driver, 60, By.xpath("//ul[@class='panel-header']/descendant::a[text()='1: ACCOUNT TYPE']"));
		} catch (Exception e) {
		}
		pageLoad(60);

		ActualTab = driver.findElement(By.xpath("//ul[@class='panel-header']/descendant::a")).getText();
		String ExpectedAccTypeTab = "1: ACCOUNT TYPE";
		assertEquals("Account Type Tab Not Showing !!!", ExpectedAccTypeTab, ActualTab);
	}

	@When("^User choose account type personal and click next$")
	public void user_choose_account_type_personal_and_click_next() throws Throwable {
		Account_Type_Page AccountType = PageFactory.initElements(driver, Account_Type_Page.class);
		AccountType.QuickPassPersonal();
		Wait.waitForElementToBeClicable(driver, 10, By.xpath("//span[contains(text(),'NEXT')]"));
		Next().click();

	}

	@When("^User choose account type Business and click next$")
	public void user_choose_account_type_Business_and_click_next() throws Throwable {
		Account_Type_Page AccountType = PageFactory.initElements(driver, Account_Type_Page.class);
		AccountType.QuickPassBusiness();
		Wait.waitForElementToBeClicable(driver, 10, By.xpath("//span[contains(text(),'NEXT')]"));
		driver.findElement(By.xpath("//span[contains(text(),'NEXT')]")).click();
		// Internal_Common.Next().click();

	}

	@When("^User choose account type Government and click next$")
	public void user_choose_account_type_Government_and_click_next() throws Throwable {
		Account_Type_Page AccountType = PageFactory.initElements(driver, Account_Type_Page.class);
		AccountType.GovernmentAccount();
		Wait.waitForElementToBeClicable(driver, 10, By.xpath("//span[contains(text(),'NEXT')]"));

		Next().click();
	}

	@When("^User choose account type FirstResponder and click next$")
	public void user_choose_account_type_FirstResponder_and_click_next() throws Throwable {
		Account_Type_Page AccountType = PageFactory.initElements(driver, Account_Type_Page.class);
		AccountType.FirstResponderAccount();
		Wait.waitForElementToBeClicable(driver, 10, By.xpath("//span[contains(text(),'NEXT')]"));

		Next().click();
	}

	@When("^User choose account type HOV Only and click next$")
	public void user_choose_account_type_HOV_Only_and_click_next() throws Throwable {
		Account_Type_Page AccountType = PageFactory.initElements(driver, Account_Type_Page.class);
		AccountType.HOVOnlAccount();
		Wait.waitForElementToBeClicable(driver, 10, By.xpath("//span[contains(text(),'NEXT')]"));

		Next().click();
	}

	@When("^User choose account type registered LicePlate and click next$")
	public void user_choose_account_type_registered_LicePlate_and_click_next() throws Throwable {
		Account_Type_Page AccountType = PageFactory.initElements(driver, Account_Type_Page.class);
		AccountType.RegisteredLicPlateAccount();
		Wait.waitForElementToBeClicable(driver, 10, By.xpath("//span[contains(text(),'NEXT')]"));

		Next().click();

	}

	@When("^User choose account type Transit and click next$")
	public void user_choose_account_type_Transit_and_click_next() throws Throwable {
		Account_Type_Page AccountType = PageFactory.initElements(driver, Account_Type_Page.class);
		AccountType.TransitAccount();
		Wait.waitForElementToBeClicable(driver, 10, By.xpath("//span[contains(text(),'NEXT')]"));

		Next().click();
	}

	@Then("^Contact tab should display$")
	public void contact_tab_should_display() throws Throwable {
		Thread.sleep(5000);
		try {
			Wait.waitForElement(driver, 60, By.xpath("//ul[@class='panel-header']/descendant::a[text()=' 2:CONTACT INFO']"));
		} catch (Exception e) {
		}
		pageLoad(60);

		ActualTab = driver.findElement(By.xpath("//ul[@class='panel-header']/descendant::a")).getText();
		String ExpectedContactTab = "2:CONTACT INFO";
		assertEquals("Contact Info Tab Not Showing  !!!", ExpectedContactTab, ActualTab);
	}

	@When("^User fill Personal contact information fields and click next$")
	public void user_fill_Personal_contact_information_fields_and_click_next() throws Throwable {
		pageLoad(60);
		Contact_Page contactInfo = PageFactory.initElements(driver, Contact_Page.class);
		contactInfo.InputPersonalNameAndAddress(FirstName, LastName, StrAdress, City, ZipCode);
		contactInfo.InputEmailAndPhone(PhoneNum, Email, Email);
		contactInfo.CustomerCorrespondencePreferences();
		Next().click();
		try {
			Wait.waitForElement(driver, 5, By.xpath("//span[contains(text(),'OK')]"));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
		} catch (Exception e) {
		}

	}

	@When("^User fill Business contact information fields and click next$")
	public void user_fill_Business_contact_information_fields_and_click_next() throws Throwable {
		pageLoad(60);
		Contact_Page contactInfo = PageFactory.initElements(driver, Contact_Page.class);
		contactInfo.InputBusinessNameAndAddress("JS B QP", FirstName, LastName, AdditionalFirstName, AdditionalLastName,
				StrAdress, City, ZipCode);
		contactInfo.InputEmailAndPhone(PhoneNum, Email, Email);
		contactInfo.CustomerCorrespondencePreferences();
		Next().click();
		try {
			Wait.waitForElement(driver, 5, By.xpath("//span[contains(text(),'OK')]"));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
		} catch (Exception e) {
		}

	}

	@Then("^Vehicles tab should display$")
	public void vehicles_tab_should_display() throws Throwable {
		Thread.sleep(5000);
		try {
			Wait.waitForElement(driver, 60, By.xpath("//ul[@class='panel-header']/descendant::a[text()='3: VEHICLES & TRANSPONDERS']"));
		} catch (Exception e) {
		}
		pageLoad(60);
		ActualTab = driver.findElement(By.xpath("//ul[@class='panel-header']/descendant::a")).getText();
		String ExpectedVehicleTab = "3: VEHICLES & TRANSPONDERS";
		assertEquals("Vehicle And Transponder Tab Not Showing !!!", ExpectedVehicleTab, ActualTab);
	}

	@When("^User add vehicles and transponders Interior Free warehouse and click next$")
	public void user_add_vehicles_and_transponders_Interior_Free_warehouse_and_click_next() throws Throwable {
		pageLoad(60);
		PrePaid_Vehicles_Page vehiclePage = PageFactory.initElements(driver, PrePaid_Vehicles_Page.class);
		vehiclePage.AddVehicleWithTransponderInteriorFree(VehicleLicNum + RndNm1, VehicleModel);
		Next().click();

	}

	@When("^User add vehicles and transponders Exterior Free warehouse and click next$")
	public void user_add_vehicles_and_transponders_Exterior_Free_warehouse_and_click_next() throws Throwable {
		pageLoad(60);
		PrePaid_Vehicles_Page vehiclePage = PageFactory.initElements(driver, PrePaid_Vehicles_Page.class);
		vehiclePage.AddVehicleWithTransponderExteriorQPassFree(VehicleLicNum + RndNm1, VehicleModel);
		Next().click();
	}
	
	@When("^User add vehicles and transponders ExteriorHardCase warehouse and click next$")
	public void user_add_vehicles_and_transponders_ExteriorHardCase_warehouse_and_click_next() throws Throwable {
		
		pageLoad(60);
		PrePaid_Vehicles_Page vehiclePage = PageFactory.initElements(driver, PrePaid_Vehicles_Page.class);
		vehiclePage.AddVehicleWithTransponderExteriorEZPassHardCase(VehicleLicNum + RndNm1, VehicleModel);
		Next().click();
		
	}
	
	@When("^User add vehicles and transponders Interior HardCaseHOV warehouse and click next$")
	public void user_add_vehicles_and_transponders_Interior_HardCaseHOV_warehouse_and_click_next() throws Throwable {
		pageLoad(60);
		PrePaid_Vehicles_Page vehiclePage = PageFactory.initElements(driver, PrePaid_Vehicles_Page.class);
		vehiclePage.AddVehicleWithTransponderIntEZPassHardCaseHOV(VehicleLicNum + RndNm1, VehicleModel);
		Next().click();
		
		
	}
	
	@When("^User add vehicles and transponders Interior HardCase warehouse and click next$")
	public void user_add_vehicles_and_transponders_Interior_HardCase_warehouse_and_click_next() throws Throwable {
		pageLoad(60);
		PrePaid_Vehicles_Page vehiclePage = PageFactory.initElements(driver, PrePaid_Vehicles_Page.class);
		vehiclePage.AddVehicleWithTransponderIntEZPassHardCase(VehicleLicNum + RndNm1, VehicleModel);
		Next().click();
		
		
	}
	
	@When("^User add vehicles Only and transponders Only Interior Free warehouse and click next$")
	public void user_add_vehicles_Only_and_transponders_Only_Interior_Free_warehouse_and_click_next() throws Throwable {
		pageLoad(60);
		PrePaid_Vehicles_Page vehiclePage = PageFactory.initElements(driver, PrePaid_Vehicles_Page.class);
		vehiclePage.AddVehicleOnly(VehicleLicNum + RndNm1, VehicleModel);
		Thread.sleep(3000);
		vehiclePage.AddTransponderInteriorFreeOnly();
		Next().click();

	}

	@When("^User add vehicles and transponders Transite Sticker and click next$")
	public void user_add_vehicles_and_transponders_Transite_Sticker_and_click_next() throws Throwable {
		pageLoad(60);
		PrePaid_Vehicles_Page vehiclePage = PageFactory.initElements(driver, PrePaid_Vehicles_Page.class);
		vehiclePage.AddVehicleOnly(VehicleLicNum + RndNm, VehicleModel);
		Thread.sleep(3000);
		vehiclePage.Add_Transit_Transponder();
		Next().click();

	}

	@When("^User add vehicles and transponders FirstResponder Sticker warehouse and click next$")
	public void user_add_vehicles_and_transponders_FirstResponder_Sticker_warehouse_and_click_next() throws Throwable {
		
		pageLoad(60);
		PrePaid_Vehicles_Page vehiclePage = PageFactory.initElements(driver, PrePaid_Vehicles_Page.class);
		vehiclePage.AddVehicleWithTransponderFirstResponderSticker(VehicleLicNum + RndNm1, VehicleModel);
		Next().click();
	}
	
	@Then("^Billing tab should display$")
	public void billing_tab_should_display() throws Throwable {
		Thread.sleep(5000);
		try {
			Wait.waitForElement(driver, 60, By.xpath("//ul[@class='panel-header']/descendant::a[text()='4: BILLING OPTIONS']"));
		} catch (Exception e) {
		}
		pageLoad(60);
		ActualTab = driver.findElement(By.xpath("//ul[@class='panel-header']/descendant::a")).getText();
		String ExpectedBillingTab = "4: BILLING OPTIONS";
		assertEquals("Billing Option Tab Not Showing !!!", ExpectedBillingTab, ActualTab);
	}

	@When("^User fill billing CC MasterCard details and click next$")
	public void user_fill_billing_CC_MasterCard_details_and_click_next() throws Throwable {
		pageLoad(60);
		Wait.waitForElement(driver, 20, By.id("txtAccountNo"));
		Thread.sleep(1000);
		AccountNumber = driver.findElement(By.id("txtAccountNo")).getAttribute("value");
		Billing_Page billing = PageFactory.initElements(driver, Billing_Page.class);
		billing.Billing_CC_Visa(FirstName);
		Next().click();
		try {
			Wait.waitForElement(driver, 20, By.xpath("//span[contains(text(),'OK')]"));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
		} catch (Exception e) {
		}
	}

	@When("^User fill billing CC Visa details and click next$")
	public void user_fill_billing_CC_Visa_details_and_click_next() throws Throwable {
		pageLoad(60);
		Wait.waitForElement(driver, 20, By.id("txtAccountNo"));
		Thread.sleep(1000);
		AccountNumber = driver.findElement(By.id("txtAccountNo")).getAttribute("value");
		Billing_Page billing = PageFactory.initElements(driver, Billing_Page.class);
		billing.Billing_CC_Visa(FirstName);
		Next().click();
		try {
			Wait.waitForElement(driver, 20, By.xpath("//span[contains(text(),'OK')]"));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
		} catch (Exception e) {
		}

	}
	
	@When("^User fill billing CC Discover details and click next$")
	public void user_fill_billing_CC_Discover_details_and_click_next() throws Throwable {
		
		pageLoad(60);
		Wait.waitForElement(driver, 20, By.id("txtAccountNo"));
		Thread.sleep(1000);
		AccountNumber = driver.findElement(By.id("txtAccountNo")).getAttribute("value");
		Billing_Page billing = PageFactory.initElements(driver, Billing_Page.class);
		billing.Billing_CC_Discover(FirstName);
		Next().click();
		try {
			Wait.waitForElement(driver, 20, By.xpath("//span[contains(text(),'OK')]"));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
		} catch (Exception e) {
		}

	}

	@When("^User fill billing ACH BOF details and click next$")
	public void user_fill_billing_ACH_BOF_details_and_click_next() throws Throwable {
		pageLoad(60);
		Wait.waitForElement(driver, 20, By.id("txtAccountNo"));
		Thread.sleep(1000);
		AccountNumber = driver.findElement(By.id("txtAccountNo")).getAttribute("value");
		Billing_Page billing = PageFactory.initElements(driver, Billing_Page.class);
		billing.Billing_ACH_BOF(FirstName);
		Next().click();

	}
	

	
	@When("^User fill billing ACH Chase details and click next$")
	public void user_fill_billing_ACH_Chase_details_and_click_next() throws Throwable {
		pageLoad(60);
		Wait.waitForElement(driver, 20, By.id("txtAccountNo"));
		Thread.sleep(1000);
		AccountNumber = driver.findElement(By.id("txtAccountNo")).getAttribute("value");
		Billing_Page billing = PageFactory.initElements(driver, Billing_Page.class);
		billing.Billing_ACH_Chase(FirstName);
		Next().click();
		
	}
	

	@When("^User fill billing Cash details and click next$")
	public void user_fill_billing_Cash_details_and_click_next() throws Throwable {
		pageLoad(60);
		Wait.waitForElement(driver, 20, By.id("txtAccountNo"));
		Thread.sleep(1000);
		AccountNumber = driver.findElement(By.id("txtAccountNo")).getAttribute("value");
		Billing_Page billing = PageFactory.initElements(driver, Billing_Page.class);
		billing.Billing_Cash();
		Next().click();

	}

	@When("^User fill billing Check details and click next$")
	public void user_fill_billing_Check_details_and_click_next() throws Throwable {
		pageLoad(60);
		Wait.waitForElement(driver, 20, By.id("txtAccountNo"));
		Thread.sleep(1000);
		AccountNumber = driver.findElement(By.id("txtAccountNo")).getAttribute("value");
		Billing_Page billing = PageFactory.initElements(driver, Billing_Page.class);
		billing.Billing_Check();
		Thread.sleep(2000);
		Next().click();

	}

	@Then("^Confirm tab should display$")
	public void confirm_tab_should_display() throws Throwable {
		Thread.sleep(5000);
		pageLoad(60);
		try {
			Wait.waitForElement(driver, 60, By.xpath("//ul[@class='panel-header']/descendant::a[text()='6: CONFIRMATION']"));
		} catch (Exception e) {
		}
		pageLoad(60);
		ActualTab = driver.findElement(By.xpath("//ul[@class='panel-header']/descendant::a")).getText();
		String ExpectedConfirmTab = "6: CONFIRMATION";
		assertEquals("Confirmation Option Tab Not Showing !!!", ExpectedConfirmTab, ActualTab);
	}

	@When("^User click next on confirmation tab$")
	public void user_click_next_on_confirmation_tab() throws Throwable {
		pageLoad(60);
		Confirm_Page confirmPage = PageFactory.initElements(driver, Confirm_Page.class);
		confirmPage.ConfirmInfo();
		Next().click();
	}

	@Then("^Payment tab should display$")
	public void payment_tab_should_display() throws Throwable {
		Thread.sleep(5000);
		try {
			Wait.waitForElement(driver, 60, By.xpath("//ul[@class='panel-header']/descendant::a[text()='6: Payment']"));
		} catch (Exception e) {
		}
		pageLoad(60);
		ActualTab = driver.findElement(By.xpath("//ul[@class='panel-header']/descendant::a")).getText();
		String ExpectedPaymentTab = "6: PAYMENT";
		assertEquals("Payment Tab Not Showing !!!", ExpectedPaymentTab, ActualTab);
	}

	@When("^User fill payment CC MasterCard detailes and click next$")
	public void user_fill_payment_CC_MasterCard_detailes_and_click_next() throws Throwable {
		pageLoad(60);
		Payment_Page paymentPage = PageFactory.initElements(driver, Payment_Page.class);
		paymentPage.Payment_CC_MasterCard(FirstName);
		Thread.sleep(1000);
		Next().click();
		try {
			Wait.waitForElement(driver, 20, By.xpath("//span[contains(text(),'OK')]"));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
		} catch (Exception e) {
		}
	}

	@When("^User fill payment CC Visa detailes and click next$")
	public void user_fill_payment_CC_Visa_detailes_and_click_next() throws Throwable {
		pageLoad(60);
		Payment_Page paymentPage = PageFactory.initElements(driver, Payment_Page.class);
		paymentPage.Payment_CC_Visa(FirstName);
		Thread.sleep(1000);
		Next().click();
		try {
			Wait.waitForElement(driver, 20, By.xpath("//span[contains(text(),'OK')]"));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
		} catch (Exception e) {
		}
	}
	
	@When("^User fill payment CC Discover detailes and click next$")
	public void user_fill_payment_CC_Discover_detailes_and_click_next() throws Throwable {
		pageLoad(60);
		Payment_Page paymentPage = PageFactory.initElements(driver, Payment_Page.class);
		paymentPage.Payment_CC_Discover(FirstName);
		Thread.sleep(1000);
		Next().click();
		try {
			Wait.waitForElement(driver, 20, By.xpath("//span[contains(text(),'OK')]"));
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(text(),'OK')]")).click();
		} catch (Exception e) {
		}
		
		
	}

	@When("^User fill payment ACH BOF detailes and click next$")
	public void user_fill_payment_ACH_BOF_detailes_and_click_next() throws Throwable {
		pageLoad(60);
		Payment_Page paymentPage = PageFactory.initElements(driver, Payment_Page.class);
		paymentPage.Payment_ACH_BOF(FirstName);
		Thread.sleep(2000);
		Next().click();

	}
	@When("^User fill payment ACH Chase detailes and click next$")
	public void user_fill_payment_ACH_Chase_detailes_and_click_next() throws Throwable {
		
		pageLoad(60);
		Payment_Page paymentPage = PageFactory.initElements(driver, Payment_Page.class);
		paymentPage.Payment_ACH_Chase(FirstName);
		Thread.sleep(2000);
		Next().click();
	}

	@When("^User fill payment Cash detailes and click next$")
	public void user_fill_payment_Cash_detailes_and_click_next() throws Throwable {
		
		pageLoad(60);
		Payment_Page paymentPage = PageFactory.initElements(driver, Payment_Page.class);
		paymentPage.Payment_Cash();
		Thread.sleep(1000);
		Next().click();

	}

	@When("^User fill payment Check detailes and click next$")
	public void user_fill_payment_Check_detailes_and_click_next() throws Throwable {
		pageLoad(60);
		Payment_Page paymentPage = PageFactory.initElements(driver, Payment_Page.class);
		paymentPage.Payment_Check(FirstName);
		Thread.sleep(1000);
		Next().click();

	}

	@Then("^Summary tab should display$")
	public void summary_tab_should_display() throws Throwable {
		Thread.sleep(5000);
		try {
			Wait.waitForElement(driver, 60, By.xpath("//ul[@class='panel-header']/descendant::a"));
		} catch (Exception e) {
		}
		pageLoad(60);
		ActualTab = driver.findElement(By.xpath("//ul[@class='panel-header']/descendant::a")).getText();
		String ExpectedSummaryTab = "7: SUMMARY";
		assertEquals("Payment Tab Not Showing !!!", ExpectedSummaryTab, ActualTab);
	}

	@When("^User click on print and send by email the details and receipt$")
	public void user_click_on_print_and_send_by_email_the_details_and_receipt() throws Throwable {
		pageLoad(60);
		Summary_Page summaryPage = PageFactory.initElements(driver, Summary_Page.class);
		summaryPage.PrintEmailRecieptAndSummary();

	}

	@When("^User click on print and send by email the details$")
	public void user_click_on_print_and_send_by_email_the_details() throws Throwable {
		pageLoad(60);
		Summary_Page summaryPage = PageFactory.initElements(driver, Summary_Page.class);
		summaryPage.PrintAndEmailSummaryOnly();

	}

	@Then("^Details and receipt email msg should display and print page should display$")
	public void details_and_receipt_email_msg_should_display_and_print_page_should_display() throws Throwable {
		Thread.sleep(5000);
		try {
			Wait.waitForElement(driver, 60, By.xpath("//ul[@class='panel-header']/descendant::a"));
		} catch (Exception e) {
		}
//		pageLoad(60);
//		takeScrShot(driver,
//				"./ScreenShot/InternalScreenShot/QP_Personal (Acc#" + AccountNumber + ")" + dateFormatted + ".png");
//		Thread.sleep(5000);
//		System.out.println(AccountNumber);
//		System.out.println(dateFormatted);
//
//		InternalWrite_Data.StorePersonalAccountNumber("./AccountNumber/Internal_AccNumber.xlsx", AccountNumber);

	}

	@Then("^Store Personal Account Number take screenshot and click finish button$")
	public void store_Personal_Account_Number_take_screenshot_and_click_finish_button() throws Throwable {
		Thread.sleep(5000);
		try {
			Wait.waitForElement(driver, 60, By.xpath("//ul[@class='panel-header']/descendant::a"));
		} catch (Exception e) {
		}
		pageLoad(60);
		takeScrShot(driver,
				"./ScreenShot/InternalScreenShot/QP_Personal (Acc#" + AccountNumber + ")" + dateFormatted + ".png");
		Thread.sleep(5000);
		System.out.println(AccountNumber);
		System.out.println(dateFormatted);

		InternalWrite_Data.StorePersonalAccountNumber("./AccountNumber/Internal_AccNumber.xlsx", AccountNumber ,VehicleLicNum );
		Finish().click();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

	@Then("^Store Business Account Number take screenshot and click finish button$")
	public void store_Business_Account_Number_take_screenshot_and_click_finish_button() throws Throwable {
		Thread.sleep(5000);
		try {
			Wait.waitForElement(driver, 60, By.xpath("//ul[@class='panel-header']/descendant::a"));
		} catch (Exception e) {
		}
		pageLoad(60);
		takeScrShot(driver,
				"./ScreenShot/InternalScreenShot/QP_Business (Acc#" + AccountNumber + ")" + dateFormatted + ".png");
		Thread.sleep(5000);
		System.out.println(AccountNumber);
		System.out.println(dateFormatted);

		InternalWrite_Data.StoreBusinessAccountNumber("./AccountNumber/Internal_AccNumber.xlsx", AccountNumber);
		Finish().click();

		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

	@Then("^Store FirstResponder Account Number take screenshot and click finish button$")
	public void store_FirstResponder_Account_Number_take_screenshot_and_click_finish_button() throws Throwable {
		Thread.sleep(5000);
		try {
			Wait.waitForElement(driver, 60, By.xpath("//ul[@class='panel-header']/descendant::a"));
		} catch (Exception e) {
		}
		pageLoad(60);
		takeScrShot(driver,
				"./ScreenShot/InternalScreenShot/FirstResponder (Acc#" + AccountNumber + ")" + dateFormatted + ".png");
		Thread.sleep(5000);
		System.out.println(AccountNumber);
		System.out.println(dateFormatted);

		InternalWrite_Data.StoreFirstResponderAccountNumber("./AccountNumber/Internal_AccNumber.xlsx", AccountNumber);
		Finish().click();

		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

	@Then("^Store Government Account Number take screenshot and click finish button$")
	public void store_Government_Account_Number_take_screenshot_and_click_finish_button() throws Throwable {
		Thread.sleep(5000);
		try {
			Wait.waitForElement(driver, 60, By.xpath("//ul[@class='panel-header']/descendant::a"));
		} catch (Exception e) {
		}
		pageLoad(60);
		takeScrShot(driver,
				"./ScreenShot/InternalScreenShot/Government (Acc#" + AccountNumber + ")" + dateFormatted + ".png");
		Thread.sleep(5000);
		System.out.println(AccountNumber);
		System.out.println(dateFormatted);

		InternalWrite_Data.StoreGovernmentAccountNumber("./AccountNumber/Internal_AccNumber.xlsx", AccountNumber);
		Finish().click();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

	@Then("^Store HOV_Only Account Number take screenshot and click finish button$")
	public void store_HOV_Only_Account_Number_take_screenshot_and_click_finish_button() throws Throwable {
		Thread.sleep(5000);
		try {
			Wait.waitForElement(driver, 60, By.xpath("//ul[@class='panel-header']/descendant::a"));
		} catch (Exception e) {
		}
		pageLoad(60);
		takeScrShot(driver,
				"./ScreenShot/InternalScreenShot/HOV_Only (Acc#" + AccountNumber + ")" + dateFormatted + ".png");
		Thread.sleep(5000);
		System.out.println(AccountNumber);
		System.out.println(dateFormatted);

		InternalWrite_Data.StoreHOVOnlyAccountNumber("./AccountNumber/Internal_AccNumber.xlsx", AccountNumber);
		Finish().click();
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

	@Then("^Store Registered_Lic_Plate Account Number take screenshot and click finish button$")
	public void store_Registered_Lic_Plate_Account_Number_take_screenshot_and_click_finish_button() throws Throwable {
		Thread.sleep(5000);
		try {
			Wait.waitForElement(driver, 60, By.xpath("//ul[@class='panel-header']/descendant::a"));
		} catch (Exception e) {
		}
		pageLoad(60);
		takeScrShot(driver, "./ScreenShot/InternalScreenShot/Registered_Lic_Plate (Acc#" + AccountNumber + ")"
				+ dateFormatted + ".png");
		Thread.sleep(5000);
		System.out.println(AccountNumber);
		System.out.println(dateFormatted);

		InternalWrite_Data.StoreRegisteredLicPlateAccountNumber("./AccountNumber/Internal_AccNumber.xlsx",
				AccountNumber);
		Finish().click();
		Thread.sleep(2000);
		driver.close();
		driver.quit();

	}

	@Then("^Store Transit Account Number take screenshot and click finish button$")
	public void store_Transit_Account_Number_take_screenshot_and_click_finish_button() throws Throwable {
		Thread.sleep(5000);
		try {
			Wait.waitForElement(driver, 60, By.xpath("//ul[@class='panel-header']/descendant::a"));
		} catch (Exception e) {
		}
		pageLoad(60);
		takeScrShot(driver,
				"./ScreenShot/InternalScreenShot/Transit (Acc#" + AccountNumber + ")" + dateFormatted + ".png");
		Thread.sleep(5000);
		System.out.println(AccountNumber);
		System.out.println(dateFormatted);

		InternalWrite_Data.StoreTransitAccountNumber("./AccountNumber/Internal_AccNumber.xlsx", AccountNumber);
		Finish().click();
		Thread.sleep(2000);
		driver.close();
		driver.quit();

	}

}
