package unitTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import setup.GetProperty;
import setup.Wait;

public class FirstProgram {
	Wait wait = new Wait();
	GetProperty property = new GetProperty();
	WebDriver driver;
	String url = "https://opensource-demo.orangehrmlive.com/";
	
	
	@BeforeMethod
	public void beforeMethod(){
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		wait.implicitWait(driver,10);
	}

	@Test
	public void loginTest(){
		driver.navigate().to(url);
		String username = property.getPropertyByValue("username");
		String password = property.getPropertyByValue("password");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
		driver.close();
		
	}
}
