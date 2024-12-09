package library;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseFunctions {


	public WebElement getWebelemnet(RemoteWebDriver driver, By locator)
	{
		WebElement element=null;
		try {
			element=driver.findElement(locator);

		} catch (NoSuchElementException e) {
			System.out.println("element not found");
			e.printStackTrace();
		}
		return element;
	}
	public void click(RemoteWebDriver driver, By locator)
	{
		getWebelemnet(driver, locator).click();
	
	}


}
