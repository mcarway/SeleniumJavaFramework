package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {
	
	WebDriver driver=null;
	By textbox_search = By.name("q");
	By button_search = By.name("btnK");

	//This is a constructor that assigns the passed-in driver value to the local driver variable.
	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public void setTextInSearchBox(String text) {
		driver.findElement(textbox_search).sendKeys(text);
		//driver.findElement(textbox_search).sendKeys(Keys.ESCAPE);
		
	}

	public void ClickSearchButton() {
		driver.findElement(textbox_search).sendKeys(Keys.RETURN);
		//driver.findElement(button_search).click();

	}

}
