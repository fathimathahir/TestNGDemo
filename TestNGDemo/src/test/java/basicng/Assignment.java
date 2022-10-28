package basicng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {
	WebDriver driver;
	@BeforeMethod
	public void initialisebrowser()
	{
		WebDriverManager.chromedriver().setup();
		
		 driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		}
	
	@Test
	public void verifytext()
	{
		
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		wait.until(ExpectedConditions.elementToBeClickable(By.id("single-input-field")));
		
        WebElement entermessage=driver.findElement(By.id("single-input-field"));
		entermessage.sendKeys("HELLO WORLD");
		entermessage.click();
	
		WebElement submit=driver.findElement(By.xpath("//button[text()='Show Message']"));
		submit.click();
		
		WebElement output=driver.findElement(By.xpath("//div[@id='message-one']"));
		String expectedtext="Your Message : HELLO WORLD";
		String actualtext=output.getText();
		assertEquals(expectedtext,actualtext);
		
	}
	@Test
	public void verifycheckbox()
	{
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		
		
		WebElement singlecheck=driver.findElement(By.xpath("//input[contains(@class,'form-check-input')]"));
	       singlecheck.click();
	       assertTrue(singlecheck.isSelected());
		
	}
	
	@Test
	public void verifythestate()
	{
		driver.get("https://selenium.obsqurazone.com/jquery-select.php");
		String state="Vermont";
		WebElement states=driver.findElement(By.xpath("//span[@class='select2-selection__rendered']"));
		states.click();
		WebElement statefield=driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		statefield.sendKeys(state);
	}
	
	
	@Test
	public void verifytextofalertpopup()
	{
		driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100)); 
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-success']")));
		
		WebElement clickme=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
	     clickme.click();
	    String actualalert= driver.switchTo().alert().getText();
	     System.out.println("alert message:"+actualalert);
        driver.switchTo().alert().accept();
        String expectedalert="I am a Javascript alert box!";
        assertEquals(expectedalert,actualalert);
	}
	
	@Test
	public void verifytextmessage()
	{
		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
		Actions actions=new Actions(driver);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control']")));
			
		WebElement subject=driver.findElement(By.xpath("//input[@class='form-control']"));
		actions.sendKeys(subject, "selenium").build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='description']")));
		WebElement description=driver.findElement(By.xpath("//textarea[@id='description']"));
		actions.sendKeys(description, "selenium is an open source tool ").build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='btn btn-primary']")));
		WebElement submit=driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		actions.click(submit).build().perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Form has been submitted successfully!']")));
		WebElement output=driver.findElement(By.xpath("//div[text()='Form has been submitted successfully!']"));
		String expectedtext="Form has been submitted successfully!";
		String actualtext=output.getText();
		System.out.println(actualtext);
		assertEquals(expectedtext,actualtext);
		
	}
	
	
	
	

}
