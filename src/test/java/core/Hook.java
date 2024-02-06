package core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Hook extends Page
{
	 // login
  @FindBy(xpath = externalXpath.AmazonProjectXpath.signin)
  public static WebElement signin;
  
  @FindBy(xpath = externalXpath.AmazonProjectXpath.userid)
  public static WebElement userid;
  
  @FindBy(xpath = externalXpath.AmazonProjectXpath.ctnbtn)
  public static WebElement ctnbtn;
  
  @FindBy(xpath = externalXpath.AmazonProjectXpath.password)
  public static WebElement password;
  
  @FindBy(xpath = externalXpath.AmazonProjectXpath.submit)
  public static WebElement submit;
  
  @FindBy(xpath = externalXpath.AmazonProjectXpath.err1)
  public static WebElement err1;
  
  @FindBy(xpath = externalXpath.AmazonProjectXpath.err2)
  public static WebElement err2;
  
  // shop
  @FindBy(xpath = externalXpath.AmazonProjectXpath.searchbox)
  public static WebElement searchbox;
  
  @FindBy(xpath = externalXpath.AmazonProjectXpath.product)
  public static WebElement product;
  
  @FindBy(xpath = externalXpath.AmazonProjectXpath.addtokart)
  public static WebElement addtokart;
  
}
