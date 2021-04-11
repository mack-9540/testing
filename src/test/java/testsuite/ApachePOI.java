package testsuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ApachePOI {
	
WebDriver driver;
XSSFWorkbook wbook;
XSSFSheet sheet;
	
	

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
	public void SetUp() throws FileNotFoundException,IOException {
		
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\TestNGProject\\drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		FileInputStream fis = new FileInputStream("data.xlsx");
		wbook  = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("data");
		
		
	}
	@Parameters()
	@Test
	public void Login() {
		

		WebElement loginLink = driver.findElement(By.linkText("Log in"));
		loginLink.click();
		
		String UserName = sheet.getRow(0).getCell(1).toString();
		String Password = sheet.getRow(0).getCell(2).toString();
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
