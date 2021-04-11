package testsuite;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	WebDriver driver;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LoginTest obj = new LoginTest();
		
		obj.SetUp();
		obj.Login();
		
		

	}
	
	
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\WebDriverProject\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
	}
	
	public void Login() {
		

		WebElement loginLink = driver.findElement(By.linkText("Log in"));
		loginLink.click();
		WebElement tbEmail = driver.findElement(By.name("user_login"));
		tbEmail.sendKeys("abc@xyz.com");
		
		WebElement tbpwd = driver.findElement(By.name("user_pwd"));
		tbpwd.sendKeys("abc123");
		
		WebElement chkox = driver.findElement(By.className("rememberMe"));
		chkox.click();
		
		WebElement loginBtn = driver
				.findElement(By.name("btn_login"));
		
		loginBtn.click();
		
	}

}
