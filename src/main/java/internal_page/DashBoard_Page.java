package internal_page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import util.Wait;

public class DashBoard_Page {
WebDriver driver;
	
	public DashBoard_Page(WebDriver driver ) {
		this.driver = driver;
	}
	@FindBy (how = How.XPATH, using ="//i[@class='navToggle sideNavSlideout']") WebElement SideNav;
	@FindBy (how = How.XPATH, using ="//p[contains(text(),'CREATE ACCOUNT')]") WebElement CeateAccount;
	//@FindBy (how = How.XPATH, using ="//p[contains(text(),'Global Settings')]") WebElement GlobalSittings;

	
	public void NavToCreateAccount() throws InterruptedException {
		Wait.waitForElement(driver, 20, By.xpath("//i[@class='navToggle sideNavSlideout']"));
		SideNav.click();
		Wait.waitForElement(driver, 20, By.xpath("//p[contains(text(),'CREATE ACCOUNT')]"));
		CeateAccount.click();
	}
	
	
}
