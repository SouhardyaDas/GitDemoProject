package testngPack;

import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalorieCalculatorTestCase {
	WebDriver driver = null;
	
	@BeforeClass
	//@BeforeMethod
	public void LaunchBrowser(){
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();		
	}
	
	@Test(dataProvider = "getCalorieData")
	public void EnterCalorieDetails(Hashtable<String,String> data) throws InterruptedException{
		//Locate elements by id attribute
		WebElement ageTextbox = driver.findElement(By.id("cage"));
		//WebElement ageTextbox = driver.findElement(By.xpath("//*[@id='cage']"));
		ageTextbox.clear(); //clears the textbox
		ageTextbox.sendKeys(data.get("age")); //enters value in the textbox
		//Locate elements by name attribute
		//import the package java.util.List
		List<WebElement> genderList = driver.findElements(By.name("csex"));
		//List<WebElement> genderList = driver.findElements(By.xpath("//*[@name='csex']"));
		if(genderList.size()>0){
			for(WebElement gender : genderList){
				if(gender.getAttribute("value").equals(data.get("gender"))){
					if(!gender.isSelected()){
						gender.click();
						break;
					}
				}
			}
		}
	}
	
	@DataProvider
	public Object[][] getCalorieData(){
		Object[][] data = new Object[1][1];
		Hashtable<String,String> rec1 = new Hashtable<String,String>();
		rec1.put("age", "45");
		rec1.put("gender", "f");
		data[0][0] = rec1;
		return data;
	}
	
	@Test
	public void WebTable() throws InterruptedException{		
		//Locate elements by class attribute
		WebElement table = driver.findElement(By.className("cinfoT"));
		//WebElement table = driver.findElement(By.xpath("//*[@class='cinfoT ']"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for(WebElement row: rows){
			List<WebElement> cols = row.findElements(By.tagName("td"));
			for(WebElement col: cols){
				System.out.print(col.getText()+"\t");
			}
			System.out.println();
		}
		Thread.sleep(3000);
	}
	
	@AfterClass
	//@AfterMethod
	public void CloseBrowser(){
		if(driver!=null)
		{
			driver.close();
			driver.quit();
		}
	}

}
