package com.vyasasti.testng.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.microsoft.edge.seleniumtools.EdgeDriver;

public class DataProviderExample {
	
	public WebDriver driver;
	@BeforeClass 
	public void browserLaunch() 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\AutomationAug2022\\AutomationWithTestNG\\drivers\\chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.get("https://practice.automationtesting.in/my-account/"); 
		driver.manage().window().maximize();
   }

	@Test(dataProvider="LoginData")
	public void verifyUserLogon(String tcname,String username,String password) 
	{
		WebElement userEle=driver.findElement(By.xpath("//*[@name=\"username\"]"));
		userEle.clear();
		userEle.sendKeys(username);
		
		WebElement passEle=driver.findElement(By.xpath("//*[@name=\"password\"]"));
		passEle.clear();
		passEle.sendKeys(password);
		
		driver.findElement(By.xpath("//*[@value=\"Login\"]")).click();
				
		//validation 
		if(tcname.equalsIgnoreCase("blank"))
		{
			boolean userloginError=driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).isDisplayed();
			Assert.assertTrue(userloginError);
		}else if(tcname.equalsIgnoreCase("blankpass"))
		{
			boolean passError=driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).isDisplayed();
			Assert.assertTrue(passError);
		}else if(tcname.equalsIgnoreCase("invalidlogin"))
		{
			String actualErrorText=driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li/text()")).getText();
			String expectedErrorText=" A user could not be found with this email address.";
			Assert.assertEquals(actualErrorText, expectedErrorText);
			
		}else if(tcname.equalsIgnoreCase("validLogin")){
		    boolean actualDisplayed=driver.findElement(By.xpath("//p[contains(text(),\"Hello\")]")).isDisplayed();
		    Assert.assertTrue(actualDisplayed);
		    driver.findElement(By.linkText("Logout")).click();
		}
	}
	
	@DataProvider
	public Object[][] LoginData()
	{
		return new Object[][] {   {"blank","",""},
			                      {"blankpass","vyasainstitute2022@gmail.com",""},
			                      {"invalidlogin","vyasainstitute@gmail.com","Vyasa@12345"},
			                      {"validLogin","vyasainstitute2022@gmail.com","Vyasa@12345"}   };
	}
	
	@AfterClass
	public void closeBrowser()
	 {
		 driver.quit();
	 }
}
