package wallet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverActions.webActions;

public class ProfileReviewConfirm {
	private WebDriver driver;
	private webActions web ;
	public ProfileReviewConfirm(WebDriver driver) {
		this.driver=driver;
		
	}
	
	private By UserLink= By.xpath("//div[@class='brgm-button brgm-user brgm-list-box']//span[@class='brgm-list-title']");
	private By ProfileLink = By.xpath("//a[normalize-space()='Profile']");
	private By StarReview= By.xpath("//review-star[@class='inst-rating rvs-plain rvs-svg']//div[@class='rating-box-wrapper']//*[local-name()='svg'][4]/*[name()='g'][1]/*[name()='path'][@stroke-miterlimit='10']");
	private By Insuranceselected = By.xpath("//p[@class='pr-rec-type']");
	private By CompanyName= By.xpath("//div[@class='pr-rec-texts-container']/a");
	

	
	public void Click_on_ProfileLink() {
		driver.get("https://wallethub.com/profile/test-insurance-company/");
		web.moveToElement(driver, driver.findElement(UserLink));
		web.implicitWait(driver, 10);
		web.moveToElementClick(driver, driver.findElement(ProfileLink));
		
	}
	
	public String validate_stars_insurance() {
		web.pageLoadTimeOut(driver, 20);
		web.scrollByVisibilityOfElement(driver, driver.findElement(StarReview));
		 boolean value= web.isDisplayed(driver, driver.findElement(StarReview));
		String InsName=web.gettext(driver,Insuranceselected);
		String CompnyName= web.gettext(driver, CompanyName);
		
		return InsName+ ":" + CompnyName+":"+String.valueOf(value);
		
	}
}
