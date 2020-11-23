package assignmentPack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonTest {
		
	WebDriver driver = null;
	WebDriverWait wait = null;
	Actions actions = null;
	
	@BeforeClass
	public void launchBrowser() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 30);
		actions = new Actions(driver);
		Thread.sleep(1000);
	}
	
	@Test
	public void test1() throws InterruptedException, IOException {	
		//Language change and screenshot
		//Change to Hindi
		WebElement flagButton1 = driver.findElement(By.xpath("//*[@id='icp-nav-flyout']/span/span[2]/span[1]"));
		actions.moveToElement(flagButton1).build().perform();
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='nav-flyout-icp']/div[2]/a[1]/span")));
			WebElement Hindi = driver.findElement(By.xpath("//*[@id='nav-flyout-icp']/div[2]/a[1]/span"));
			actions.moveToElement(Hindi).click().build().perform();
		}catch(NoSuchElementException e){
			System.out.println("No Such Element!");
		}
		Thread.sleep(1000);
		
		//Take Screenshot
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"/Screenshots/AmazonHindiPage.png"));
		Thread.sleep(1000);
		
		//Change back to English
		WebElement flagButton2 = driver.findElement(By.xpath("//*[@id='icp-nav-flyout']/span/span[2]/span[1]"));
		actions.moveToElement(flagButton2).build().perform();
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='nav-flyout-icp']/div[2]/a[1]/span/i")));
			WebElement English = driver.findElement(By.xpath("//*[@id='nav-flyout-icp']/div[2]/a[1]/span/i"));
			actions.moveToElement(English).click().build().perform();
		}catch(NoSuchElementException e){
			System.out.println("No Such Element!");
		}
		Thread.sleep(2000);
	}
	
	@Test
	public void test2() throws InterruptedException{
		//Search, add to cart and view cart
		WebElement searchTxtbox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		searchTxtbox.sendKeys("oneplus 8 pro");
		searchTxtbox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		//Add to cart
		WebElement product = driver.findElement(By.xpath("//*[@id='search']/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div[2]/div[1]/div/div/span/a/div/img"));
		product.click();
		Thread.sleep(1000);
		ArrayList<String> Tab = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(Tab.get(1));
	    Thread.sleep(1000);
		WebElement addToCart = driver.findElement(By.xpath("//*[@id='add-to-cart-button']"));
		addToCart.click();
		Thread.sleep(1500);
		WebElement close = driver.findElement(By.xpath("//*[@id='attach-close_sideSheet-link']"));
		close.click();
		Thread.sleep(1500);
		
		//View cart
		WebElement viewCart = driver.findElement(By.xpath("//*[@id='nav-cart-text-container']/span[2]"));
		actions.moveToElement(viewCart).click().build().perform();
		Thread.sleep(3000);
	}
	
	@Test
	public void test3() throws InterruptedException{
		//Invalid Login
		ArrayList<String> Tab = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(Tab.get(1));
		WebElement helloButton = driver.findElement(By.xpath("//*[@id='nav-link-accountList']/div/span"));
		actions.moveToElement(helloButton).build().perform();
		Thread.sleep(1000);
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='nav-flyout-ya-signin']/a/span")));
			WebElement SignIn = driver.findElement(By.xpath("//*[@id='nav-flyout-ya-signin']/a/span"));
			actions.moveToElement(SignIn).click().build().perform();
		}catch(NoSuchElementException e){
			System.out.println("No Such Element!");
		}
		Thread.sleep(1000);
		WebElement mailTxtbox = driver.findElement(By.xpath("//*[@id='ap_email']"));
		mailTxtbox.sendKeys("testing login");
		Thread.sleep(1000);
		WebElement contButton = driver.findElement(By.xpath("//*[@id='continue']"));
		contButton.click();
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void closeBrowser(){
		if(driver!=null){
			driver.close();
			driver.quit();
		}
	}

}
