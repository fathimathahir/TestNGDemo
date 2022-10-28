package basicng;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToWindowExapmle {
	
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
	public void verify()
	{
		driver.get("https://the-internet.herokuapp.com/windows");
	
		WebElement clickme=driver.findElement(By.xpath("//a[@href='/windows/new']"));
	     clickme.click();
	//     WebElement text=driver.findElement(By.xpath("//div[@class='example']//h3[text()='New Window']"));
   //       String output=text.getText();
     //     System.out.println(output);
	     
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
          
          WebElement text=driver.findElement(By.xpath("//div[@class='example']//h3[text()='New Window']"));
          String output=text.getText();
         System.out.println(output);
          
          
          
          
}
	@Test
	public void verifys()
	{
		driver.get("https://the-internet.herokuapp.com/windows");
		WebElement clickme=driver.findElement(By.xpath("//a[@href='/windows/new']"));
	     clickme.click();
	
	     String parentWindow=driver.getWindowHandle();
          System.out.println(parentWindow);
          
          Set <String> windows=driver.getWindowHandles();
          windows.size();
          System.out.println( windows.size());
          
          for(String S:windows)
  		{
  			if(parentWindow.equals(S))
  			{
  				System.out.println("no need to switch");
  				System.out.println(S+" "+parentWindow);
  			}
  			else
  			{
  				driver.switchTo().window(S);
  			}
  		}
  		WebElement text= driver.findElement(By.xpath("//h3[text()='New Window']"));
  		System.out.println(text.getText());
  		driver.switchTo().window(parentWindow);
            	  
				
			}
        	  
        	 
	
          
          
      
          
          
          
          
          
}
