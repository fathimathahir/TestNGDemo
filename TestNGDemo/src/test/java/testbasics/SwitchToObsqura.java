package testbasics;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToObsqura {
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
	public void verifytext()
	{
		driver.get("https://selenium.obsqurazone.com/window-popup.php");
		WebElement likeus=driver.findElement(By.xpath("//a[contains(text(),'Like us On Facebook ')]"));
		likeus.click();
		//String expectedoutput="Like us On Facebook";
		
	//	String actualoutput=likeus.getText();
		
	//	Assert.assertEquals(expectedoutput, actualoutput);
		String parentWindow=driver.getWindowHandle();
        System.out.println(parentWindow);
        
        Set <String> windows=driver.getWindowHandles();
        windows.size();
        System.out.println( windows.size());
        
        Iterator <String> iterate=windows.iterator();
        
        while (iterate.hasNext()) {
      	  
      	  String childWindow=iterate.next();
      	  if (!parentWindow.equals(childWindow)) {
				
      		  driver.switchTo().window(childWindow);
			}
      	  
			
		}
        
        WebElement text=driver.findElement(By.xpath("//span[text()='See more of Obsqura Zone on Facebook']"));
       String expectedoutput="See more of Obsqura Zone on Facebook";
		
		String actualoutput=text.getText();
		
		Assert.assertEquals(expectedoutput, actualoutput);
       
       System.out.println("print text:"+actualoutput);
        
}
}