package stepdefinations;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Page_login extends page_Home{
  
	public Page_login() {
		// TODO Auto-generated constructor stub
	}
	public Page_login(RemoteWebDriver driver) {
		driver=getdriver();
	}
	
	@Given("Amazon website")
	public void Amazon_website() {
		invokeApp("https://www.amazon.in/");
		
	}
	
	@And("Verify title after opening the website")
	public void verify_title_after_opening_the_website() {
		String expectedtitle= "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String title=getitle();
		assertEquals(expectedtitle, title);
		System.out.println("Title verified and proceeding");
	}

	@Given("open the cart page")
	public void open_the_cart_page() {
        openCart(By.xpath("//a//*[contains(text(),'Cart')]"));
	}
	
	@Given("open sigin")
	public void open_sigin() {
	    login(By.xpath("//a//*[text()='Account & Lists' ]//preceding-sibling::*//span[contains(text(),'sign')]"));
  
	}
}
