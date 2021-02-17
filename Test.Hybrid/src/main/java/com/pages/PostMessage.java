package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverActions.webActions;

public class PostMessage {
private WebDriver driver;
private webActions web;


public  PostMessage(WebDriver driver) {
	this.driver=driver;
}

By postpath= By.xpath("//div[@class='m9osqain a5q79mjw jm1wdb64 k4urcfbm']");
By posttextpath=By.xpath("//div[@class='l9j0dhe7 tkr6xdv7']//div[@data-contents='true']//div[1]//div[1]");
By postbutton= By.xpath("//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5'][normalize-space()='Post']");
By postcontextcheckpath= By.xpath("//div[contains(@dir,'auto')]//child::div[@class='kvgmc6g5 cxmmr5t8 oygrvhab hcukyx3x c1et5uql']");
public void writePost(String text) {
	web= new webActions();
	web.implicitWait(driver, 20);
	web.click(driver, driver.findElement(postpath));
	web.implicitWait(driver, 30);
	//web.click(driver, driver.findElement(posttextpath));
	web.type(driver.findElement(posttextpath),text);
	web.implicitWait(driver, 20);
	web.click(driver, driver.findElement(postbutton));
	web.implicitWait(driver, 30);

	
}

public String  gettext() {
	
	 return web.gettext(driver, postcontextcheckpath);
}

}
