package wallet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverActions.webActions;

public class ConfirmReview {
	 private WebDriver driver;
	 private webActions web; 
	
public ConfirmReview(WebDriver driver) {
	this.driver=driver;
}
private By reviewconfirmText= By.xpath("//h4");
private By ContinueButton = By.xpath("//div[normalize-space()='Continue']");



public void validate() {
web.click(driver, driver.findElement(ContinueButton));
	
}
}