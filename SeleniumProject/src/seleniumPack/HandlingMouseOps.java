package seleniumPack;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingMouseOps	 {
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement ComponentsMenu = driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[3]/a"));
		ComponentsMenu.click();
		//Explicit Wait - performed on property of an element
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Actions actions = new Actions(driver);
		
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='menu']/div[2]/ul/li[3]/div/div/ul/li[3]/a")));
			WebElement PrinterElement = driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[3]/div/div/ul/li[3]/a"));
			actions.moveToElement(PrinterElement).click().build().perform();
			//PrinterElement.click();
		}catch(NoSuchElementException e){
			System.out.println("No Such Element!");
		}
		

	}

}
