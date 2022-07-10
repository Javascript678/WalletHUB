package wallet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverActions.webActions;

public class RedirectPage {
	private WebDriver driver;
	private webActions web;
	
	public RedirectPage(WebDriver driver) {
		this.driver=driver;
	}
	private By Healthselect= By.xpath("//span[@class='dropdown-placeholder' and contains(@style,'touch-action:') and normalize-space()='Select...']");
private By writeReview= By.xpath("//div[@class='android']/textarea");
private By SubmitButton= By.xpath("//div[normalize-space()='Submit']");


public void selectHealth_val(String text) {
	web= new webActions();
	web.pageLoadTimeOut(driver, 30);
	web.click(driver, driver.findElement(Healthselect));
	web.moveToElementClick(driver, driver.findElement(By.xpath("//ul[@class='dropdown-list ng-enter-element']/li[normalize-space()='"+text+"']")));
}
public void postReview(String text) {
	web.type(driver.findElement(writeReview),text);
	web.implicitWait(driver, 30);
	web.click(driver, driver.findElement(SubmitButton));
}

}
