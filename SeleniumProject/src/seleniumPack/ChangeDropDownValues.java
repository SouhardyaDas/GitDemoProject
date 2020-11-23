package seleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ChangeDropDownValues {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		
		WebElement activitydd = driver.findElement(By.id("cactivity"));
		Select dd = new Select(activitydd);
		//what is the default dropdown value
		System.out.println("Default select dropdown value = " + dd.getFirstSelectedOption().getText());
		dd.selectByIndex(0);
		Thread.sleep(2000);
		System.out.println("Changed select dropdown value to index 0 Basal = " + dd.getFirstSelectedOption().getText());
		dd.selectByValue("1.55");
		Thread.sleep(2000);
		System.out.println("Changed select dropdown value to  value 1.55 = " + dd.getFirstSelectedOption().getText());
		dd.selectByVisibleText("Extra Active: very intense exercise daily, or physical job");
		Thread.sleep(2000);
		System.out.println("Changed select dropdown value to visible text Extra Active = " + dd.getFirstSelectedOption().getText());
		System.out.println("Is the dropdown multiselect = " + dd.isMultiple());

	}

}
