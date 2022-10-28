package basicng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvidersExample {
WebDriver driver;
	
	
	@BeforeMethod
	public  void initialiseBrowser() 
	{
      WebDriverManager.chromedriver().setup();
		
		 driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	@Test(dataProvider = "products",dataProviderClass = DataProviderClass.class)
	public void testcase1(String data)
	{
		driver.get("https://www.amazon.in");
		WebElement searchField=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchField.sendKeys(data);
		WebElement searchButton=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchButton.click();
		
		
	}
		
	
		@Test(dataProvider = "twodimensional",dataProviderClass = DataProviderClass.class)
		public void testcase2(String data1,String data2)
		{
			driver.get("https://www.amazon.in");
			WebElement searchField=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
			searchField.sendKeys(data1+"/"+data2);
			System.out.println(data1+""+data2);
			WebElement searchButton=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
			searchButton.click();
		
		
		}	
		
	@Test(dataProvider = "2d",dataProviderClass = DataProviderClass.class)
	public void facebook (String data1,String data2)
	{
		
			driver.get("https://www.facebook.com/");
		WebElement username=driver.findElement(By.xpath("//input[@id='email']"));
		username.sendKeys(data1);
		
		WebElement password=driver.findElement(By.xpath("//input[@id='pass']"));
		password.sendKeys(data2);
}
		
		
		
		
	}
		
		
		
		
		
		
		
		


