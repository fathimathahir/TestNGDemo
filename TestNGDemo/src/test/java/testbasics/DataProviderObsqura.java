package testbasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basicng.DataProviderClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderObsqura {
WebDriver driver;
	
	
	@BeforeMethod
	public  void initialiseBrowser() 
	{
      WebDriverManager.chromedriver().setup();
		
		 driver = new ChromeDriver();
		
		 driver.get("https://selenium.obsqurazone.com/form-submit.php");
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	@Test(dataProvider ="inputdetails",dataProviderClass = DataProviderObs.class)
	public void input(String data1,String data2,String data3,String data4,String data5,String data6)
	{
		
		
		
		WebElement firstname=driver.findElement(By.xpath("//div[@class='col-md-4 mb-3']//input[@id='validationCustom01']"));
		firstname.sendKeys(data1);
		
		WebElement secondname=driver.findElement(By.xpath("//div[@class='col-md-4 mb-3']//input[@id='validationCustom02']"));
		secondname.sendKeys(data2);
		
		WebElement username=driver.findElement(By.xpath("//div[@class='input-group']//input[@id='validationCustomUsername']"));
	username.sendKeys(data3);
		
	WebElement cityname=driver.findElement(By.xpath("//div[@class='col-md-6 mb-3']//input[@id='validationCustom03']"));
cityname.sendKeys(data4);
	
WebElement statename=driver.findElement(By.xpath("//div[@class='col-md-3 mb-3']//input[@id='validationCustom04']"));
statename.sendKeys(data5);

WebElement zip=driver.findElement(By.xpath("//div[@class='col-md-3 mb-3']//input[@id='validationCustom05']"));
zip.sendKeys(data6);
		
	}
}
