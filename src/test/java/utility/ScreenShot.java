package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.LogStatus;

import core.Page;

public class ScreenShot extends Page
{
	
	public static void takeScreenShot(String scrname) throws Exception
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File f = ts.getScreenshotAs(OutputType.FILE); // store in tmp location
		String scrpath = System.getProperty("user.dir")+"//src//test//java//screenshot//"+scrname+".jpg";
		FileUtils.copyFile(f, new File(scrpath));
			
		test.log(LogStatus.PASS, "taken screen shot..");
	}

}
