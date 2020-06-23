package external_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.Wait;

public class External_Login_Page {
WebDriver driver;
	
	public External_Login_Page(WebDriver driver) {
	this.driver = driver;
	}
@FindBy (how = How.XPATH, using ="//span[contains(text(),'Sign Up')]") WebElement SignUp;
@FindBy (how = How.XPATH, using ="//span[contains(text(),'Sign Up')]/parent::button") WebElement SignUp2;


	public void signUpButton() throws InterruptedException {
		Thread.sleep(5000);
		
		 WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Sign Up')]")));
			Actions action = new Actions(driver);
		
		try{action.click(SignUp).perform();}
		catch(Exception w) {
			action.click(SignUp2).perform();
			
		}
		
//		Thread.sleep(10000);
//		try{Wait.waitForElement(driver, 20, By.xpath("//span[contains(text(),'Sign Up')]"));
//		
//		SignUp.click();
//		}
//		catch(Exception W) {Wait.waitForElement(driver, 20, By.xpath("//span[contains(text(),'Sign Up')]"));
//		Thread.sleep(20000);
//		SignUp2.click();
		}
	}

