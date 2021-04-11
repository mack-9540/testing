package testsuite;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class NewLoginTest {
	
	WebDriver driver;
	
	

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * 
	 * LoginTest obj = new LoginTest();
	 * 
	 * obj.SetUp(); obj.Login();
	 * 
	 * 
	 * 
	 * }
	 */
	
	@BeforeMethod
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\TestNGProject\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
	}
	@Parameters({"username","password"})
	@Test
	public void Login(String UserName,String Password) {
		

		WebElement loginLink = driver.findElement(By.linkText("Log in"));
		loginLink.click();
		WebElement tbEmail = driver.findElement(By.name("user_login"));
		tbEmail.sendKeys(UserName);
		
		WebElement tbpwd = driver.findElement(By.name("user_pwd"));
		tbpwd.sendKeys(Password);
		
		WebElement chkox = driver.findElement(By.className("rememberMe"));
		chkox.click();
		
		WebElement loginBtn = driver
				.findElement(By.name("btn_login"));
		
		loginBtn.click();
		
		WebElement error = driver.findElement(By.id("msg_box"));
		
		String actMsg = error.getText();
		String expMsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(actMsg, expMsg);
		
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
