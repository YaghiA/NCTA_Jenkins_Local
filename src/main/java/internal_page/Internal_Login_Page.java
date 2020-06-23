package internal_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Wait;

public class Internal_Login_Page {
WebDriver driver;
	
	public Internal_Login_Page(WebDriver driver) {
	this.driver = driver;
	}
@FindBy (how = How.ID, using ="username") WebElement userName;
@FindBy (how = How.ID, using ="password") WebElement password;
@FindBy (how = How.ID, using ="btnSubmit") WebElement submit;


	public void InputUserNameAndPassword(String UserName , String Password) {
		Wait.waitForElement(driver, 20, By.id("username"));
		userName.sendKeys(UserName);
		password.sendKeys(Password);
		submit.click();
	}
}
