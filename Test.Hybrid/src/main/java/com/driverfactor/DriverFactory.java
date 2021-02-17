package com.driverfactor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tl= new ThreadLocal<WebDriver>();
	
	public WebDriver initdriver(String browser) {
		if(browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tl.set(new FirefoxDriver());
			
		}
		else  if(browser.equals("chrome")) {
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-notifications");
				WebDriverManager.chromedriver().setup();
				tl.set(new ChromeDriver(opt));
			}
			else if(browser.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				tl.set(new EdgeDriver());
				
				}
			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			 return getDriver();
	}
	
public static synchronized WebDriver getDriver() {
	return tl.get();
	
}
}
