package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsBasicDemo {
	
	private static WebDriver driver=null;


	public static void main(String[] args) {
	
		// start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
        
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Google Search Test 1", "This is a test to validate google search functionality.");

        WebDriverManager.chromedriver().driverVersion("2.36").setup();
		driver=new ChromeDriver();
		
        // log(Status, details)
        test1.log(Status.INFO, "Starting test case");

		driver.get("https://google.com");
		test1.pass("Navigated to google successfully.");
		
		driver.findElement(By.name("q")).sendKeys("how to program");
		test1.pass("Entered search terms successfully.");
		
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		test1.pass("Ran search successfully.");
		
		driver.close();
		driver.quit();
		
		test1.pass("Closed browser successfully.");
		test1.info("Test completed.");

 //----------------------------------------
        
        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test2 = extent.createTest("Google Search Test 2", "This is a test to validate google search functionality.");

        WebDriverManager.chromedriver().driverVersion("2.36").setup();
		driver=new ChromeDriver();
		
        // log(Status, details)
        test2.log(Status.INFO, "Starting test case");

		driver.get("https://google.com");
		test2.pass("Navigated to google successfully.");
		
		driver.findElement(By.name("q")).sendKeys("how to program");
		test2.pass("Entered search terms successfully.");
		
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		test2.fail("Ran search successfully.");
		
		driver.close();
		driver.quit();
		
		test2.pass("Closed browser successfully.");
		test2.info("Test completed.");
		
        // calling flush writes everything to the log file
        extent.flush();

        
    }
}
