package seleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementsByCss {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		
		WebElement ageLabelByCss = driver.findElement(By.cssSelector("#calinputtable > tbody > tr:nth-child(1) > td:nth-child(1)"));
		System.out.println(ageLabelByCss.getText());
		
		WebElement ageTextBox = driver.findElement(By.cssSelector("#cage"));
		ageTextBox.clear();
		ageTextBox.sendKeys("65");
		System.out.println("Get css width of the Age Textbxo = " + ageTextBox.getCssValue("width"));
		
		WebElement table = driver.findElement(By.cssSelector(".cinfoT"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(WebElement row: rows){
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for(WebElement col: cols){
				System.out.print(col.getText()+"\t");
			}
			System.out.println();
		}
	}

}
