package com.vyasasti.testng.basic;

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

public class TestNGAnnotations {

	@BeforeSuite
	public void BeforeSuiteMethod()
	{
		System.out.println("BeforeSuiteMethod");
	}

	@Test
	public void TestMethod1()
	{
		System.out.println("TestMethod1");
	}
	@Test
	public void TestMethod2()
	{
		System.out.println("TestMethod2");
	}
	@BeforeClass
	public void BeforeClassMethod()
	{
		System.out.println("BeforeClassMethod");
	}
	@AfterClass
	public void AfterClassMethod()
	{
		System.out.println("AfterClassMethod");
	}
	@BeforeTest
	public void BeforeTestMethod()
	{
		System.out.println("BeforeTestMethod");
	}
	@AfterTest
	public void AfterTestMethod()
	{
		System.out.println("AfterTestMethod");
	}
	
	@AfterSuite
	public void AfterSuiteMethod()
	{
		System.out.println("AfterSuiteMethod");
	}
	@BeforeGroups
	public void BeforeGroupsMethod()
	{
		System.out.println("BeforeGroupsMethod");
	}
	@AfterGroups
	public void AfterGroupsMethod()
	{
		System.out.println("AfterGroupsMethod");
	}
	
	@BeforeMethod
	public void MethodBefore()
	{
		System.out.println("BeforeMethod");
	}
	@AfterMethod
	public void MethodAfter()
	{
		System.out.println("AfterMethod");
	}
	
}
