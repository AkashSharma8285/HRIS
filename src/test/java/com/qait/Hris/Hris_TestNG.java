package com.qait.Hris;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qait.Hris.Keywords.Keywords_class;
import com.qait.Hris.Keywords.Text_Read;
import com.qait.Hris.driver.Driver_class;

public class Hris_TestNG {
	static WebDriver driver;
	Driver_class myDriver_class = new Driver_class();
	Keywords_class myKeywords_class = new Keywords_class();
	Text_Read myText_Read = new Text_Read();
	
@BeforeClass
public void values() {
	driver = myDriver_class.setup(); 
	myKeywords_class.login(driver);
	myKeywords_class.glpi(driver);
	myKeywords_class.details(driver);
	driver.quit();
}
	
  @Test
  public void test() {
	  ArrayList<String> dataList = myText_Read.readTestData();
	  for(String each:dataList){
			driver = myDriver_class.setup(); 
			myKeywords_class.login(driver);
			myKeywords_class.glpi(driver);
			myKeywords_class.reservations(driver,each);
			driver.quit();
		  
	  }
  }
}
