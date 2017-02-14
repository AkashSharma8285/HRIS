package com.qait.Hris.Keywords;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Keywords_class {
	public void login(WebDriver driver) {
		driver.get("http://10.0.1.61/qaithris/login.php");
		driver.findElement(By.xpath(".//*[@id='demo-2']/div/div[2]/ul/li[1]/a")).click();
		driver.findElement(By.xpath(".//*[@id='txtUserName']")).sendKeys("akashsharma");
		driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("akash_sharma8");
		driver.findElement(By.name("Submit")).click();
	}
	
	public void checkHomePage(WebDriver driver){
		if(!driver.getTitle().equals("QAIT HRIS")){
			driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']//i[@class='fa fa-chevron-left fa-2x']")).click();
			System.out.println("navigate to home page");
		}
	}
	public void glpi(WebDriver driver){
	driver.findElement(By.xpath("//a[@class='otherTab' and text()='GLPI']")).click();  
	driver.findElement(By.xpath("//a[text()='My Reservations']")).click();
	driver.switchTo().frame("rightMenu");
	driver.findElement(By.xpath("//button[@id='show-add-form-button']")).click();
	WebElement project = driver.findElement(By.name("project-id"));
	
	Select project_select = new Select(project);
	project_select.selectByValue("2695");
	}
	
	public void details(WebDriver driver){
		List<WebElement> eleList =  driver.findElements(By.xpath("//select[@id='item-id']/option"));
		HashMap<String, String> deviceList = new HashMap<String, String>();
		int count = 1;
		for (WebElement each:eleList){
			String deviceName = each.getText();
			String deviceDetails = each.getAttribute("title");
			deviceList.put(Integer.toString(count),("\""+deviceName+"\",\""+deviceDetails.replaceAll("\n", "")+"\""));
			count++;
		}
		
		System.out.println(deviceList);
		
		CSV_File csvObject = new CSV_File();
		csvObject.CSV(deviceList);
	}
	public void reservations(WebDriver driver, String token){
	
	WebElement item = driver.findElement(By.name("item-id"));
	Select item_select = new Select(item);
	/*driver.findElement(By.xpath("//select")).click();*/
	
	CSV_File csv = new CSV_File();
	
	item_select.selectByVisibleText(csv.readData(token).replaceAll("\"", ""));
	
	WebElement duration = driver.findElement(By.id("resa[_duration]"));
	Select duration_select = new Select(duration);
	duration_select.selectByValue("28800");
	
	WebElement Billable_hrs = driver.findElement(By.id("bill-hours"));
	Select hrs_select = new Select(Billable_hrs);
	hrs_select.selectByValue("28800");

	
	driver.findElement(By.xpath("//input[@id='resa[startdate]']")).click();
	
	DateFormat dateFormat = new SimpleDateFormat("dd");
	Date date = new Date();
	String x = dateFormat.format(date);
	String y = String.valueOf(Integer.parseInt(x) + 1);
	String s = "//div[@id='ui-datepicker-div']//a[text()='$replacement']";
//	System.out.println("=======" + s);
	s=StringUtils.replace(s, "$replacement", y);

	driver.findElement(By.xpath(s)).click();
	
	driver.findElement(By.xpath("//input[@id='resa[starttime]']")).click();
	
	WebElement time = driver.findElement(By.xpath("//div[@class='ui-timepicker-wrapper']//li[text()='10:00']")); // li have value 10:00
	
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", time);
	time.click();
	
	driver.findElement(By.xpath("//button[@id='add-resap']")).click();
	try {
		Thread.sleep(7000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	/*driver.findElement(By.xpath("//a[text()='My Reservations']")).click();
	  driver.switchTo().frame("rightMenu");
	  driver.findElement(By.xpath("//button[@id='show-add-form-button']")).click();*/
}
}