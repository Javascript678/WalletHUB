package parallel;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.driverfactor.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class AppHook {
private DriverFactory driverfactory;
private ConfigReader config;
Properties prop;
 private WebDriver driver;
@Before(order=0)
public void getproperty() {
	config= new ConfigReader();
	 prop= config.init_prop();
}
@Before(order=1)
	public void loaddriver() {
	 String browservalue=prop.getProperty("browser");
	 System.out.println(browservalue);
	 driverfactory= new DriverFactory();
	 driver = driverfactory.initdriver(browservalue);
	 
}
@After(order=0)
public void quitbrowse() {
driver.quit();
}

@After(order=1)
public void tearDown(Scenario sc) {
	if(sc.isFailed()) {
		 String filename=sc.getName().replaceAll(" ", "_");
		 byte[] path=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		 sc.attach(path, "image/jpg", filename);
	}
	
}
}
