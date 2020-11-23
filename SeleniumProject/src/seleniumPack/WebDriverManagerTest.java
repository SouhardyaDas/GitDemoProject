package seleniumPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//Gets downloaded automatically by detecting the compatible latest version
//and stores it in location C:\Users\Anindita\.cache\selenium
public class WebDriverManagerTest {
	public WebDriver driver = null;
	public String browser = "firefox";
	@Test
	public void WebDriverManagerTest(){
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();			
			//WebDriverManager.chromedriver().browserVersion("86.0.4240.22").setup();
			driver = new ChromeDriver();
		}else 
		if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else
		if(browser.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		}
		driver.get("https://www.google.com");
		
	}
}
