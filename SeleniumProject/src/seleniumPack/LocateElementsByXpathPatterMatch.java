package seleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementsByXpathPatterMatch {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		
		System.out.println("Identify all the elements that start with c using xpath");
		List<WebElement> startswithidcxpath = driver.findElements(By.xpath("//*[starts-with(@id,'c')]"));
		for(WebElement element: startswithidcxpath){
			System.out.println(element.getAttribute("id"));
		}
		
		System.out.println("Identify all the elements that contain height using xpath");
		List<WebElement> containsidheightxpath = driver.findElements(By.xpath("//*[contains(@id,'height')]"));
		for(WebElement element: containsidheightxpath){
			System.out.println(element.getAttribute("id"));
		}
		
		//System.out.println("Identify all the elements that end with weight using css");
		//List<WebElement> endswithnameweightxpath = driver.findElements(By.xpath("//*[ends-with(@id,'weight')]"));
		//System.out.println("No. of elements that ends with weight using xpath = " + endswithnameweightxpath.size());
		//for(WebElement element: endswithnameweightxpath){
		//	System.out.println(element.getAttribute("id"));
		//}

	}

}
