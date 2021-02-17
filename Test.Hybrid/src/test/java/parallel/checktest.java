package parallel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.testng.Assert;

import com.driverfactor.DriverFactory;
import com.pages.LoginPage;
import com.pages.PostMessage;
import com.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class checktest {
	ConfigReader rea= new ConfigReader();
	Properties prop;
	 private LoginPage login= new LoginPage(DriverFactory.getDriver());
	 private PostMessage post= new PostMessage(DriverFactory.getDriver());
	 String postedtext=null;
	@Given("Launch browser and enter url")
	public void launch_browser_and_enter_url() {
		   prop= rea.init_prop();
		DriverFactory.getDriver().get("https://www.facebook.com");
	   
	}

	@When("Enter {string} and {string} click on enter")
	public void enter_and_click_on_enter(String uname, String pwd) {
		login.enterCredentials(uname,pwd);
		

	}

	@Then("Validate HomeIcon")
	public void validate_home_icon() {
		 boolean  iconpresent=login.validateHomeIcon();
		Assert.assertEquals(true, iconpresent);
		
	    // Write code here that turns the phrase above into concrete actions
	  
	}


	@When("Post the message")
	public void post_the_message(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		List<Map<String,String>> dat = dataTable.asMaps();
		for(int i=0;i<dat.size();i++) {
			postedtext=dat.get(i).get("message");
			post.writePost(dat.get(i).get("message"));
		}
		  String actualtext = post.gettext();
		Assert.assertEquals(postedtext, actualtext);
		
		
	    
	}

	
	
}
