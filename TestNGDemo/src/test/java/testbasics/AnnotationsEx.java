package testbasics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationsEx {
	@BeforeSuite 
	public void beforesuite()
	{
		System.out.println("Inside suite");
	}
	
	@BeforeTest
	public void beforetest()
	{
		System.out.println("Inside test");
	}
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("Inside class");
	}
	@BeforeMethod
	public void method()
	{
		System.out.println("Inside beforemethod");
		
	}
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("Inside beforemethod");
		
	}
	@Test
	public void test1()
{
		System.out.println("Inside testcase1");
		}
	public void test2()
	{
			System.out.println("Inside testcase2");
			}
	public void test3()
	{
			System.out.println("Inside testcase3");
			
			}
	@AfterMethod
	public void aftermethod()
	{
		System.out.println("Inside aftermethod");
		
	}
	@AfterClass
	public void afterclass()
	{
		System.out.println("Inside afterclass");
		
	}
	@AfterTest
	public void aftertest()
	{
		System.out.println("Inside aftertest");
		
		
	}
	@AfterSuite
	public void aftersuitet()
	{
		System.out.println("Inside aftersuite");
		
		
	}
}
