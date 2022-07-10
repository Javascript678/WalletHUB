package wallet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverActions.webActions;

public class WalletLoginPage {
private WebDriver driver;
private webActions web;

public  WalletLoginPage(WebDriver driver) {
	this.driver=driver;
}
private By LoginLink= By.xpath("//span[normalize-space()='Login']");
private  By username=By.xpath("//input[@id='email']");
private By pwdpath= By.xpath("//input[@id='password']");
private By  LoginButton= By.xpath("//button[@class='btn blue center reg-tabs-bt touch-element-cl']");
private By Signuplink=By.xpath("//a[normalize-space()='Sign Up']");


public void enterUrl(String text) {
	driver.get(text);
}

public void enterLogin_details (String user, String pwd) {
	web= new webActions();
	web.click(driver, driver.findElement(LoginLink));
	web.implicitWait(driver, 30);
	web.type(driver.findElement(username), user);
	web.type(driver.findElement(pwdpath), pwd);
	web.click(driver, driver.findElement(LoginButton));
	
	
}

public boolean validateSignup_link() {
	 boolean val= web.isDisplayed(driver, driver.findElement(Signuplink));
	
	return val;
	
}


}
