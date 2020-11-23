package testngPack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalorieCalculatorDDT {
	
	//@Test(dataProvider="login")
	@Test(dataProvider="getLoginData")
	public void Login(String username, String password){
		System.out.println("Enter username = " + username);
		System.out.println("Enter password = " + password);
		System.out.println("Click on Submit button");
	}
	
	//@DataProvider="login"
	@DataProvider
	public Object[][] getLoginData(){
		String[][] data = new String[2][2];
		data[0][0] = "username1";
		data[0][1] = "password1";
		data[1][0] = "username2";
		data[1][1] = "password2";
		return data;
	}

}
