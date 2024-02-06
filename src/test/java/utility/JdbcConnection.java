package utility;

import java.sql.*;

import com.relevantcodes.extentreports.LogStatus;

import core.Page;

public class JdbcConnection extends Page
{
	public static Connection con = null;
	public static ResultSet rs = null;
	
	public static void openWBConnection(String wbname,String sheetname) throws Exception
	{
		Class.forName("com.googlecode.sqlsheet.Driver"); // register driver
	    String wbpath = System.getProperty("user.dir")+"//src//test//java//excel//"+wbname+".xlsx";
		con = DriverManager.getConnection("jdbc:xls:file:"+wbpath);
	System.out.println("connected to wb..");
	Statement stm = con.createStatement();
	rs = stm.executeQuery("select * from "+sheetname);
	test.log(LogStatus.INFO, "connected to wb..");
	}

}
