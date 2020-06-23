package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class External_Common {
	static WebDriver driver;

	
		
	
	public static WebDriver openBrowser(String key) throws IOException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.setExperimentalOption("useAutomationExtension", false);
//		chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		driver = new ChromeDriver();

		driver.get(getGlobalValue(key));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		return driver;

	}
	public static WebElement Continue() {

		WebElement Continue = driver.findElement(By.xpath("//span[contains(text(),'Continue')]"));
		return Continue;

	}

	public static WebElement Finish() {

		WebElement Finish = driver.findElement(By.xpath("//span[contains(text(),'FINISH')]"));
		return Finish;
	}
	
	public static void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		   js.executeScript("window.scrollBy(0,10000)");
		
		
	}

	public static void takeScrShot(WebDriver driver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		FileUtils.copyFile(SrcFile, DestFile);

	}
	public static  String getGlobalValue(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/test/java/resources/global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}	


}
