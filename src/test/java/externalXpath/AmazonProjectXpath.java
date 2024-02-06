package externalXpath;

public class AmazonProjectXpath 
{
	// login
public static final String signin = "//*[text() = 'Hello, sign in']";
public static final String userid = "//*[@id=\"ap_email\"]";
public static final String ctnbtn = "//*[@id=\"continue\"]";
public static final String err1 = "//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span";
public static final String password = "//*[@id=\"ap_password\"]";
public static final String submit = "//*[@id=\"signInSubmit\"]";
public static final String err2 = "//*[@id=\"auth-error-message-box\"]/div/div/ul/li/span";

 // shop
public static final String searchbox = "//*[@id=\"twotabsearchtextbox\"]";
public static final String product = "//*[text() = 'POCO C51 (Royal Blue, 6GB RAM, 128GB Storage)']";
public static final String addtokart = "//*[@id=\"add-to-cart-button\"]";
}
