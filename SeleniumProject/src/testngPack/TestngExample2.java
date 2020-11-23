package testngPack;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngExample2 {
	
	@BeforeSuite
	public void BeforeSuite(){
		System.out.println("Example 2 - Ececuting BeforeSuite");
	}

	@AfterSuite
	public void AfterSuite(){
		System.out.println("Example 2 - Ececuting AfterSuite");
	}
	
	@BeforeTest
	public void BeforeTest(){
		System.out.println("Example 2 - Ececuting BeforeTest");
	}

	@AfterTest
	public void AfterTest(){
		System.out.println("Example 2 - Ececuting AfterTest");
	}
	
	@BeforeClass
	public void BeforeClass(){
		System.out.println("Example 2 - Ececuting BeforeClass");
	}

	@AfterClass
	public void AfterClass(){
		System.out.println("Example 2 - Ececuting AfterClass");
	}
	
	@BeforeMethod
	public void BeforeMethod(){
		System.out.println("Example 2 - Ececuting BeforeMethod");
	}

	@AfterMethod
	public void AfterMethod(){
		System.out.println("Example 2 - Ececuting AfterMethod");
	}
	
	@Test
	public void test1(){
		System.out.println("Example 2 - Test 1");
	}
	
	@Test
	public void test2(){
		System.out.println("Example 2 - Test 2");
	}

}
