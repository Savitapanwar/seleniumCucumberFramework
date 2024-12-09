package stepdefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import library.BaseFunctions;

public class page_Home {
	BaseFunctions base=new BaseFunctions();

	protected Properties prop;
	public static RemoteWebDriver driver;

	//load the property file
	public page_Home()
	{
		FileInputStream FI;
		try {
			prop=new Properties();
			FI = new FileInputStream(new File(System.getProperty("user.dir")+"/config.properties"));
			System.out.println(System.getProperty("user.dir")+"/config.properties");
			prop.load(FI);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}

   // invoke given URL
	public void invokeApp(String url) {

		try {
			if(prop.getProperty("browser").toString().equalsIgnoreCase("chrome")){
				System.out.println("initializing chrome driver");
				driver = new ChromeDriver();
			}
			else if (prop.getProperty("browser").toString().equalsIgnoreCase("firefox")){
				driver = new FirefoxDriver();}
			driver.manage().window().maximize();

			driver.get(prop.getProperty("url"));

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("The browser "+prop.getProperty("browser")+"could not be launched");
		}

	}

	//get title of the page
	public String getitle()
	{

		return driver.getTitle();

	}
	
	public void openCart(By locator)
	{
	 	base.click(driver, locator);
	}
	public void login(By locator)
	{
		base.click(driver, locator);
	}
	
	public RemoteWebDriver getdriver()
	{
		return driver;
	}




}



