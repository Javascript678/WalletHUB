package parallel;




import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(
        features = {"src/test/resources/com/parallel"},
        glue = {"parallel"},
        monochrome=true,   
        plugin = {
                "json:target/cucumber.json",
                "rerun:target/cucumber-reports/rerun.txt",
                "html:target/site/cucumber-pretty.html"}
        )
public class Runner extends AbstractTestNGCucumberTests {
	
	@DataProvider(parallel=true)
	public Object [][] scenarios(){
		return super.scenarios();
		
	}
    	
}

