package pfpack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pfpack.util.Constants;

public class LaunchPage {
	
	WebDriver driver = null;
	
	ExtentTest etest = null;
	
	@FindBy(className="zh-customers")
	public WebElement Customers;
	
	@FindBy(className="zh-enterprise")
	public WebElement Enterprise;
	
	@FindBy(className="zh-support")
	public WebElement Support;
	
	@FindBy(className="zh-login")
	public WebElement Login;
	
	@FindBy(className="zh-signup")
	public WebElement Signup;
	
	//constructor code
	public LaunchPage(WebDriver driver,ExtentTest etest) {
		
		this.driver = driver; //this. indicates instance variable and the one on the right side is argument to constructor
		this.etest = etest;
		
	}
	
	public boolean goToLoginPage() {
		
		driver.get(Constants.APP_URL);
		etest.log(LogStatus.INFO, "Application opened successfully");
		
		Login.click();
		
		etest.log(LogStatus.INFO,"Login option clicked");
		
		LoginPage loginPage = new LoginPage(driver,etest);
		PageFactory.initElements(driver, loginPage);
		boolean loginStatus = loginPage.doLogin();
		return loginStatus;
		
		
	}

}
