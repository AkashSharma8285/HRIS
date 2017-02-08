package com.qait.Hris.driver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver_class {

	public WebDriver setup(){
		System.setProperty("webdriver.chrome.driver", "src" + File.separator + "test" + File.separator + "resources"
				+ File.separator + "Drivers" + File.separator + "chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	return driver;
	}
}
