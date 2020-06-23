package external_page;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Wait;

public class Ex_VehicleAndTransponder_Page {
	WebDriver driver;
	DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	Date date = new Date();
	String dateFormatted = dateFormat.format(date);
	Random Rnd = new Random();
	int RndNm1 = Rnd.nextInt(99);
	int RndNm2 = Rnd.nextInt(99);
	int Rnd11 = Rnd.nextInt(99);
	
	public Ex_VehicleAndTransponder_Page(WebDriver driver) {
		this.driver = driver;
		}
	
	@FindBy (how = How.NAME, using ="txtPlateNumber") WebElement PlateNum;
	@FindBy (how = How.NAME, using ="ddlMake") WebElement MakeDropDown;
	@FindBy (how = How.XPATH, using ="//li/span[text()='acura']") WebElement Acura;
	@FindBy (how = How.ID, using ="ddlVehicleMakeModel") WebElement VehModelDropDown;
	@FindBy (how = How.XPATH, using ="//li/span[text()='NCX']") WebElement NCXVehicleModel;
	@FindBy (how = How.NAME, using ="ddlYear") WebElement VehYear;
	@FindBy (how = How.XPATH, using ="//li/span[text()='2018']") WebElement Year2018;
	@FindBy (how = How.NAME, using ="ddlColor") WebElement VehColorDropDown;
	@FindBy (how = How.XPATH, using ="//li/span[text()='Blue']") WebElement ColorBlue;
	@FindBy (how = How.NAME, using ="ddlVehicleType") WebElement VehTypeDropDown;
	@FindBy (how = How.XPATH, using ="//li/span[text()='automobile and sport utility vehicle (with possible trailer)']") WebElement AutomobileVehType;
	
	@FindBy (how = How.NAME, using ="txtTagNickname") WebElement NickName;
	@FindBy (how = How.XPATH, using ="//button[@class='addVehButton k-button']") WebElement AddVehButton;
	@FindBy (how = How.XPATH, using ="//span[contains(text(),'End')]/parent::div/descendant::span[5]") WebElement EndDateDropDown;
	@FindBy (how = How.XPATH, using ="//li[@data-date-index='12']") WebElement December20;
	@FindBy (how = How.XPATH, using ="//td[@title='Thursday, December 31, 2020']") WebElement Dec3120;
	
	@FindBy (how = How.NAME, using ="ddlTag") WebElement TransponderMethodDropDown;
	@FindBy (how = How.XPATH, using ="//li/span[contains(text(),'Transponder By Mail')]") WebElement MailTransMethod;
	@FindBy (how = How.NAME, using ="ddlTagModel") WebElement TransponderModuleDropDown;
	@FindBy (how = How.XPATH, using ="//li/span[contains(text(),'Exterior NC')]") WebElement ExteriorNCTransModule;
	
	//for validation 
	@FindBy (how = How.XPATH, using ="//div[@class='vehicleContainer']/descendant::div[@class='addedList']") WebElement AddedVehicleList;
	
	
	
	
	public void FillVehicleAndTransInfo(String plateNum) throws InterruptedException {
		Wait.waitForElement(driver, 30, By.name("txtPlateNumber"));
		PlateNum.sendKeys(plateNum);
		
		NickName.click();
		try{MakeDropDown.click();
			Wait.waitForElement(driver, 20, By.xpath("//li/span[contains(text(),'Acura')]"));
		Thread.sleep(1000);
		Acura.click();}
		catch(Exception e ) {}
		Thread.sleep(1000);
		Thread.sleep(1000);
		PlateNum.click();
		Actions action = new Actions(driver);
		try{MakeDropDown.click();
		Wait.waitForElement(driver, 20, By.xpath("//li/span[contains(text(),'Acura')]"));
	Thread.sleep(1000);
	action.click(Acura).perform();}
	catch(Exception e ) {}
		NickName.click();
Thread.sleep(2000);
		VehModelDropDown.click();
		Wait.waitForElement(driver, 20, By.xpath("//li/span[text()='NCX']"));
		NCXVehicleModel.click();
		VehYear.click();
		Wait.waitForElement(driver, 30, By.xpath("//li/span[text()='2018']"));
		Year2018.click();
//		VehColorDropDown.click();
//		Wait.waitForElement(driver, 30, By.xpath("//li/span[text()='Blue']"));
//		ColorBlue.click();
//		VehTypeDropDown.click();
//		Wait.waitForElement(driver, 30, By.xpath("//li/span[text()='automobile and sport utility vehicle (with possible trailer)']"));
//		AutomobileVehType.click();
//		EndDateDropDown.click();
//		Thread.sleep(1000);
//		December20.click();
//		Thread.sleep(1000);
//		Dec3120.click();
//		Thread.sleep(1000);
//		TransponderMethodDropDown.click();
//		Thread.sleep(1000);
//		MailTransMethod.click();
//		Thread.sleep(1000);
//		TransponderModuleDropDown.click();
//		Thread.sleep(1000);
//		ExteriorNCTransModule.click();
//		Thread.sleep(1000);
//		NickName.sendKeys("RX");
//		Thread.sleep(1000);
//		AddVehButton.click();
		Thread.sleep(20000);
	}
	
}
