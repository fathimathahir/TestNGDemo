package basicng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertClick {
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
	public void verifytext()
	{
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");

		softassert=new SoftAssert();
		WebElement click1=driver.findElement(By.xpath("//label[@class='form-check-label']"));
		String actualtext1=click1.getText();
		String expectedtext1="Click on this check box";
		softassert.assertEquals (actualtext1,expectedtext1);
		
		
		WebElement click2=driver.findElement(By.xpath("//label[@for='check-box-one']"));
		String actualtext2=click2.getText();
		String expectedtext2="Check Box One";
		softassert.assertEquals (actualtext2,expectedtext2);
		
		WebElement click3=driver.findElement(By.xpath("//label[@for='check-box-two']"));
		String actualtext3=click3.getText();
		String expectedtext3="Check Box Two";
		softassert.assertEquals (actualtext3,expectedtext3);
		
		
		WebElement click4=driver.findElement(By.xpath("//label[@for='check-box-three']"));
		String actualtext4=click4.getText();
		String expectedtext4="Check Box Three";
		softassert.assertEquals (actualtext4,expectedtext4);
		
		
		
		WebElement click5=driver.findElement(By.xpath("//label[@for='check-box-four']"));
		String actualtext5=click5.getText();
		String expectedtext5="Check Box Four";
		softassert.assertEquals (actualtext5,expectedtext5);
		
		softassert.assertAll();
	}	
		@Test
		public void verifyselectedornot()
		
		{
			driver.get("https://selenium.obsqurazone.com/check-box-demo.php");

			softassert=new SoftAssert();
			   WebElement singlecheck=driver.findElement(By.xpath("//input[contains(@class,'form-check-input')]"));
		       singlecheck.click();
		       softassert.assertTrue(singlecheck.isSelected());
		       
		       
			 WebElement check1=driver.findElement(By.xpath("//input[starts-with(@id,'check-box-one')]"));
			 check1.click();
			 softassert.assertTrue(check1.isSelected());
		       
		      WebElement check2=driver.findElement(By.xpath("//input[@id='check-box-two']"));
	          check2.click();
	          softassert.assertTrue(check2.isSelected());
		       
		     WebElement check3=driver.findElement(By.xpath("//input[@id='check-box-three']"));
			  check3.click();
			  softassert.assertTrue(check3.isSelected());
			  
			  WebElement check4=driver.findElement(By.xpath("//input[contains(@id,'check-box-four')]"));
			  check4.click();
			  softassert.assertTrue(check4.isSelected());
			  
			  softassert.assertAll();
}
}