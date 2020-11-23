package testngPack;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalorieCalculatorDDT2 {
	
	//@Test(dataProvider="login")
	@Test(dataProvider="getLoginData")
	public void Login(Hashtable<String,String> data){
		System.out.println("Enter username = " + data.get("username"));
		System.out.println("Enter password = " + data.get("password"));
		System.out.println("Click on Submit button");
	}
	
	//@DataProvider="login"
	@DataProvider
	public Object[][] getLoginData(){
		Object[][] data = new Object[2][1];
		Hashtable<String,String> rec1 = new Hashtable<String,String>();
		rec1.put("username", "user1");
		rec1.put("password", "pass1");
		Hashtable<String,String> rec2 = new Hashtable<String,String>();
		rec2.put("username", "user2");
		rec2.put("password", "pass2");
		data[0][0] = rec1;
		data[1][2] = rec2;
		return data;
	}

}
