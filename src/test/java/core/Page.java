package core;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class Page 
{
	public static WebDriver driver = null;
	public static ExtentReports report = null;
	public static ExtentTest test = null;
	public SoftAssert softassert;
	
  @Parameters({"browser","url","reportname"})
  @BeforeTest
  public void beforeTest(String browser,String url,String reportname) 
  {
	  report = new ExtentReports( System.getProperty("user.dir")+"//src//test//java//reports//"+reportname+".html" );
	  test =  report.startTest(reportname);
	  
	  if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver(); // launch chrome
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			 driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
	    softassert = new SoftAssert();
		driver.navigate().to(url); // prefered -> go back and forward 
		
		PageFactory.initElements(driver, this); // for reading external xpath
		
		
		
		test.log(LogStatus.PASS, "opened browser "+browser+" with url "+url);
		
		// implicit wait
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
		
		driver.manage().window().maximize();
	
  }

  @AfterTest
  public void afterTest() 
  {
	 
	  driver.quit();
	  report.endTest(test);
	  report.flush();
	  softassert.assertAll();	
  }

}
