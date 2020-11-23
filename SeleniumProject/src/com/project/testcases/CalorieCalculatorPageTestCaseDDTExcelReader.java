package com.project.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.config.EnvSettings;
import com.project.pages.CaloriePage;
import com.project.pages.CaloriePage2;
import com.project.pages.CaloriePage3;
import com.project.utils.ExcelReader;
import com.project.utils.PropertyReader;

public class CalorieCalculatorPageTestCaseDDTExcelReader {
	
	WebDriver driver = null;
	
	@BeforeClass
	public void LaunchBrowser() throws IOException{
		//System.setProperty("webdriver.chrome.driver", PropertyReader.ReadProperty("chromedriverpath"));
		System.setProperty("webdriver.chrome.driver", EnvSettings.QAEnv.chromedriverpath);
		driver = new ChromeDriver();
		//driver.get(PropertyReader.ReadProperty("appurl"));
		driver.get(EnvSettings.QAEnv.appurl);
		driver.manage().window().maximize();		
	}
	
	@Test(dataProvider = "getCalorieData")
	public void EnterCalorieDetails(Hashtable<String, String> data) throws InterruptedException{
		
		System.out.println("Running CaloriePage" + data.get("age") + data.get("gender"));
		CaloriePage cp = new CaloriePage(driver);
		cp.enterCalorieDetails(data.get("age"), data.get("gender"));
		Thread.sleep(2000);
		
		System.out.println("Running CaloriePage2" + data.get("age") + data.get("gender"));
		CaloriePage2 cp2 = new CaloriePage2(driver);
		cp2.enterCalorieDetails(data.get("age"), data.get("gender"));
		Thread.sleep(2000);
		
		System.out.println("Running CaloriePage3" + data.get("age") + data.get("gender"));
		CaloriePage3 cp3 = new CaloriePage3(driver);
		cp3 = PageFactory.initElements(driver, CaloriePage3.class);
		cp3.enterCalorieDetails(data.get("age"), data.get("gender"));
		Thread.sleep(2000);
	}
	
	@DataProvider
	public Object[][] getCalorieData() throws IOException{
		String ProjectPath = System.getProperty("user.dir");
		String FilePath = ProjectPath + "/src/com/project/testdata";
		String FileName = "CalorieTestData.xlsx";
		String SheetName = "CalorieTestSet";
		return ExcelReader.ReadFromExcelToObjArr(FilePath, FileName, SheetName);
	}
	
	@AfterClass
	public void CloseBrowser(){
		if(driver!=null)
		{
			driver.close();
			driver.quit();
		}
	}
}
