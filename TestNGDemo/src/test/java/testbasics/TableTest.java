package testbasics;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class TableTest {
	WebDriver driver;
	@BeforeMethod
	public  void initialiseBrowser() 
	{
System.setProperty("webdriver.chrome.driver","D:\\Drivers\\web\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		
		
	}
		@Test
		public  void verifytabledisplay() 
		{
			driver.get("https://selenium.obsqurazone.com/table-pagination.php");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebElement table=driver.findElement(By.xpath("//div[@class='card-body']"));
		
		     //  assertTrue(table.isDisplayed());
			assertTrue(false);
		}
		
		@Test(dependsOnMethods ="verifytabledisplay")//depends on is used to skip the method when first method have exception
		public  void verify() 
		{
			driver.get("https://www.amazon.in");;
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		      System.out.println(driver.getTitle());
		}
}