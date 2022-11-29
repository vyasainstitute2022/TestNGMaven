package com.vyasasti.testng.basic;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertTestNG {

	@Test(groups="Sanity")
	public void m1() {
		//validation
		Assert.assertEquals(false, false, "validation for button display");
	}
	
	@Test(groups="Sanity")
	public void m2() {
		Assert.assertEquals("ABC", "ABC");
	}
	
	@Test(groups="Sanity")
	public void m3() {
		Assert.assertTrue(true);
		Assert.assertTrue(true,"message");
	}
	
	@Test(groups="Regression")
	public void m4() {
		Assert.assertFalse(false);
		Assert.assertFalse(false,"message");
	}
	
	@Test(groups="Regression")
	public void softAssertTest() {
		SoftAssert sa=new SoftAssert();
		sa.assertEquals("B", "A");
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		sa.assertEquals(false, false);
		System.out.println("4");
		System.out.println("5");
		System.out.println("6");
		sa.assertEquals(true, false);
		System.out.println("7");
		sa.assertAll();
	}
	
	
}
