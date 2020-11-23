package seleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementsByXpath {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		
		//By abosolute path
		WebElement ageLabelByAbsPath = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[5]/table[1]/tbody/tr[1]/td[1]"));
		System.out.println("Identifying label by absolute path = " + ageLabelByAbsPath.getText());
		
		//By relative path
		WebElement ageLabelByRelPath = driver.findElement(By.xpath("//*[@id='calinputtable']/tbody/tr[1]/td[1]"));
		System.out.println("Identifying label by relative path = " + ageLabelByRelPath.getText());

	}

}
