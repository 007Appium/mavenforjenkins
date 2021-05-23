package unitTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import setup.GetProperty;
import setup.Wait;

public class FirstProgram {
	Wait wait = new Wait();
	GetProperty property = new GetProperty();
	WebDriver driver;
	String url = "https://opensource-demo.orangehrmlive.com/";
	
	@Parameters("Browser")
	@BeforeMethod
	public void beforeMethod(String browserName){
		System.out.println("Paramater value is : "+browserName );
		if (browserName.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}else{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
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
