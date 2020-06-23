package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	public static void waitForElement(WebDriver driver , int timeInSeconds , By Locator ) {
		WebDriverWait wait = new WebDriverWait(driver , timeInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}
	public static void waitForElementToBeClicable(WebDriver driver , int timeInSeconds , By Locator  ) {
		WebDriverWait wait = new WebDriverWait(driver , timeInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(Locator));
	}
}
