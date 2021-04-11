package testsuite;

import org.testng.annotations.Test;

public class Testcase1 {
	
	
	@Test(groups= {"sanity"})
	public void test1() {
		
		System.out.println("Inside test 1");
		
	}

	
	@Test(description = "This is test2")
	public void test2() {
		
		System.out.println("Inside test 2");
		
	}
	
	@Test(dependsOnMethods = "test2")
	public void otherTest() {
		
		System.out.println("Inside othertest");
		
	}
	
	
	

}
