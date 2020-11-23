package seleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementsByTextFunction {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		
		System.out.println("Identify all the options in the dropdown that have Active - this will require use of contains function");
		List<WebElement> containsActiveList = driver.findElements(By.xpath("//*[@id='cactivity']/option[contains(text(),'Active')]"));
		for(WebElement element: containsActiveList){
			System.out.println(element.getText());
		}
		
		System.out.println("Identify all the options in the dropdown that start with Extra Active - this will require use of starts-with function");
		List<WebElement> startsWithExtraActiveList = driver.findElements(By.xpath("//*[@id='cactivity']/option[starts-with(text(),'Extra Active')]"));
		for(WebElement element: startsWithExtraActiveList){
			System.out.println(element.getText());
		}
		
		System.out.println("Identify the option in the dropdown that with text Very Active: intense exercise 6-7 times/week");
		WebElement veryActiveOption = driver.findElement(By.xpath("//*[@id='cactivity']/option[text()= 'Very Active: intense exercise 6-7 times/week']"));
		System.out.println(veryActiveOption.getText());

	}

}