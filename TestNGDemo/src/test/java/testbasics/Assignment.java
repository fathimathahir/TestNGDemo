package testbasics;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {
	WebDriver driver;
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
	WebElement firstbutton=driver.findElement(By.xpath("//button[@id='autoclosable-btn-success']"));
	String actualbackgroundcolour=firstbutton.getCssValue("background-color");
	System.out.println("Background color for first button:"+actualbackgroundcolour);
	String expected=("rgba40, 167, 1");
	Assert.assertEquals (actualbackgroundcolour,expected);
	System.out.println("hello");
}
@Test
public void verifytooltip()
{
	
	driver.get("https://selenium.obsqurazone.com/window-popup.php");


	 WebElement follow=driver.findElement(By.xpath("//a[@class='btn btn-primary windowSingle']"));

	 String expectedoutput="Follow @obsqurazone on Facebook";
	
		String actualoutput=follow.getAttribute("title");
		
		Assert.assertEquals(expectedoutput, actualoutput);
		
}
@Test
public void verifytext()
{
	driver.get("https://selenium.obsqurazone.com/window-popup.php");

	 WebElement followus=driver.findElement(By.xpath("//a[@class='btn btn-success']"));
	 String expectedtext="Follow All";
	 String actualtext=followus.getText();
	 Assert.assertEquals(expectedtext, actualtext);
	
	
	
}


}
	


