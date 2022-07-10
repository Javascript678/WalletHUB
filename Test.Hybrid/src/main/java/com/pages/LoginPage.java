package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverActions.webActions;

public class LoginPage {
	
	private  WebDriver driver;
	
	private webActions web;
	public LoginPage( WebDriver driver) {
		this.driver=driver;
	}

	By emailpath=By.xpath(".//input[@type='text']");
	By valuepath= By.xpath(".//input[@type='password']");
	By loginpath= By.xpath(".//button[@type='submit']");
	By Homeicon=By.xpath(".//span[@class='l9j0dhe7']");
	


	public void enterCredentials(String value1, String value2) {
		web = new webActions();
		web.type(driver.findElement(emailpath), value1);
		web.type(driver.findElement(valuepath), value2);
		web.click(driver, driver.findElement(loginpath));
		
	}
	public boolean  validateHomeIcon() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		web.click(driver, driver.findElement(Homeicon));
			 return web.isDisplayed(driver, driver.findElement(Homeicon));
	}
}
