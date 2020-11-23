package seleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElementsByIdNameClass {
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		
		//Locate elements by id attribute
		WebElement ageTextbox = driver.findElement(By.id("cage"));
		//WebElement ageTextbox = driver.findElement(By.xpath("//*[@id='cage']"));
		ageTextbox.clear(); //clears the textbox
		ageTextbox.sendKeys("45"); //enters value in the textbox
		//I also want to retrieve the different attribute informaton
		System.out.println("Tagename of ageTextbox = "+	ageTextbox.getTagName());
		System.out.println("Id value of ageTextbox = "+	ageTextbox.getAttribute("id"));
		System.out.println("Name value of ageTextbox = "+ ageTextbox.getAttribute("name"));
		System.out.println("Type value of ageTextbox = "+ ageTextbox.getAttribute("type"));
		System.out.println("Class value of ageTextbox = "+ ageTextbox.getAttribute("class"));
		System.out.println("Value of ageTextbox = "+ ageTextbox.getAttribute("value"));
		
		//Locate elements by name attribute
		//import the package java.util.List
		List<WebElement> genderList = driver.findElements(By.name("csex"));
		//List<WebElement> genderList = driver.findElements(By.xpath("//*[@name='csex']"));
		if(genderList.size()>0){
			for(WebElement gender : genderList){
				if(gender.getAttribute("value").equals("f")){
					if(!gender.isSelected()){
						gender.click();
						break;
					}
				}
			}
		}
		
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
	}

}
