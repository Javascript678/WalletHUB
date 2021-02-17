package wallet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import DriverActions.webActions;

public class ReviewsPage {
private WebDriver driver;
private webActions web;

public ReviewsPage(WebDriver driver) {
	this.driver= driver;
}
	
 private By reviewlink= By.xpath("//a/span[@class='nav-txt' and normalize-space()='Reviews']");
 private  By staridentify=null;
 private By starfill=null;


		 
public void clickreviewlink() {
	web = new webActions();
	web.pageLoadTimeOut(driver, 30);
	try {
	web.explicitWait(driver, driver.findElement(reviewlink), 20);
	web.click(driver, driver.findElement(reviewlink));
	}
	catch( StaleElementReferenceException e) {
		web.explicitWait(driver, driver.findElement(reviewlink), 30);
		web.click(driver, driver.findElement(reviewlink));
	}
	
	
}
public boolean houverstars(String index) {
	  staridentify= By.xpath("//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[local-name()='svg']["+index+"]/*[name()='g'][1]/*[name()='path'][1]");
	 boolean hovered= web.mouseover(driver, driver.findElement(staridentify));
	 
	return hovered;
}

public boolean validatestarsfilled(String index) {
	 starfill=By.xpath("//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[local-name()='svg']["+index+"]/*[name()='g'][1]/*[name()='path'][@stroke-miterlimit='10']");
	 boolean filled=web.isDisplayed(driver, driver.findElement(starfill));
	 return filled;
}

public void clickonstar_hovered(String index) {
	 clickreviewlink();
	 //web.scrollByVisibilityOfElement(driver, driver.findElement(staridentify));
	  boolean hoveredval=houverstars(index);
	 // boolean filledval= validatestarsfilled(index);
	  
	  if(houverstars(index)) {
		  web.moveToElementClick(driver, driver.findElement(staridentify));
		 // web.click(driver, driver.findElement(starfill));
	  }
	  
	
	
}

}

