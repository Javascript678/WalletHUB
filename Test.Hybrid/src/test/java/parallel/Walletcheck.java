package parallel;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.Assert;

import com.driverfactor.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import wallet.pages.ConfirmReview;
import wallet.pages.ProfileReviewConfirm;
import wallet.pages.RedirectPage;
import wallet.pages.ReviewsPage;
import wallet.pages.WalletLoginPage;

public class Walletcheck {
	private WalletLoginPage wallet; 
	private ConfigReader config;
	private  Properties prop;
	private ReviewsPage revie;
	private RedirectPage redp;
	private ProfileReviewConfirm prof;
	private ConfirmReview confirmrevw;
	private String text;
	 private String insuredvalu=null;
	@Given("login to WalletHub URL")
	public void login_to_wallet_hub_url() {
		wallet= new WalletLoginPage(DriverFactory.getDriver());
		config = new ConfigReader();
		 prop=config.init_prop();
		
		wallet.enterUrl(prop.getProperty("walletUrl"));
		wallet.enterLogin_details(prop.getProperty("walletuser"), prop.getProperty("walletpwd"));
	}

	@When("reviewstars are hovered and  clicked")
	public void reviewstars_are_hovered_and_clicked(io.cucumber.datatable.DataTable dataTable) {
		revie= new ReviewsPage(DriverFactory.getDriver());
		List<Map<String,String>>dat= dataTable.asMaps(String.class, String.class);
		for(int i=0;i<dat.size();i++) {
			text=dat.get(i).get("reviewstars");
			revie.clickonstar_hovered(text);
		}
			
		
	    
	}

	@When("Policy is selected")
	public void policy_is_selected(io.cucumber.datatable.DataTable dataTable) {
		redp= new RedirectPage(DriverFactory.getDriver());
		 List<Map<String, String>>mp=dataTable.asMaps(String.class, String.class);
		 for(int i=0;i<mp.size();i++) {
			 insuredvalu=mp.get(i).get("Policy");
			 redp.selectHealth_val(mp.get(i).get("Policy"));
		 }
		
	   }

	@When("review is updated and clicks on submit button")
	public void review_is_updated_and_clicks_on_submit_button() {
		redp.postReview(prop.getProperty("reviewText"));
	  }

	@Then("validate review posted and review stars on my profile")
	public void validate_review_posted_and_review_stars_on_my_profile() {
		prof= new ProfileReviewConfirm(DriverFactory.getDriver());
		confirmrevw= new ConfirmReview(DriverFactory.getDriver());
	    prof.Click_on_ProfileLink();
	   String Insurance_compny_returnflag=  prof.validate_stars_insurance();
	  String val[]=  Insurance_compny_returnflag.split(":");
	   //Assert.assertEquals(reviewtext, prop.get("reviewconfirmtext"));
	   Assert.assertEquals(val[2], true);
	   Assert.assertEquals(val[0], "Test Insurance Company");
	   Assert.assertEquals(val[1], insuredvalu);
	   
	   
	   
		 
	   
	}

}
