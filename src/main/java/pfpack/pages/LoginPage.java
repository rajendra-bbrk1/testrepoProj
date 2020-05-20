package pfpack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pfpack.util.Constants;

public class LoginPage {
	
	WebDriver driver = null;
	ExtentTest etest = null;
	
	@FindBy(id="login_id")
	public WebElement EmailField;
	
	@FindBy(xpath="//form[@id='login']//button[@id='nextbtn']")
	public WebElement Nextbutton;
	
	@FindBy(id="password")
	public WebElement PasswordField;
	
	@FindBy(xpath="//form[@id='login']//button[@id='nextbtn']")
	public WebElement SignInButton;
	
	//constructor code
	public LoginPage(WebDriver driver, ExtentTest etest) {
		
		this.driver = driver;
		this.etest = etest;
		
	}
	
	public boolean doLogin() {
		
		EmailField.sendKeys(Constants.USERNAME);
		
		etest.log(LogStatus.INFO,"Username entered in the Email field");
		Nextbutton.click();
		etest.log(LogStatus.INFO,"Clicked on the next button");
		PasswordField.sendKeys(Constants.PASSWORD);
		etest.log(LogStatus.INFO, "Password entered in the Password field");
		SignInButton.click();
		etest.log(LogStatus.INFO,"Clicked on the Sign In button");
		
		HomePage homePage = new HomePage(driver,etest);
		
		PageFactory.initElements(driver,homePage);
		
		boolean loginStatus = homePage.verifyDisplayofHomePage();
		
		return loginStatus;
		
	}

}
