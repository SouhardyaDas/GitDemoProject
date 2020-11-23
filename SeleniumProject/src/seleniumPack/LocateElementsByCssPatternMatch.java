package seleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementsByCssPatternMatch {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		
		System.out.println("Identify all the elements that start with c using css");
		List<WebElement> startswithidccss = driver.findElements(By.cssSelector("[id^='c']"));
		System.out.println("No. of elements that start with c using css = " + startswithidccss.size());
		for(WebElement element: startswithidccss){
			System.out.println(element.getAttribute("id"));
		}
		
		System.out.println("Identify all the elements that contain height using css");
		List<WebElement> containsidheightcss = driver.findElements(By.cssSelector("[id*='height']"));
		System.out.println("No. of elements that start contains height using css = " + containsidheightcss.size());
		for(WebElement element: containsidheightcss){
			System.out.println(element.getAttribute("id"));
		}
		
		System.out.println("Identify all the elements that end with weight using css");
		List<WebElement> endswithnameweightcss = driver.findElements(By.cssSelector("[id$='weight']"));
		System.out.println("No. of elements that ends with weight using css = " + endswithnameweightcss.size());
		for(WebElement element: endswithnameweightcss){
			System.out.println(element.getAttribute("id"));
		}

	}

}
