package tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ScreenshotGrabber;

import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class KatalonTestDemo {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private ScreenshotGrabber grabScreen;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		WebDriverManager.chromedriver().driverVersion("2.36").setup();
		driver = new ChromeDriver();
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void testKatalonTestDemo() throws Exception {
		//This test was generated with Katalon Recorder.
		driver.get("https://www.netflix.com/");
		grabScreen.takeScreenshot(driver, "netflix_home");

		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("id_userLoginId")).clear();
		driver.findElement(By.id("id_userLoginId")).sendKeys("mcarway@hotmail.com");
		driver.findElement(By.id("id_password")).clear();
		driver.findElement(By.id("id_password")).sendKeys("bailey");
		grabScreen.takeScreenshot(driver, "netflix_signin");

		driver.findElement(By.id("id_userLoginId")).click();
		driver.findElement(By.id("id_userLoginId")).clear();
		driver.findElement(By.id("id_userLoginId")).sendKeys("someone@gmail.com");
		driver.findElement(By.xpath("//div[@id='appMountPoint']/div/div[3]/div/div/div/form/div[2]/div/div")).click(); 
		driver.findElement(By.id("id_password")).clear();
		driver.findElement(By.id("id_password")).sendKeys("djdjdjdjdj");
		grabScreen.takeScreenshot(driver, "netflix_signin2");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Example of an assertion. If the first two supplied values don't match it returns the third -- error message -- value.
		//String curURL = driver.getCurrentUrl();		
		//Assert.assertEquals(curURL, "www.welcometoflix", "Netflix login failed.");
		

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testKatalonTestDemo2() throws Exception {
		//Make it fail by finding a misspelled link.
		driver.get("https://google.com");
		//driver.findElement(By.linkText("Sign In"));
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		/*
		 * String verificationErrorString = verificationErrors.toString(); if
		 * (!"".equals(verificationErrorString)) { fail(verificationErrorString); }
		 */
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
