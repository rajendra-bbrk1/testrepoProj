package pfpack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class HomePage {
	
	WebDriver driver = null;
	ExtentTest etest = null;
	
	@FindBy(css="[class^='zicon-apps-chat']")
	public WebElement cliqOption;
	
	@FindBy(css="[class^='zicon-apps-crm']")
	public WebElement crmOption;
	
	@FindBy(css="[class^='zicon-apps-salesiq']")
	public WebElement salesIQOption;
	
	//Constructor code
	
	public HomePage(WebDriver driver,ExtentTest etest) {
		
		this.driver = driver;
		this.etest = etest;
		
	}
	
	public boolean verifyDisplayofHomePage() {
		
		boolean displayedStatus = crmOption.isDisplayed();
		
		if(displayedStatus) {
			
			return true;
		}else {
			
			return false;
		}
		
	}

}
