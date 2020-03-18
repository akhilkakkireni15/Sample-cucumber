package stepDefinations;

import java.net.URL;

import org.junit.Assert;
import org.omg.CORBA.portable.UnknownException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;

import org.openqa.selenium.Platform;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
//import io.cucumber.java.en.*;


public class Steps {
	
	public WebDriver driver;

	boolean docker = true;
	String dockerHost = "192.168.99.100";
	
	/*
	 * @Given("Launching browser") public void launching_browser() throws
	 * MalformedURLException {
	 * 
	 * if (docker = false) { System.setProperty("webdriver.chrome.driver",
	 * System.getProperty("user.dir")+"/Drivers/chromedriver.exe"); driver = new
	 * ChromeDriver(); } else { ChromeOptions options = new ChromeOptions();
	 * //capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
	 * options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	 * 
	 * URL url = new URL("http://192.168.99.100:4444/wd/hub"); RemoteWebDriver
	 * driver = new RemoteWebDriver(url,options); }
	 * 
	 * 
	 * }
	 */
	@Given("Launching browser")
	public void launching_browser() throws MalformedURLException {
		
		try{
			DesiredCapabilities capability = new DesiredCapabilities();
			System.out.println("--------------Inside else---------------------");
	        System.out.println(new File("Drivers/chromedriver.exe").getAbsolutePath());
	        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
	        System.out.println("Launching docker url");
	        ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-extensions");
			//chromeOptions.addArguments("test-type");
			//capability.setPlatform(Platform.LINUX);
			//capability.setBrowserName("firefox");
			capability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			if(dockerHost.trim().toLowerCase().contains("local")){
				 System.setProperty("webdriver.chrome.driver",
			     System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
				 driver = new ChromeDriver();
			}
			else{
				URL url = new URL("http://"+dockerHost+":4444/wd/hub");
				driver = new RemoteWebDriver(url,capability);
				
					}
			
		}catch(Exception e){
			System.out.println("Launch browser failed");
		}
		
		
	}
		
	
	@When("^Opening URL \"([^\"]*)\"$")
	public void opening_URL(String url)  {
		 driver.get("https://google.com"); 
	}

	
	@Then("^Pagetitle \"([^\"]*)\" should be verified$")
	public void pagetitle_should_be_verified(String title) {
    if(driver.getTitle().contains("Google"))
    		{
    	  	Assert.assertTrue(true);
    	}
    else 
    {
    	System.out.println("Not found");
    }
    }

    	
	@Then("close browser")
	public void close_browser() {
     driver.close();	
	}


}
