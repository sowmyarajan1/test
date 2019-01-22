package com.project.Automation;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	
	public static WebDriver driver;
	public static String path="./config.properties";
	public static Properties prop;
	public WebElement e;
	

	
	public void openBrowser(String browser) throws Exception {
		
		if(prop==null)
		{
			prop = new Properties();
			File f = new File(path);
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);
		}
		
		if(prop.getProperty(browser).equalsIgnoreCase("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriver_exe"));
			driver = new ChromeDriver();
		}
		
		if(prop.getProperty(browser).equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("geckodriver.exe"));
			driver = new FirefoxDriver();
		}
		
		if(prop.getProperty(browser).equalsIgnoreCase("EDGE"))
		{
			System.setProperty("webdriver.edge.driver", prop.getProperty("MicrosoftWebDriver.exe"));
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
	}
	
	public void navigate(String url) {
		
		driver.get(prop.getProperty(url));
	}
	
	public void text(String eleLocatorkey, String value) {
		
		//driver.findElement(By.id(prop.getProperty(eleLocatorkey))).sendKeys(value);
		getElement(eleLocatorkey).sendKeys(value);
		
	}	

	public void clickElement(String eleLocatorkey) {
		
		//driver.findElement(By.xpath(prop.getProperty(eleLocatorkey))).click();
		getElement(eleLocatorkey).click();
		
	}
	
	public WebElement getElement(String element) {
		
		
		if(element.endsWith("_id"))
		{
			e=driver.findElement(By.id(prop.getProperty(element)));
		}
		else if(element.endsWith("_xpath"))
		{
			e=driver.findElement(By.xpath(prop.getProperty(element)));
		}
		else if(element.endsWith("_name"))
		
		{
			e=driver.findElement(By.name(prop.getProperty(element)));
		}
		
		return e;
		
	}		

}

