package testcases;

import java.sql.ResultSetMetaData;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import core.Hook;

public class Shop 
{
  @Test(dataProvider="getData")
  public void addtokart(String product,String xpath) throws Exception 
  {
	  if(LoginTest.login == true)
	  {
		  Hook.searchbox.clear();
		  
		  Hook.searchbox.sendKeys(product);
		  
		  Actions a = new Actions(Hook.driver);
		  a.sendKeys(Keys.ENTER).perform();
		  
		    utility.ScreenShot.takeScreenShot("SearchResult");
		  Hook.test.log(LogStatus.PASS, "searching "+product);
		  
		   Hook.product.click();
		   
		  Thread.sleep(4000);
		 Set <String> tabs = Hook.driver.getWindowHandles();
		 
		 Iterator <String> it =  tabs.iterator();
		 String searchresulttab = it.next();
		 String producttab = it.next();
		 Hook.driver.switchTo().window(producttab);
		 Hook.addtokart.click();
		   utility.ScreenShot.takeScreenShot("ProductAdded");
	  }
  }
  
  @DataProvider
  public Object[][] getData() throws Exception
  {
	  utility.JdbcConnection.openWBConnection("AmazonLogin", "Sheet2");
	  Object data[][] = {};
	     
	  if(utility.JdbcConnection.rs != null)
	  {
	  ResultSetMetaData rsmt=utility.JdbcConnection.rs.getMetaData();
	  int columncount=rsmt.getColumnCount();

	  utility.JdbcConnection.rs.last(); // place record pointer on last record
	  int rowcount=utility.JdbcConnection.rs.getRow(); // fetch position of last record

	  System.out.println(columncount+" , "+rowcount);
	  utility.JdbcConnection.rs.beforeFirst(); // reset

	  data = new Object[rowcount][columncount]; //-> size of array 
	  			
	  for(int rowNum = 1 ; rowNum <= rowcount ; rowNum++)
	     { 
	  				
	  for(int colNum=1 ; colNum<= columncount; colNum++)
	        {
		  utility.JdbcConnection.rs.absolute(rowNum); // point to row  
	  	Object data1= utility.JdbcConnection.rs.getObject(colNum); // getting values from excel
	  	
	  		data[rowNum-1][colNum-1]= data1 ; //adding table data in  array , array starts from 0
	  				}
	  			}
	  }

	  
	  return data;
  }
}
