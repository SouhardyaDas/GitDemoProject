package seleniumPack;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleWindowNav {
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.online.citibank.co.in/products-services/online-services/internet-banking.htm");
		driver.manage().window().maximize();
		
		//now I want to get the Id of the main window
		String ParentWindowId = driver.getWindowHandle();
		System.out.println("Parent Window ID = " + ParentWindowId);
		//Click on Login button
		WebElement LoginNow = driver.findElement(By.xpath("//*[@title='LOGIN NOW']"));
		LoginNow.click();
		//At this point of time, there are 2 windows open via script
		//Now, I need to get window handles or Ids of both the windows
		//Please note, whenever you are performing an operation it is leading to opening up
		//another window - you need to make sure to getWindowHandles to know the current number
		//of open windows and window Ids
		Set<String> winids = driver.getWindowHandles();
		System.out.println("Number of open windows = " + winids.size());
		//If I want to iterate through the set of window Ids - can use the iterator
		//Iterator is used to iterate through the window Ids
		Iterator<String> iter = winids.iterator();
		String mainWindowId = iter.next().toString();
		String subWindowId = iter.next().toString();
		System.out.println("Main Window Id = " + mainWindowId);
		System.out.println("Sub Window Id = " + subWindowId);
		//Switch control to sub window
		driver.switchTo().window(subWindowId);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try{
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("User_Id")));
			driver.findElement(By.id("User_Id")).sendKeys("Selenium");
			Thread.sleep(3000);
			driver.close();
			driver.switchTo().window(mainWindowId);
			driver.findElement(By.id("topMnuinsurance")).click();
		}catch(Exception e){
			System.out.println("Element Used_Id is not found!");
		}

	}

}
