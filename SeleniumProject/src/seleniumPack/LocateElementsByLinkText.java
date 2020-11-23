package seleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementsByLinkText {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		
		WebElement bmilink = driver.findElement(By.linkText("BMI"));
		bmilink.click(); //navigate to the bmi page
		System.out.println("Title of BMI Page = "+driver.getTitle());
		Thread.sleep(2000);
		driver.navigate().back(); //go back to the previous page
		System.out.println("URL of Calorie Page = "+driver.getCurrentUrl());
		Thread.sleep(2000);
		WebElement weightLink = driver.findElement(By.partialLinkText("Weight"));
		weightLink.click();
		Thread.sleep(2000);
		System.out.println("Page source = "+driver.getPageSource());
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();

	}

}
