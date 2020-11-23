package testngPack;

import java.util.regex.Pattern;
import java.util.regex.Matcher; 

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class Login {
	
	WebDriver driver=null;
	@Test
	public boolean  isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&-]+)@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
	@Test
	public void Pass() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.travolook.in/");
		driver.manage().window().maximize();
		
		WebElement login=driver.findElement(By.xpath("//*[@id='login_top1']"));
		login.click();
		
		WebElement user=driver.findElement(By.xpath("//*[@id=\'txtloginemail\']"));
		user.sendKeys("myjo16ec@cmrit.ac.in");
		user.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		String userText=user.getAttribute("value");
		System.out.println(userText);
		
		if (isValid(userText)) { 
            System.out.println("Yes");
		}
        else {
        	WebElement invalidemail=driver.findElement(By.xpath("//*[@id='phn1']"));
        	String display=invalidemail.getText();
            System.out.println(display);           
        }
		
		
		  Thread.sleep(2000);
		  
		  
		  WebElement pass=driver.findElement(By.xpath("//*[@id='txtloginpassword']"));
		  pass.sendKeys("");
		  
		  
		  WebElement ok=driver.findElement(By.xpath("//*[@id='login']/input[4]"));
		  ok.click();
		  
		  String passText = pass.getAttribute("value");
		  System.out.println("Password is = " + passText);
		  
		  
		  if(passText.equals("")) {
			  WebElement invalidpass=driver.findElement(By.xpath("//*[@id='pass1']/ul/li"));
			  String Display=invalidpass.getText();
			  System.out.println(Display);
		  }
		  else {
			  WebDriverWait wait=new WebDriverWait(driver,30);
				try {
				wait.until(ExpectedConditions.alertIsPresent());
				Alert alert = driver.switchTo().alert(); // switch to alert

				String alertMessage= alert.getText();
				Thread.sleep(2000);
				alert.accept(); 

				System.out.println(alertMessage); 
				}
				catch(NoAlertPresentException e) {
					System.out.println("Alert Not found");
				}catch(UnhandledAlertException e){
					System.out.println("Alert Open");
				}
				WebElement close=driver.findElement(By.xpath("//*[@id=\'login\']/i"));
				 close.click();
		  }
			
		}

	}