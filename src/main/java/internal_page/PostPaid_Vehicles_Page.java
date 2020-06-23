package internal_page;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Wait;

public class PostPaid_Vehicles_Page {
	WebDriver driver;

	public PostPaid_Vehicles_Page(WebDriver driver) {
		this.driver = driver;
	}

	

	@FindBy(how = How.ID, using = "btnaddvehicle")
	WebElement AddVehicleButton;
	@FindBy(how = How.ID, using = "txtPlateNumber")
	WebElement PlateNmber;
	@FindBy(how = How.ID, using = "ddlPlateCountry")
	WebElement CountriesDropDown;
	@FindBy(how = How.ID, using = "ddlPlateCountry_1")
	WebElement UnitedState;
	@FindBy(how = How.ID, using = "ddlPlateState")
	WebElement StatesDropDown;
	@FindBy(how = How.ID, using = "ddlPlateState_38")
	WebElement NorthCarolina;
	@FindBy(how = How.ID, using = "ddlVehicleMake")
	WebElement VehicleMakeDropDown;
	@FindBy(how = How.ID, using = "ddlVehicleMake_83")
	WebElement Acura;
	@FindBy(how = How.NAME, using = "autocompleteField")
	WebElement VehicleModel;
	@FindBy(how = How.ID, using = "ddlVehicleYear")
	WebElement VehicleYearDropDown;
	@FindBy(how = How.ID, using = "ddlVehicleYear_2021")
	WebElement Year2021;
	@FindBy(how = How.ID, using = "ddlVehicleColor")
	WebElement VehicleColorDropDown;
	@FindBy(how = How.ID, using = "ddlVehicleColor_20")
	WebElement VehicleColorBrown;
	@FindBy(how = How.ID, using = "ddlVehicleType")
	WebElement VehicleTypeDropDown;
	@FindBy(how = How.ID, using = "ddlVehicleType_1")
	WebElement VehicleTypeCar;
	@FindBy(how = How.XPATH, using = "//div[@class='md-container md-ink-ripple']")
	WebElement ReqTransponder;
	@FindBy(how = How.ID, using = "ddlNewTag")
	WebElement AssignmentMethodDropDown;
	@FindBy(how = How.ID, using = "ddlNewTag_2")
	WebElement Warehouse;
	@FindBy(how = How.ID, using = "ddlTagType")
	WebElement TransModelDropDown;
	
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Interior NC Quick Pass Sticker (Free)')]")
	WebElement IntQPassFree;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Interior E-ZPass Hard Case ($7.40 + tax)')]")
	WebElement IntEZPassHardCase;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Interior E-ZPass, HOV Switchable Hard Case ($16.49 + tax)')]")
	WebElement IntEZPassHardCaseHOV;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Exterior NC Quick Pass Sticker (Free)')]")
	WebElement ExteriorQPassFree;
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Exterior E-ZPass Hard Case ($13.49 + tax)')]")
	WebElement ExteriorEZPassHardCase;
	
	
	@FindBy(how = How.XPATH, using = "//span[text()='Save']")
	WebElement SaveButton;
	@FindBy(how = How.ID, using = "btnaddtransponder")
	WebElement AddTransOnly;
	@FindBy(how = How.XPATH, using = "//div[text()='Transit Sticker']")
	WebElement TransitSticker;
	
	
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'NEXT')]")
	WebElement NextButton;
	

	public void AddVehicleOnly(String plateNumber, String vehicleModel) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("btnaddvehicle"));
		AddVehicleButton.click();
		Wait.waitForElement(driver, 20, By.id("txtPlateNumber"));
		PlateNmber.sendKeys(plateNumber);
		Thread.sleep(1000);
//		CountriesDropDown.click();
//		Wait.waitForElement(driver, 20, By.id("ddlPlateCountry_1"));
//		Thread.sleep(2000);
//		UnitedState.click();
//		Thread.sleep(500);
//		StatesDropDown.click();
//		Thread.sleep(1000);
//		NorthCarolina.click();
//		Thread.sleep(500);
		VehicleMakeDropDown.click();
		Thread.sleep(500);
		Acura.click();
		Thread.sleep(500);
		VehicleModel.sendKeys(vehicleModel);
		try {
			driver.findElement(By.xpath("//li[@ng-click=\"$mdAutocompleteCtrl.select($index)\"][1]")).click();
		} catch (NoSuchElementException e) {
		}
		Thread.sleep(500);
		VehicleYearDropDown.click();
		Thread.sleep(500);
		Year2021.click();
		Thread.sleep(500);
		VehicleColorDropDown.click();
		Thread.sleep(500);
		VehicleColorBrown.click();
		Thread.sleep(500);
		VehicleTypeDropDown.click();
		Thread.sleep(500);
		VehicleTypeCar.click();
		SaveButton.click();
		try {Wait.waitForElement(driver, 5, By.xpath("//span[contains(text(),'already registered')]"));
		PlateNmber.clear();
		PlateNmber.sendKeys(plateNumber+"D1");
		SaveButton.click();
		
		}
		catch(Exception r) {}
		
	}
	
	public void AddVehicleWithTransponderExteriorEZPassHardCase(String plateNumber, String vehicleModel) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("btnaddvehicle"));
		AddVehicleButton.click();
		Wait.waitForElement(driver, 20, By.id("txtPlateNumber"));
		PlateNmber.sendKeys(plateNumber);
		Thread.sleep(1000);
//		CountriesDropDown.click();
//		Wait.waitForElement(driver, 20, By.id("ddlPlateCountry_1"));
//		Thread.sleep(2000);
//		UnitedState.click();
//		Thread.sleep(500);
//		StatesDropDown.click();
//		Thread.sleep(1000);
//		NorthCarolina.click();
//		Thread.sleep(500);
		VehicleMakeDropDown.click();
		Thread.sleep(500);
		Acura.click();
		Thread.sleep(500);
		VehicleModel.sendKeys(vehicleModel);
		try {
			driver.findElement(By.xpath("//li[@ng-click=\"$mdAutocompleteCtrl.select($index)\"][1]")).click();
		} catch (NoSuchElementException e) {
		}
		Thread.sleep(500);
		VehicleYearDropDown.click();
		Thread.sleep(500);
		Year2021.click();
		Thread.sleep(500);
		VehicleColorDropDown.click();
		Thread.sleep(500);
		VehicleColorBrown.click();
		Thread.sleep(500);
		VehicleTypeDropDown.click();
		Thread.sleep(500);
		VehicleTypeCar.click();
		Thread.sleep(500);
		ReqTransponder.click();
		Wait.waitForElement(driver, 20, By.id("ddlNewTag"));
		AssignmentMethodDropDown.click();
		Thread.sleep(500);
		Warehouse.click();
		Thread.sleep(500);
		TransModelDropDown.click();
		Thread.sleep(500);
		ExteriorEZPassHardCase.click();
		Thread.sleep(500);
		SaveButton.click();
		Thread.sleep(3000);

	}
	public void AddVehicleWithTransponderExteriorQPassFree(String plateNumber, String vehicleModel) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("btnaddvehicle"));
		AddVehicleButton.click();
		Wait.waitForElement(driver, 20, By.id("txtPlateNumber"));
		PlateNmber.sendKeys(plateNumber);
		Thread.sleep(1000);
//		CountriesDropDown.click();
//		Wait.waitForElement(driver, 20, By.id("ddlPlateCountry_1"));
//		Thread.sleep(2000);
//		UnitedState.click();
//		Thread.sleep(500);
//		StatesDropDown.click();
//		Thread.sleep(1000);
//		NorthCarolina.click();
//		Thread.sleep(500);
		VehicleMakeDropDown.click();
		Thread.sleep(500);
		Acura.click();
		Thread.sleep(500);
		VehicleModel.sendKeys(vehicleModel);
		try {
			driver.findElement(By.xpath("//li[@ng-click=\"$mdAutocompleteCtrl.select($index)\"][1]")).click();
		} catch (NoSuchElementException e) {
		}
		Thread.sleep(500);
		VehicleYearDropDown.click();
		Thread.sleep(500);
		Year2021.click();
		Thread.sleep(500);
		VehicleColorDropDown.click();
		Thread.sleep(500);
		VehicleColorBrown.click();
		Thread.sleep(500);
		VehicleTypeDropDown.click();
		Thread.sleep(500);
		VehicleTypeCar.click();
		Thread.sleep(500);
		ReqTransponder.click();
		Wait.waitForElement(driver, 20, By.id("ddlNewTag"));
		AssignmentMethodDropDown.click();
		Thread.sleep(500);
		Warehouse.click();
		Thread.sleep(500);
		TransModelDropDown.click();
		Thread.sleep(500);
		ExteriorQPassFree.click();
		Thread.sleep(500);
		SaveButton.click();
		Thread.sleep(3000);

	}
	public void AddVehicleWithTransponderIntEZPassHardCase(String plateNumber, String vehicleModel) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("btnaddvehicle"));
		AddVehicleButton.click();
		Wait.waitForElement(driver, 20, By.id("txtPlateNumber"));
		PlateNmber.sendKeys(plateNumber);
		Thread.sleep(1000);
//		CountriesDropDown.click();
//		Wait.waitForElement(driver, 20, By.id("ddlPlateCountry_1"));
//		Thread.sleep(2000);
//		UnitedState.click();
//		Thread.sleep(500);
//		StatesDropDown.click();
//		Thread.sleep(1000);
//		NorthCarolina.click();
//		Thread.sleep(500);
		VehicleMakeDropDown.click();
		Thread.sleep(500);
		Acura.click();
		Thread.sleep(500);
		VehicleModel.sendKeys(vehicleModel);
		try {
			driver.findElement(By.xpath("//li[@ng-click=\"$mdAutocompleteCtrl.select($index)\"][1]")).click();
		} catch (NoSuchElementException e) {
		}
		Thread.sleep(500);
		VehicleYearDropDown.click();
		Thread.sleep(500);
		Year2021.click();
		Thread.sleep(500);
		VehicleColorDropDown.click();
		Thread.sleep(500);
		VehicleColorBrown.click();
		Thread.sleep(500);
		VehicleTypeDropDown.click();
		Thread.sleep(500);
		VehicleTypeCar.click();
		Thread.sleep(500);
		ReqTransponder.click();
		Wait.waitForElement(driver, 20, By.id("ddlNewTag"));
		AssignmentMethodDropDown.click();
		Thread.sleep(500);
		Warehouse.click();
		Thread.sleep(500);
		TransModelDropDown.click();
		Thread.sleep(500);
		IntEZPassHardCase.click();
		Thread.sleep(500);
		SaveButton.click();
		Thread.sleep(3000);

	}
	public void AddVehicleWithTransponderIntEZPassHardCaseHOV(String plateNumber, String vehicleModel) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("btnaddvehicle"));
		AddVehicleButton.click();
		Wait.waitForElement(driver, 20, By.id("txtPlateNumber"));
		PlateNmber.sendKeys(plateNumber);
		Thread.sleep(1000);
//		CountriesDropDown.click();
//		Wait.waitForElement(driver, 20, By.id("ddlPlateCountry_1"));
//		Thread.sleep(2000);
//		UnitedState.click();
//		Thread.sleep(500);
//		StatesDropDown.click();
//		Thread.sleep(1000);
//		NorthCarolina.click();
//		Thread.sleep(500);
		VehicleMakeDropDown.click();
		Thread.sleep(500);
		Acura.click();
		Thread.sleep(500);
		VehicleModel.sendKeys(vehicleModel);
		try {
			driver.findElement(By.xpath("//li[@ng-click=\"$mdAutocompleteCtrl.select($index)\"][1]")).click();
		} catch (NoSuchElementException e) {
		}
		Thread.sleep(500);
		VehicleYearDropDown.click();
		Thread.sleep(500);
		Year2021.click();
		Thread.sleep(500);
		VehicleColorDropDown.click();
		Thread.sleep(500);
		VehicleColorBrown.click();
		Thread.sleep(500);
		VehicleTypeDropDown.click();
		Thread.sleep(500);
		VehicleTypeCar.click();
		Thread.sleep(500);
		ReqTransponder.click();
		Wait.waitForElement(driver, 20, By.id("ddlNewTag"));
		AssignmentMethodDropDown.click();
		Thread.sleep(500);
		Warehouse.click();
		Thread.sleep(500);
		TransModelDropDown.click();
		Thread.sleep(500);
		IntEZPassHardCaseHOV.click();
		Thread.sleep(500);
		SaveButton.click();
		Thread.sleep(3000);

	}
	public void AddVehicleWithTransponderInteriorFree(String plateNumber, String vehicleModel) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("btnaddvehicle"));
		AddVehicleButton.click();
		Wait.waitForElement(driver, 20, By.id("txtPlateNumber"));
		PlateNmber.sendKeys(plateNumber);
		Thread.sleep(1000);
//		CountriesDropDown.click();
//		Wait.waitForElement(driver, 20, By.id("ddlPlateCountry_1"));
//		Thread.sleep(2000);
//		UnitedState.click();
//		Thread.sleep(500);
//		StatesDropDown.click();
//		Thread.sleep(1000);
//		NorthCarolina.click();
//		Thread.sleep(500);
		VehicleMakeDropDown.click();
		Thread.sleep(500);
		Acura.click();
		Thread.sleep(500);
		VehicleModel.sendKeys(vehicleModel);
		try {
			driver.findElement(By.xpath("//li[@ng-click=\"$mdAutocompleteCtrl.select($index)\"][1]")).click();
		} catch (NoSuchElementException e) {
		}
		Thread.sleep(500);
		VehicleYearDropDown.click();
		Thread.sleep(500);
		Year2021.click();
		Thread.sleep(500);
		VehicleColorDropDown.click();
		Thread.sleep(500);
		VehicleColorBrown.click();
		Thread.sleep(500);
		VehicleTypeDropDown.click();
		Thread.sleep(500);
		VehicleTypeCar.click();
		Thread.sleep(500);
		ReqTransponder.click();
		Wait.waitForElement(driver, 20, By.id("ddlNewTag"));
		AssignmentMethodDropDown.click();
		Thread.sleep(500);
		Warehouse.click();
		Thread.sleep(500);
		TransModelDropDown.click();
		Thread.sleep(500);
		IntQPassFree.click();
		Thread.sleep(500);
		SaveButton.click();
		Thread.sleep(3000);

	}
	
	public void AddTransponderExteriorQPassFreeOnly() throws InterruptedException {
		Thread.sleep(5000);
		Wait.waitForElement(driver, 20, By.id("btnaddtransponder"));
		Wait.waitForElementToBeClicable(driver, 30, By.id("btnaddtransponder"));
		AddTransOnly.click();
		Wait.waitForElement(driver, 20, By.id("ddlNewTag"));
		Thread.sleep(2000);
		AssignmentMethodDropDown.click();
		Thread.sleep(500);
		Warehouse.click();
		Thread.sleep(500);
		TransModelDropDown.click();
		Thread.sleep(500);
		ExteriorQPassFree.click();
		Thread.sleep(500);
		SaveButton.click();
		Thread.sleep(1000);

	}
	
	public void AddTransponderExteriorEZPassHardCaseeOnly() throws InterruptedException {
		Thread.sleep(5000);
		Wait.waitForElement(driver, 20, By.id("btnaddtransponder"));
		Wait.waitForElementToBeClicable(driver, 30, By.id("btnaddtransponder"));
		AddTransOnly.click();
		Wait.waitForElement(driver, 20, By.id("ddlNewTag"));
		Thread.sleep(2000);
		AssignmentMethodDropDown.click();
		Thread.sleep(500);
		Warehouse.click();
		Thread.sleep(500);
		TransModelDropDown.click();
		Thread.sleep(500);
		ExteriorEZPassHardCase.click();
		Thread.sleep(500);
		SaveButton.click();
		Thread.sleep(1000);

	}
	public void AddTransponderIntEZPassHardCaseHOVOnly() throws InterruptedException {
		Thread.sleep(5000);
		Wait.waitForElement(driver, 20, By.id("btnaddtransponder"));
		Wait.waitForElementToBeClicable(driver, 30, By.id("btnaddtransponder"));
		AddTransOnly.click();
		Wait.waitForElement(driver, 20, By.id("ddlNewTag"));
		Thread.sleep(2000);
		AssignmentMethodDropDown.click();
		Thread.sleep(500);
		Warehouse.click();
		Thread.sleep(500);
		TransModelDropDown.click();
		Thread.sleep(500);
		IntEZPassHardCaseHOV.click();
		Thread.sleep(500);
		SaveButton.click();
		Thread.sleep(1000);

	}
	public void AddTransponderIntEZPassHardCaseOnly() throws InterruptedException {
		Thread.sleep(5000);
		Wait.waitForElement(driver, 20, By.id("btnaddtransponder"));
		Wait.waitForElementToBeClicable(driver, 30, By.id("btnaddtransponder"));
		AddTransOnly.click();
		Wait.waitForElement(driver, 20, By.id("ddlNewTag"));
		Thread.sleep(2000);
		AssignmentMethodDropDown.click();
		Thread.sleep(500);
		Warehouse.click();
		Thread.sleep(500);
		TransModelDropDown.click();
		Thread.sleep(500);
		IntEZPassHardCase.click();
		Thread.sleep(500);
		SaveButton.click();
		Thread.sleep(1000);

	}
	public void AddTransponderInteriorFreeOnly() throws InterruptedException {
		Thread.sleep(5000);
		Wait.waitForElement(driver, 20, By.id("btnaddtransponder"));
		Wait.waitForElementToBeClicable(driver, 30, By.id("btnaddtransponder"));
		AddTransOnly.click();
		Wait.waitForElement(driver, 20, By.id("ddlNewTag"));
		Thread.sleep(2000);
		AssignmentMethodDropDown.click();
		Thread.sleep(500);
		Warehouse.click();
		Thread.sleep(500);
		TransModelDropDown.click();
		Thread.sleep(500);
		IntQPassFree.click();
		Thread.sleep(500);
		SaveButton.click();
		Thread.sleep(1000);

	}

	public void Add10VehicleOnly() throws InterruptedException {

		for (int i = 1; i < 10; i++) {
			Random Rnd = new Random();
			int RndNm1 = Rnd.nextInt(9);
			int RndNm2 = Rnd.nextInt(99);
			//int RndNm3 = Rnd.nextInt(9999);
			Wait.waitForElementToBeClicable(driver, 20, By.id("btnaddvehicle"));
			AddVehicleButton.click();
			Wait.waitForElement(driver, 20, By.id("txtPlateNumber"));
			PlateNmber.sendKeys("NC" + i + RndNm1 + RndNm2);
			Thread.sleep(1000);
			CountriesDropDown.click();
			Wait.waitForElement(driver, 20, By.id("ddlPlateCountry_1"));
			Thread.sleep(2000);
			UnitedState.click();
			Thread.sleep(500);
			StatesDropDown.click();
			Thread.sleep(1000);
			NorthCarolina.click();
			Thread.sleep(500);
			VehicleMakeDropDown.click();
			Thread.sleep(500);
			Acura.click();
			Thread.sleep(500);
			VehicleModel.sendKeys("NCX");
			try {
				driver.findElement(By.xpath("//li[@ng-click=\"$mdAutocompleteCtrl.select($index)\"][1]")).click();
			} catch (NoSuchElementException e) {
			}
			Thread.sleep(500);
			VehicleYearDropDown.click();
			Thread.sleep(500);
			Year2021.click();
			Thread.sleep(500);
			VehicleColorDropDown.click();
			Thread.sleep(500);
			VehicleColorBrown.click();
			Thread.sleep(500);
			VehicleTypeDropDown.click();
			Thread.sleep(500);
			VehicleTypeCar.click();
			Thread.sleep(500);
//			ReqTransponder.click();
//			Wait.waitForElement(driver, 20, By.id("ddlNewTag"));
//			AssignmentMethodDropDown.click();
//			Thread.sleep(500);
//			Warehouse.click();
//			Thread.sleep(500);
//			TransModelDropDown.click();
//			Thread.sleep(500);
//			IntQPassFree.click();
//			Thread.sleep(500);
			SaveButton.click();
			Thread.sleep(3000);
		}
	}

	public void Add10Transponder() throws InterruptedException {
		for (int i = 1; i < 10; i++) {
			Thread.sleep(5000);
			Wait.waitForElementToBeClicable(driver, 20, By.id("btnaddtransponder"));
			AddTransOnly.click();
			Wait.waitForElement(driver, 20, By.id("ddlNewTag"));
			Thread.sleep(2000);
			AssignmentMethodDropDown.click();
			Thread.sleep(500);
			Warehouse.click();
			Thread.sleep(500);
			TransModelDropDown.click();
			Thread.sleep(500);
			IntQPassFree.click();
			Thread.sleep(500);
			SaveButton.click();
			Thread.sleep(1000);
		}
	}

	public void Add_Transit_Transponder() throws InterruptedException {
		Thread.sleep(5000);
		Wait.waitForElement(driver, 20, By.id("btnaddtransponder"));
		Wait.waitForElementToBeClicable(driver, 30, By.id("btnaddtransponder"));
		Thread.sleep(2000);
		
		
		Actions action = new Actions(driver);
		
		try{AddTransOnly.click();}
		catch(Exception o ) {
			action.click(AddTransOnly).perform();}
		
		
		Wait.waitForElement(driver, 20, By.id("ddlNewTag"));
		Thread.sleep(2000);
		AssignmentMethodDropDown.click();
		Thread.sleep(500);
		Warehouse.click();
		Thread.sleep(500);
		TransModelDropDown.click();
		Thread.sleep(500);
		TransitSticker.click();
		Thread.sleep(500);
		SaveButton.click();
		Thread.sleep(1000);
	}
}
