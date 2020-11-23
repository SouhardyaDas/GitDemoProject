	package com.project.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.project.config.EnvSettings;
import com.project.pages.BMIPage;
import com.project.pages.CaloriePage;
import com.project.pages.CaloriePage2;
import com.project.pages.CaloriePage3;

public class CalorieCalculatorPageTestCase {
	
	WebDriver driver = null;
	
	@Test
	public void EnterCalorieDetails(){
		System.setProperty("webdriver.chrome.driver", EnvSettings.QAEnv.chromedriverpath);
		driver = new ChromeDriver();
		driver.get(EnvSettings.QAEnv.appurl);
		driver.manage().window().maximize();	
		
		//Instance of CaloriePage
		//Page Object implementation without PageFactory
		CaloriePage cp = new CaloriePage(driver);
		cp.enterCalorieDetails("45", "f");
		
		CaloriePage2 cp2 = new CaloriePage2(driver);
		cp2.enterCalorieDetails("56", "m");
		
		CaloriePage3 cp3 = new CaloriePage3(driver);
		cp3 = PageFactory.initElements(driver, CaloriePage3.class);
		cp3.enterCalorieDetails("67", "f");
		
		BMIPage bp = new BMIPage(driver);
		cp2 = bp.CalorieLinkClick();
		cp2.enterCalorieDetails("90", "m");
	}
	
}
