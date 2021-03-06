package com.qait.Hris;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args )
    {
    	 System.setProperty("webdriver.chrome.driver", "src" + File.separator + "test" + File.separator + "resources"
					+ File.separator + "Drivers" + File.separator + "chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.manage().window().maximize();
      driver.get("http://10.0.1.61/qaithris/login.php");
      driver.findElement(By.xpath(".//*[@id='demo-2']/div/div[2]/ul/li[1]/a")).click();
      driver.findElement(By.xpath(".//*[@id='txtUserName']")).sendKeys("akashsharma");
      driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("akash_sharma8");
      driver.findElement(By.name("Submit")).click();
      driver.findElement(By.xpath("//a[@class='otherTab' and text()='GLPI']")).click();  
      driver.findElement(By.xpath("//a[text()='My Reservations']")).click();
      driver.switchTo().frame("rightMenu");
      driver.findElement(By.xpath("//button[@id='show-add-form-button']")).click();
     
      WebElement project = driver.findElement(By.name("project-id"));
		
     Select project_select = new Select(project);
		
		
		project_select.selectByValue("2695");
		
		WebElement item = driver.findElement(By.name("item-id"));
		Select item_select = new Select(item);
		/*driver.findElement(By.xpath("//select")).click();*/
		item_select.selectByValue("66");
		
		
		
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
//		System.out.println("=======" + s);
		s=StringUtils.replace(s, "$replacement", y);

		driver.findElement(By.xpath(s)).click();
		
		driver.findElement(By.xpath("//input[@id='resa[starttime]']")).click();
		
		WebElement time = driver.findElement(By.xpath("//div[@class='ui-timepicker-wrapper']//li[text()='10:00']")); // li have value 10:00
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", time);
		time.click();
		
		
		
    }
}
