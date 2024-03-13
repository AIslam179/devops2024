package seleniumProject;

import java.util.Collections;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstLecture {
	
	public static void main(String[] args) {
		
		//Creating Chrome driver object
		
		//System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver=new ChromeDriver();
		//WebDriver driver=new FirefoxDriver();
		
		// Create an object of Chrome Options class
	       ChromeOptions chromeOptions = new ChromeOptions();       
	       chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
	       chromeOptions.addArguments("--remote-allow-origins=*");
	       chromeOptions.addArguments("window-size=800,480");
	       
	      driver = new ChromeDriver(chromeOptions);
		//open the browser
		driver.get("https://www.google.com/");
		
		//driver maximize 
		driver.manage().window().maximize();
		
		//get current URL
		String url=driver.getCurrentUrl();
		
		System.out.println("Current URL is :" + url);
		
		//get title
		//String title=driver.getTitle();
		//System.out.println("title is :" + title);
		
		String expectedTitle="Google";
		String actualTitle=driver.getTitle();
		if(expectedTitle.contains(actualTitle)) {
			System.out.println("validation pass");
		}else
			System.out.println("validation fail");
		
		//Assert.assertTrue("verify the error message !",expectedTitle.contains(actualTitle));
		
		//get pagesource
		
		//String pagesource=driver.getPageSource();
		//System.out.println("Page source is :" + pagesource);
		
		//To close current the opened browser session
		driver.close();
		//To close all the opened browser session
		driver.quit();
		
	}

}
