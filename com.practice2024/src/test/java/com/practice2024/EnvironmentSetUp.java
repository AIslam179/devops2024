package com.practice2024;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EnvironmentSetUp {
	
	WebDriver driver;
	
	@BeforeClass
	public void driverSetUp() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@BeforeMethod
	public void openBrowser() {
		
		driver.get("https://login.salesforce.com/");
		System.out.println("current URL is :" + driver.getCurrentUrl());
		
	}
	
	@Test
	public void login() {
		
	WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
	username.clear();
	username.sendKeys("JohnBobo");
	
	WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
	password.clear();
	password.sendKeys("abc12345");
	
	WebElement login=driver.findElement(By.xpath("//input[@id='Login']"));
	login.click();
	}
	
	@AfterMethod
	public void afterLogin() {
		System.out.println(driver.getCurrentUrl());
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
		
	}
	
	
	

}
