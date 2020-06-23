package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

public class Internal_Common {
	private static String screenshotName;
	static WebDriver driver;

	// Open Browser, Delete Cookies, Maximize Window , Wa
	public static WebDriver openBrowser(String key) throws IOException {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

//		ChromeOptions options = new ChromeOptions();
//		options.setExperimentalOption("useAutomationExtension", false);
//		options.setBinary("C:\\Users\\YaghiA\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");

		driver = new ChromeDriver();
		// driver.get(getGlobalValue(key));
		driver.get(getGlobalValue(key));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		return driver;
	}

	public static WebElement Next() {

		WebElement Next = driver.findElement(By.xpath("//span[contains(text(),'NEXT')]"));
		Wait.waitForElementToBeClicable(driver, 10, By.xpath("//span[contains(text(),'NEXT')]"));
		return Next;

	}

	public static void pageLoad(int pageLoadTimeout) {
		// driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		new WebDriverWait(driver, pageLoadTimeout).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));
	}

	public static WebElement Finish() {

		WebElement Finish = driver.findElement(By.xpath("//span[contains(text(),'FINISH')]"));
		Wait.waitForElementToBeClicable(driver, 10, By.xpath("//span[contains(text(),'FINISH')]"));
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

	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./src/test/java/resources/global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}

	
}
