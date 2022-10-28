package basicng;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertSimpleForm {
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
	public void verifytextfield()
	{
		 driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		softassert=new SoftAssert();
		 WebElement entermessage=driver.findElement(By.id("single-input-field"));
		 softassert.assertTrue(entermessage.isDisplayed());
		 
		 WebElement valuea=driver.findElement(By.xpath("//input[@id='value-a']"));
		 softassert.assertTrue(valuea.isDisplayed());
		 
		 WebElement valueb=driver.findElement(By.xpath("//input[@id='value-b']"));
		 softassert.assertTrue(valueb.isDisplayed());
		 
		
		 
		
		
		//JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,6000)");
		
		
		
		  WebElement value=driver.findElement(By.xpath("//label[text()='Enter value A']"));
		String expectedtext1="Enter value A";
		String actualtext1=value.getText();
		System.out.println(actualtext1);
	softassert.	assertEquals(expectedtext1,actualtext1);
	
	 softassert.assertAll();
}
}