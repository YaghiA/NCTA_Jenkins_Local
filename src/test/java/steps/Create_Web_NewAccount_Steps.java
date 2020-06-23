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
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import external_page.Ex_BillingInfo;
import external_page.Ex_Confirm_Page;
import external_page.Ex_Payment_Page;
import external_page.Ex_Profile_Page;
import external_page.Ex_Security_Page;
import external_page.Ex_Summary_Page;
import external_page.Ex_VehicleAndTransponder_Page;
import external_page.External_Login_Page;
import external_page.External_Terms_Page;
import util.ExternalWriteData;
import util.External_Common;
import util.Internal_Common;
import util.ReadData_Excel;
import util.Wait;

public class Create_Web_NewAccount_Steps {
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
	int RndNm = Rnd.nextInt(999);
	int RndNm1 = Rnd.nextInt(9999);
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
	String WebUserName = FirstName;
	String WebPassword = "NCta!@12";
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
	
	@Given("^a user$")
	public void a_user() throws Throwable {
		
		
		
//		 FirstName = reader.getStringCellData("UAT_QuickPass", "First_Name", RowNumber);
//		 LastName = reader.getStringCellData("UAT_QuickPass", "Last_Name", RowNumber);
//		 AdditionalFirstName = reader.getStringCellData("UAT_QuickPass", "Additional_FirstName", RowNumber);
//		 AdditionalLastName = reader.getStringCellData("UAT_QuickPass", "Additional_LastName", RowNumber);
//		 StrAdress = reader.getStringCellData("UAT_QuickPass", "Street_Address", RowNumber);
//		 City = reader.getStringCellData("UAT_QuickPass", "City", 2);
////		 String ZipCode =
////		 formatter.formatCellValue(reader.getIntCellData("UAT_Personal_QuickPass",
////		"Zip_Code", RowNumber));
//		// PhoneNum = formatter.formatCellValue(reader.getIntCellData("UAT_QuickPass", "Primary_Phone_Number", RowNumber));
//		 Email = reader.getStringCellData("UAT_QuickPass", "Email_Address", RowNumber);
//		 ConfirmEmail = reader.getStringCellData("UAT_QuickPass", "Email_Address", RowNumber);
//	//	AlterPhoneNum = formatter.formatCellValue(reader.getIntCellData("UAT_QuickPass", "Alternate_Phone", RowNumber));
//		 VehicleLicNum = reader.getStringCellData("UAT_QuickPass", "Lic_Plate", RowNumber);
//		 VehicleModel = reader.getStringCellData("UAT_QuickPass", "Model", RowNumber);
//		  WebUserName= reader.getStringCellData("UAT_QuickPass", "Ext_UserName", RowNumber);
//		 WebPassword= reader.getStringCellData("UAT_QuickPass", "Ext_Password", RowNumber);
	}

	@When("^User goes to NCTA signUp page and click on signUp button$")
	public void user_goes_to_NCTA_signUp_page_and_click_on_signUp_button() throws Throwable {
		driver =External_Common.openBrowser(eEnv);
		External_Login_Page signUp = PageFactory.initElements(driver, External_Login_Page.class);
		signUp.signUpButton();
	}

	@Then("^Terms tab should display$")
	public void terms_tab_should_display() throws Throwable  {
		Wait.waitForElement(driver, 60, By.xpath("//md-select[@ng-disabled='customerAccountTypeDataSource.length==1']"));	   
	 
	    	}

	@When("^User choose personal account type and click on agree terms checkBox and click continue button$")
	public void user_choose_personal_account_type_and_click_on_agree_terms_checkBox_and_click_continue_button() throws Throwable {
		External_Terms_Page TermsPage = PageFactory.initElements(driver, External_Terms_Page.class);
		TermsPage.chosePersoalAndAccept();	
	}

	@Then("^User personal inforamtion tab should display$")
	public void user_personal_inforamtion_tab_should_display() throws Throwable {
		try {Wait.waitForElement(driver, 40, By.xpath("//h4[text()='Personal Information']"));}
	    catch(Exception w) {}
	    assertEquals("Personal Information Tab Not Showing !!!",  "Personal Information",  driver.findElement(By.xpath("//h4[text()='Personal Information']")).getText());
	}

	@When("^User fill personal inforamtion fields and click continue button$")
	public void user_fill_personal_inforamtion_fields_and_click_continue_button() throws Throwable {
		Ex_Profile_Page profilePage = PageFactory.initElements(driver, Ex_Profile_Page.class);
		profilePage.fillPersonalPersonalInfo(FirstName , LastName, StrAdress, City, ZipCode, PhoneNum, Email);
		//External_Common.scrollDown();
		Thread.sleep(1000);
		External_Common.scrollDown();
		External_Common.Continue().click();
	}
	@Then("^Security tab should display$")
	public void security_tab_should_display() throws Throwable {
		try {Wait.waitForElement(driver, 40, By.xpath("//h4[text()='Create Username']"));}
	    catch(Exception w) {}
	    
	    assertEquals("Security Tab Not Showing !!!",  "Create Username", driver.findElement(By.xpath("//h4[text()='Create Username']")).getText());
	}

	@When("^User fill security details field and click continue button$")
	public void user_fill_security_details_field_and_click_continue_button() throws Throwable {
		Ex_Security_Page securityInfo = PageFactory.initElements(driver, Ex_Security_Page.class);
		securityInfo.FillSecurityInfo(WebUserName , WebPassword);
		External_Common.scrollDown();
		Thread.sleep(1000);
		External_Common.Continue().click();
	}

	@Then("^Vehicles & transponders tab should display$")
	public void vehicles_transponders_tab_should_display() throws Throwable {
		try {Wait.waitForElement(driver, 40, By.xpath("//h3[text()=' License Plate ']"));}
	    catch(Exception w) {}
		assertEquals("Vehicles And Transponders Tab Not Showing !!!", "License Plate", driver.findElement(By.xpath("//h3[text()=' License Plate ']")).getText());
	}

	@When("^User add vehicles and transponders and click continue button$")
	public void user_add_vehicles_and_transponders_and_click_continue_button() throws Throwable {
		Ex_VehicleAndTransponder_Page fillVehicleTrans = PageFactory.initElements(driver, Ex_VehicleAndTransponder_Page.class);
		fillVehicleTrans.FillVehicleAndTransInfo(VehicleLicNum);
//		External_Common.scrollDown();
//		Thread.sleep(1000);
//		External_Common.Continue().click();
//		try{Wait.waitForElement(driver, 10, By.xpath("//h4[text()='Prepaid']"));}
//		catch(Exception e ) {	fillVehicleTrans.FillVehicleAndTransInfo(VehicleLicNum+RndNm1);
//		External_Common.scrollDown();
//		External_Common.Continue().click();}
	}
	
	@Then("^Billing Tab should display$")
	public void billing_Tab_should_display() throws Throwable {
//		try {Wait.waitForElement(driver, 40, By.xpath("//h4[text()='Prepaid']"));}
//	    catch(Exception w) {}
//	    assertEquals("Billing Tab Not Showing !!!", "Prepaid", driver.findElement(By.xpath("//h4[text()='Prepaid']")).getText());
		
	}
	@When("^User fill billing CCVisa details and click continue button$")
	public void user_fill_billing_CCVisa_details_and_click_continue_button() throws Throwable {
		Ex_BillingInfo billing = PageFactory.initElements(driver, Ex_BillingInfo.class);
		billing.billingVisa();
		External_Common.scrollDown();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'CONTINUE')]")).click();
	}

	@Then("^Confirmation tab should display$")
	public void confirmation_tab_should_display() throws Throwable {
		try {Wait.waitForElement(driver, 40, By.xpath("//h4[text()='Profile']"));}
	    catch(Exception w) {}
	    assertEquals("Cofirmation Tab Not Showing !!!",  "Profile", driver.findElement(By.xpath("//h4[text()='Profile']")).getText());
	}

	@When("^User click continue button on confirm tab$")
	public void user_click_continue_button_on_confirm_tab() throws Throwable {
		Ex_Confirm_Page confirm = PageFactory.initElements(driver, Ex_Confirm_Page.class);
		confirm.ConfirmInfoPage();
		External_Common.scrollDown();
		Thread.sleep(1000);
		External_Common.Continue().click();
	}

	@Then("^Payment Tab Should display$")
	public void payment_Tab_Should_display() throws Throwable {
		try {Wait.waitForElement(driver, 40, By.xpath("//h4[text()='Order Summary']"));}
	    catch(Exception w) {}
	    assertEquals("Payment Tab Not Showing !!!", "Order Summary", driver.findElement(By.xpath("//h4[text()='Order Summary']")).getText());
	}

	@When("^User fill payment CCVisa detailes and click continue button$")
	public void user_fill_payment_CCVisa_detailes_and_click_continue_button() throws Throwable {
		Ex_Payment_Page paymentType =PageFactory.initElements(driver, Ex_Payment_Page.class);
		paymentType.SameBillingPaymentConfirmation_CC();
		External_Common.scrollDown();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Pay Now')]")).click();
		try{Wait.waitForElement(driver, 20, By.xpath("//span[contains(text(),'VIEW YOUR NEW ACCOUNT')]"));}
	catch(Exception e ) {driver.findElement(By.xpath("//span[contains(text(),'Pay Now')]")).click();	}
	}

	@Then("^Payment reciept tab should display$")
	public void payment_reciept_tab_should_display() throws Throwable {
		try {Wait.waitForElement(driver, 40, By.xpath("//h4[text()='Payment Receipt']"));}
	    catch(Exception w) {}
	    assertEquals("Payment Tab Not Showing !!!", "Payment Receipt", driver.findElement(By.xpath("//h4[text()='Payment Receipt']")).getText());
	}


@When("^User click on print receipt and print account summary icons and click on view your new account button$")
public void user_click_on_print_receipt_and_print_account_summary_icons_and_click_on_view_your_new_account_button() throws Throwable {
		Ex_Summary_Page summary_page = PageFactory.initElements(driver, Ex_Summary_Page.class);
		summary_page.accountSummary();
		Wait.waitForElement(driver, 10, By.xpath("//span[contains(text(),'VIEW YOUR NEW ACCOUNT')]"));
		
		driver.findElement(By.xpath("//span[contains(text(),'VIEW YOUR NEW ACCOUNT')]")).click();
	}

@Then("^New account profile page should display$")
public void new_account_profile_page_should_display() throws Throwable {
		Wait.waitForElement(driver, 20, By.xpath("//div[contains(text(),'Summary')]"));
		Thread.sleep(2000);
		
		String AccountNum = driver.findElement(By.xpath("//div[@class='contact-section']/descendant::div[10]")).getText();
		External_Common.takeScrShot(driver, "./ScreenShot/ExternalScreenShot/QP_Personal (Acc#" + AccountNum
				+ ")" + dateFormatted + ".png");
		Thread.sleep(2000);
		
		ExternalWriteData.StorePersonalAccountNumber("./AccountNumber/External_AccNumber.xlsx",
				AccountNum,WebUserName,WebPassword);
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
}
