package seleniumPack;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlertPopups {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net/calorie-calculator.html");
		driver.manage().window().maximize();
		
		//Lets create an informational alert
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('This is an informational alert!');");
		//To handle the alert - verify the message and click on OK button
		//now to be able to get the alert message and click on OK button
		//we need to switch control to the alert
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		Thread.sleep(3000);
		alert.accept(); //click on OK button
		if(alertMsg.equals("This is an informational alert!"))
			System.out.println("Alert Msg match found!");
		else
			System.out.println("Alert Msg match not found!");
		
		js.executeScript("confirm('Do you want to continue (y/n)?');");
		alert = driver.switchTo().alert();
		alertMsg = alert.getText();
		Thread.sleep(3000);
		alert.dismiss(); //click on Cancel button
		if(alertMsg.equals("This is an informational alert!"))
			System.out.println("Alert Msg match found!");
		else
			System.out.println("Alert Msg match not found!");

	}

}
