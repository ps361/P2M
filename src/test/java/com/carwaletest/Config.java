package com.carwaletest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Config {
	
	static WebDriver driver = null;

	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.get("https://www.carwale.com/");
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
