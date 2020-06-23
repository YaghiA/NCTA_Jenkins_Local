package external_page;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Wait;

public class Ex_Security_Page {
	WebDriver driver;
	DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	Date date = new Date();
	String dateFormatted = dateFormat.format(date);
	Random Rnd = new Random();
	int RndNm1 = Rnd.nextInt(99);
	int RndNm2 = Rnd.nextInt(99);
	
	
	public Ex_Security_Page(WebDriver driver) {
		this.driver = driver;
		}
	
	
	
	@FindBy (how = How.ID, using ="userInput") WebElement UserName;
	@FindBy (how = How.ID, using ="createPassword") WebElement Password;
	@FindBy (how = How.NAME, using ="reTypePassword") WebElement RetypePass;
	@FindBy (how = How.ID, using ="createPin") WebElement CreatePin;
	@FindBy (how = How.ID, using ="retypePin") WebElement ReTypePin;
	@FindBy (how = How.XPATH, using ="//md-select[@message-id='reqSequrityQuestion1']") WebElement SecQuest1DropDown;
	@FindBy (how = How.ID, using ="secquest1_1") WebElement SecQuest1;
	@FindBy (how = How.XPATH, using ="//input[@name='answer1']") WebElement AnsQuest1;
	@FindBy (how = How.XPATH, using ="//md-select[@message-id='reqSequrityQuestion2']") WebElement SecQuest2DropDown;
	@FindBy (how = How.ID, using ="secquest2_2") WebElement SecQuest2;
	@FindBy (how = How.XPATH, using ="//input[@name='answer2']") WebElement AnsQuest2;
	@FindBy (how = How.XPATH, using ="//md-select[@message-id='reqSequrityQuestion3']") WebElement SecQuest3DropDown;
	@FindBy (how = How.ID, using ="secquest3_3") WebElement SecQuest3;
	@FindBy (how = How.XPATH, using ="//input[@name='answer3']") WebElement AnsQuest3;
	

	
	public void FillSecurityInfo(String usenName , String password) throws InterruptedException {
		Wait.waitForElement(driver, 20, By.id("userInput"));
		UserName.sendKeys(usenName);
		Password.sendKeys(password);
		RetypePass.sendKeys(password);
		CreatePin.sendKeys("1234");
		ReTypePin.sendKeys("1234");
		SecQuest1DropDown.click();
		SecQuest1.click();
		Thread.sleep(1000);
		AnsQuest1.sendKeys("Test1");
		SecQuest2DropDown.click();
		SecQuest2.click();
		Thread.sleep(1000);
		AnsQuest2.sendKeys("Test2");
		SecQuest3DropDown.click();
		SecQuest3.click();
		Thread.sleep(1000);
		AnsQuest3.sendKeys("Test3");
		Thread.sleep(1000);
		
		
	}
	
	
}
