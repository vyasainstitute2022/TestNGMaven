package com.vyasasti.testng.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.microsoft.edge.seleniumtools.EdgeDriver;

public class CrossBrowserTesting {
	
	public WebDriver driver;
	@Parameters("browser")
	@BeforeClass 
	public void browserLaunch(String browser) 
	{
		
		if(browser.equalsIgnoreCase("firefox")){ 
		  System.setProperty("webdriver.gecko.driver", "D:\\AutomationAug2022\\AutomationWithTestNG\\drivers\\geckodriver.exe"); 
		  driver = new FirefoxDriver();
		  System.out.println("firefox opened succesfully"); 
	    }else if (browser.equalsIgnoreCase("chrome")){ 
		System.setProperty("webdriver.chrome.driver", "D:\\AutomationAug2022\\AutomationWithTestNG\\drivers\\chromedriver.exe"); 
		driver = new ChromeDriver();
		System.out.println("chrome opened succesfully"); 
     	}else if(browser.equalsIgnoreCase("edge")){
		System.setProperty("webdriver.edge.driver", "D:\\AutomationAug2022\\AutomationWithTestNG\\drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		System.out.println("edge opened succesfully"); 
	   }
	driver.get("https://practice.automationtesting.in/my-account/"); 
	driver.manage().window().maximize();
  }

	@Parameters({"username","password"})
	@Test 
	public void verifyUserLogon(String username,String password) 
	{
		driver.findElement(By.xpath("//*[@name=\"username\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@name=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@value=\"Login\"]")).click();
		boolean actualDisplayed=driver.findElement(By.xpath("//p[contains(text(),\"Hello\")]")).isDisplayed();
		Assert.assertTrue(actualDisplayed);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
