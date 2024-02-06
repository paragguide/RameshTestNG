package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import core.Hook;
import core.Page;

public class LoginTest extends Hook //Page
{
	public static boolean login = false;
  @Test
  public void login() 
  {
     //WebElement e =  driver.findElement(By.xpath("//*[text() = 'Hello, sign in']"));
	 //e.click() ;
	      // or..
	  signin.click();
	  userid.sendKeys("paragguide123@yahoo.co.in");
	    test.log(LogStatus.PASS, "Entered userid");
	  ctnbtn.click();
	      try {
	  System.err.println ( err1.getText() );
	    test.log(LogStatus.INFO, err1.getText());
	    utility.ScreenShot.takeScreenShot("UidError");
	    
	    softassert.assertEquals(err1.getText(), "invalid uid");
	      }
	      catch(Exception e)
	      {
	    	  test.log(LogStatus.INFO, "userid is valid");
	    	  
	    	  password.sendKeys("RMinfotech");
	    	  submit.click();
	    	      try {
	    	System.out.println(  err2.getText() );
	    	test.log(LogStatus.INFO, "wrong password");
	    	utility.ScreenShot.takeScreenShot("PwdError");
	    	      }
	    	      catch(Exception ee)
	    	      {
	    	    	  test.log(LogStatus.PASS, "logged in");
	    	    	  login = true;
	    	      }
	      }
  }
}
