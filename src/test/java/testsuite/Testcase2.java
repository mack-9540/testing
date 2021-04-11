package testsuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase2 {
	@BeforeMethod
	public void BeforeTest() {
		System.out.println("Before Test");
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside before method");
	}
	
	@Test
	public void test3() {
			
			System.out.println("Inside test 3");
			
		}
	@Test
	public void test4() {
		System.out.println("inside test case4");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("Inside after method");
	}
	
	@AfterMethod
	public void afterTest() {
		System.out.println("After test");
	}

}
