package com.vyasasti.testng.basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticeAutomation {
	
	WebDriver  driver;
	  @BeforeClass
	  public void openBrowser() {
		  System.setProperty("webdriver.chrome.driver",
				  "D:\\AutomationAug2022\\AutomationWithTestNG\\drivers\\chromedriver.exe");
		 driver=new ChromeDriver(); 
		 driver.get("http://practice.automationtesting.in/");
		 driver.manage().window().maximize();
	  }
	  
	  @Test(groups="Regression")
	  public void test3()
	  {
		  Assert.assertEquals("A", "A");
	  }
	
	  @Test(priority=1,description="verify title of page",groups="Sanity",invocationCount=3,invocationTimeOut=10000)
	  public void verifyTitleOfHomePage() {
		  String expectedTitle="Automation Practice ";
		  String actualTitle=driver.getTitle();
		  //validation
		Assert.assertEquals(actualTitle, expectedTitle);//hard assert  if fail here next code will not execute
		System.out.println("code1 ");
		System.out.println("code1 ");
		Assert.assertEquals("Submitted", "Submitted");
	  }
	  
	  @Test(groups="Regression",dependsOnGroups="Sanity")
	  public void test2()
	  {
	    Assert.assertEquals(false, false);
	  }
	  
	  @Test(priority=3,groups="Sanity",description="To verify header text")
	  public void verifyNewArrivalHeaderText()
	  {
		 String expectedHeaderText="new arrivals";
		 String actualHeaderText=driver.findElement(By.tagName("h2")).getText();
		  Assert.assertEquals(actualHeaderText, expectedHeaderText);
	  }
	  
	  @Test(priority=-5,groups={"Regression","Sanity"})
	  public void verifySliderDisplay()
	  {
		 boolean actualDisplyed=driver.findElement(By.xpath("//div[@id=\"text-22-0-0-1\"]")).isDisplayed();
		 //Assert.assertEquals(actualDisplyed, true);
		 Assert.assertTrue(actualDisplyed);
	  }
	  
	  @Test(alwaysRun=true,dependsOnMethods={"verifyTitleOfHomePage"},priority=2,groups={"Retest","EndToEnd"})
	  public void verifySliderCount()
	  {
	     List<WebElement> imgEle=driver.findElements(By.xpath("//div[@id=\"text-22-0-0-1\"]//img[@class=\"n2-ss-slide-background-image n2-ss-slide-fill n2-ow\"]"));
		 int actualslideCount=imgEle.size();
		 Assert.assertEquals(actualslideCount,3);
	  }
	  
	  
	  @Test(groups="Regression",enabled=true)
	  public void verifyBooksCountDisplayed()
	  {
	     List<WebElement> bookHeaderEle=driver.findElements(By.tagName("h3"));
		 int actualbookHeaderCount=bookHeaderEle.size();
		 Assert.assertEquals(actualbookHeaderCount,3);
	  }
 
	  @AfterClass
	  public void closeBrowser() {
		 driver.close();
	  }
}
