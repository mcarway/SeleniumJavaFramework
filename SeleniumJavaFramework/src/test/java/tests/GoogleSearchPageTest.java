package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GoogleSearchPage;
import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {
	
	private static WebDriver driver=null;
	
	public static void main(String[] args) {
		GoogleSearchTest();
	}

	public static void GoogleSearchTest() {
		WebDriverManager.chromedriver().driverVersion("2.36").setup();
		driver=new ChromeDriver();
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		
		driver.get("google.com");
		
		searchPageObj.setTextInSearchBox("How to Program");
		searchPageObj.ClickSearchButton();
		
		driver.close();
		driver.quit();
		
		

	}
}
