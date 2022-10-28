package testbasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertExample {
	WebDriver driver;
	SoftAssert softassert;
	
	@BeforeMethod
	public  void initialiseBrowser() 
	{
      WebDriverManager.chromedriver().setup();
		
		 driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void verifybackgroundcolor()
	{
		driver.get("https://selenium.obsqurazone.com/bootstrap-alert.php");
		
		softassert=new SoftAssert();
		WebElement firstbutton=driver.findElement(By.xpath("//button[@id='autoclosable-btn-success']"));
		String actualbackgroundcolour=firstbutton.getCssValue("background-color");
		System.out.println("Background color for first button:"+actualbackgroundcolour);
		String expected="rgba(40, 167, 69, 1)";
		softassert.assertEquals (actualbackgroundcolour,expected);
		
		WebElement secondbutton=driver.findElement(By.xpath("//button[@id='autoclosable-btn-warning']"));
		String actualbackgroundcolour2=secondbutton.getCssValue("background-color");
		System.out.println("Background color for second button:"+actualbackgroundcolour2);
		String expectedcolor="rgba(255, 193, 7, 1)";
		softassert.assertEquals (actualbackgroundcolour2,expectedcolor);
		
		softassert.assertAll();
}
	@Test
	public void verifybackground()
	{
		driver.get("https://selenium.obsqurazone.com/bootstrap-alert.php");
		
		softassert=new SoftAssert();
		WebElement firstbutton=driver.findElement(By.xpath("//button[@id='autoclosable-btn-success']"));
		String actualbackgroundcolour=firstbutton.getCssValue("background-color");
		System.out.println("Background color for first button:"+actualbackgroundcolour);
		String expected="rgba(40, 167, 69, 1)";
		softassert.assertEquals (actualbackgroundcolour,expected);
		
		WebElement secondbutton=driver.findElement(By.xpath("//button[@id='autoclosable-btn-warning']"));
		String actualbackgroundcolour2=secondbutton.getCssValue("background-color");
		System.out.println("Background color for second button:"+actualbackgroundcolour2);
		String expectedcolor="rgba(25, 193, 7, 1)";
		softassert.assertEquals (actualbackgroundcolour2,expectedcolor);
		System.out.println("hii");
		softassert.assertAll();
	
}
}