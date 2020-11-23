package seleniumPack;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshots {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.online.citibank.co.in/products-services/online-services/internet-banking.htm");
		driver.manage().window().maximize();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE); //Logic file object of the screenshot
		//Reference common-io jars to enable making a copy of logical file object
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"/Screenshots/CityBankPage.png"));
		
	}

}
