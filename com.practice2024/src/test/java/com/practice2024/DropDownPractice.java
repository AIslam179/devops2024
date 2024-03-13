package com.practice2024;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DropDownPractice {
	WebDriver driver;
	public static final By firstname=By.name("firstName");
	public static final By lastname=By.xpath("//input[@name='lastName']");
	public static final By postalcode=By.xpath("//input[@name='postalCode']");
	
	@BeforeClass
	public void driverSetUp() {
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@BeforeMethod
	public void openBrowser() {
		
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		System.out.println("current URL is :" + driver.getCurrentUrl());
		
	}
	
	@Test
	public void registerToMTours() {
		
		driver.findElement(firstname).sendKeys("John");
		driver.findElement(lastname).sendKeys("Bobo");
		driver.findElement(postalcode).sendKeys("22004");
		
		
	}
	
	@Ignore
	@Test
	public void selectDropDown() {
		WebElement country=driver.findElement(By.name("country"));
		Select anyCountry=new Select(country);
		//anyCountry.selectByIndex(18);
		//anyCountry.selectByValue("BANGLADESH");
		//anyCountry.selectByVisibleText("UNITED STATES");
		
	   //Print all the options for the selected drop down and select one option of your choice
		
		//Get the size of the Select Element
		
		List<WebElement> oSize=anyCountry.getOptions();
		int iListSize=oSize.size();
		
		//Setting up the loop to print all the options
		
		for(int i=0; i <iListSize; i++) {
			
			//Storing the value of the option
			String sValue=anyCountry.getOptions().get(i).getText();
			
			//Printing the stored value
			System.out.println(sValue);
			
			//Putting a check on each option that if any of the option is equal to BHUTAN
			
			if(sValue.equals("BHUTAN")) {
				anyCountry.selectByIndex(i);
				break;
				
			}
			
		}
		
		
		
	}
	
	@Test
	public void select_Country_Options_from_Dropdown() {
		
		boolean country_dropdown_Parameter=driver.
				findElement(By.name("country")).isDisplayed();
		if(country_dropdown_Parameter ==true) {
			Select oSelect=new Select(driver.
				findElement(By.name("country")));
			
			List<WebElement>values=oSelect.getOptions();
			
			for(int i=0; i<values.size(); i++) {
				
				String expected_value=values.get(i).getText();
				System.out.println(expected_value);
				
				if(expected_value.equalsIgnoreCase("Bhutan")) {
					values.get(i).click();
					break;
				}
				
			}
		}
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
