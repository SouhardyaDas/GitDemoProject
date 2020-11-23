package com.project.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.ObjectMap.ObjectRepos;

public class BMIPage {
	@FindBy(id=ObjectRepos.BMIPage.bp_agetxt_id)
	WebElement ageTextbox;
	
	@FindBy(name=ObjectRepos.BMIPage.bp_gender_name)
	List<WebElement> genderList;
	

	@FindBy(linkText=ObjectRepos.BMIPage.bp_calorie_linktext)
	WebElement CalorieLink;
	
	WebDriver driver;
	
	public BMIPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public CaloriePage2 CalorieLinkClick(){
		CalorieLink.click();
		return new CaloriePage2(driver);
	}

}
