package setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Wait {

	public void implicitWait(WebDriver driver,int sec){
		driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
	}
}
