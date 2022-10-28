package basicng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class BasicTestng {
	WebDriver driver;
	@BeforeMethod
	public  void initialiseBrowser() 
	{
System.setProperty("webdriver.chrome.driver","D:\\Drivers\\web\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test(invocationCount = 3)//execute for 3 times
	public  void verifyCurrentUrl() 
	{
		String expectedurl="https://www.google.com/";
		String actualurl=driver.getCurrentUrl();
		assertEquals(expectedurl, actualurl);
		
	}
	@Test(enabled = false,priority = 2)
	public  void verifyTitle() 
	{
		String expectedtitle="Google";
		String actualtitle=driver.getTitle();
		assertEquals(expectedtitle, actualtitle);
	}
	@Test(priority = 1)
	public void verifylogo()
	{
		WebElement logo=driver.findElement(By.xpath("//img[@class='lnXdpd']"));
	   assertTrue(logo.isDisplayed());
	}
	
	@AfterMethod
	public void quitbrowser()
	{
	driver.quit();
	}
	

}
