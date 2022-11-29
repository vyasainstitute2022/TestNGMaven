package com.vyasasti.testng.basic;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
	
public class DataProviderData {
	
	public static WebDriver driver;
	public static WebElement weUserName,weUserPass,weConfirmPass,wePreLang,weEngLang,weSecAns,weSecAnsSel,weSecAnsin;
	
	@BeforeClass	
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\AutomationAug2022\\AutomationWithTestNG\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/profile/user-registration");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement okButton=driver.findElement(By.xpath("//button[text()='OK']"));
		if(okButton.isDisplayed()) {
			okButton.click();
		}
	}
	
	@Test(dataProvider="login-data" )
	public void loginform(String tcid,String tcdesc,String Uname,String pass,String conpass,String secansin)
	{
		System.out.println("Test Case id:"+tcid);
		System.out.println("Test Case desc:"+tcdesc);
		
		weUserName=driver.findElement(By.xpath("//*[@id=\"userName\"]"));
		weUserName.clear();
		weUserName.sendKeys(Uname);
		
		weUserPass=driver.findElement(By.xpath("//*[@id=\"usrPwd\"]"));
		weUserPass.clear();
		weUserPass.sendKeys(pass);
		
		weConfirmPass=driver.findElement(By.xpath("//*[@id=\"cnfUsrPwd\"]"));
		weConfirmPass.clear();
		weConfirmPass.sendKeys(conpass);
		
		wePreLang=driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[5]/p-dropdown/div"));
		wePreLang.click();
		
		weEngLang=driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[5]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[1]/li/span"));
		weEngLang.click();
		
		weSecAns=driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[6]/p-dropdown/div"));
		weSecAns.click();
		
		weSecAnsSel=driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[6]/p-dropdown/div/div[4]/div/ul/p-dropdownitem[1]/li/span"));
		weSecAnsSel.click();
		
		weSecAnsin=driver.findElement(By.xpath("//*[@id=\"ui-tabpanel-0\"]/div/div[7]/input"));
		weSecAnsin.clear();
		weSecAnsin.sendKeys(secansin);
	}
	
	@DataProvider(name="login-data")
	public Object[][] loginData() 
	{   
				return new Object[][]{ {},{},{} };
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
