package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemoWithTestNG2 {
	
	ExtentReports extent;
	ExtentHtmlReporter htmlReporter;
	WebDriver driver;

	@BeforeSuite
	public void setup() {
		// start reporters
		htmlReporter = new ExtentHtmlReporter("extentReports.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		WebDriverManager.chromedriver().driverVersion("2.36").setup();
		driver=new ChromeDriver();


	}

	@Test
	public void test1() throws IOException {
		ExtentTest test = extent.createTest("Test 1", "This is a test to validate google search functionality.");
		driver.get("https://google.com");
		test.pass("Navigated successfully.");
		
		
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
       // test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@Test
	public void test2() throws IOException {
        ExtentTest test = extent.createTest("Test 2", "This is a test to validate google search functionality.");
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@AfterSuite
	public void tearDown() {
        // calling flush writes everything to the log file
        extent.flush();
        driver.close();
        driver.quit();

	}

}
