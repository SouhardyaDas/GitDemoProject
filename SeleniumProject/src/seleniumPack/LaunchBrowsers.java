package seleniumPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchBrowsers {
	public static String browser = "chrome";
	public static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		// Browser Launch Codes
		// To launch the browser and navigate to a url we need to send a request to the driver
		// Then create an instance of the driver
		if(browser.equals("chrome"))
		{
			// Chrome version 86 and chromedriver version 86.0.4240.22
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			// Firefox version 82 and geckodriver version 0.28.0
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("internetexplorer"))
		{
			// Internet Explorer version 11 and geckodriver version 3.150.1
			System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.get("https://www.selenium.dev/selenium/docs/api/java/");
		Thread.sleep(3000);
		driver.close();
	}

}
