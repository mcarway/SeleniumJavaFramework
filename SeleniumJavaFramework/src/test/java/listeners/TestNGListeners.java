package listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGListeners implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println("*****Test start: "+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*****Test success: "+result.getName());
	}

	public void onTestFailure(ITestResult result) {
		WebDriverManager.chromedriver().driverVersion("2.36").setup();
		WebDriver driver=new ChromeDriver();
		String curDirectory=System.getProperty("user.dir");


		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//The below method will save the screen shot in destination directory with name "screenshot.png"
			FileHandler.copy(scrFile, new File(curDirectory+"/screenshots/"+ result.getName() +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		//System.out.println("*****Test failure: "+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*****Test skipped: "+result.getName());
	}

	public void onTestFinish(ITestResult result) {
		System.out.println("*****Test finish: "+result.getName());
	}

}
