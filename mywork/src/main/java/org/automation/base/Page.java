package org.automation.base;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.automation.util.Xls_Reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Page {
	
	public static WebDriver driver = null;
	public static Properties CONFIG =null;
	public static Properties OR =null;
	public static Xls_Reader xls1= new Xls_Reader("/Users/bhavin.br/business/Page-Object/src/main/java/org/automation/xls/TestCases.xlsx");
	public static boolean isLoggedIn=false;

	public Page(){
		if(driver==null){
		CONFIG= new Properties();
		OR = new Properties();
		try{
			FileInputStream fs = new FileInputStream("/Users/bhavin.br/business/Page-Object/src/main/java/org/automation/config/config.properties");
			CONFIG.load(fs);
			fs = new FileInputStream("/Users/bhavin.br/business/Page-Object/src/main/java/org/automation/config/OR.properties");
			OR.load(fs);
			}catch(Exception e){
				return;
		}
		
		System.out.println(CONFIG.getProperty("browser"));
		if(CONFIG.getProperty("browser").equals("Mozilla"))
		    driver=new FirefoxDriver();
		else if(CONFIG.getProperty("browser").equals("IE"))
		    driver=new InternetExplorerDriver();
		else if(CONFIG.getProperty("browser").equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/bhavin.br/business/Page-Object/ChromeDriver");
		    driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
}
	public void click(String xpathKey){
	        driver.findElement(By.xpath(xpathKey)).click();
	}

	public void input(String xpathKey, String text){
		driver.findElement(By.xpath(xpathKey)).sendKeys(text);
	}

	public boolean isElementPresent(String xpathKey){
		try{
			driver.findElement(By.xpath(xpathKey));
		}catch(Exception e){
			return false;
		}
		
		return true;
	}

	public boolean isLinkPresent(String linkText){
		try{
			driver.findElement(By.linkText(linkText));
		}catch(Exception e){
			return false;
		}
		
		return true;
	}
	
	public static void takeScreenshot(String fileName) {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    try {
			FileUtils.copyFile(scrFile, new File("screenshots\\" + fileName));
		} catch (IOException e) {
			e.printStackTrace();
			close();
		}
	}

	public static void close(){
			driver.close();
	}
}
