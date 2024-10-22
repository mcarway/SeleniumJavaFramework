package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;
import pages.GoogleSearchPageObjects;

public class TestNG_Demo {
	
	private static WebDriver driver=null;
	GoogleSearchPageObjects searchPageObj;
	
	@BeforeTest
	public void setUpTest(){
		WebDriverManager.chromedriver().driverVersion("2.36").setup();
		driver=new ChromeDriver();

		//WebDriverManager.firefoxdriver().setup();
		//driver=new FirefoxDriver();

	}
	
	@Test
	public void GoogleSearchTest1() {
		searchPageObj = new GoogleSearchPageObjects(driver);
		
		driver.get("https://nyiso.com");
		
		searchPageObj.setTextInSearchBox("How to Program");
		searchPageObj.ClickSearchButton();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void GoogleSearchTest2() {
		searchPageObj = new GoogleSearchPageObjects(driver);
		
		driver.get("https://google.com");
		
		searchPageObj.setTextInSearchBox("How to Program");
		searchPageObj.ClickSearchButton();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	public void GoogleSearchTest3() {
		searchPageObj = new GoogleSearchPageObjects(driver);
		
		driver.get("https://google.com");
		
		searchPageObj.setTextInSearchBox("How to Program");
		searchPageObj.ClickSearchButton();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@AfterTest	
	public void tearDownTest() {
		driver.close();
		driver.quit();
		
		//System.out.println("Test completed successfully.");

	}

}
