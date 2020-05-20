package pfpack.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import pfpack.pages.LaunchPage;
import pfpack.tests.base.BaseTest;
import pfpack.util.Constants;


public class loginTest extends BaseTest {
	
	@Test
	public void testLogin() {
		
		
		
		etest = ereport.startTest("loginTest");
		
		etest.log(LogStatus.INFO, "LoginTest started");
		
		openBrowser(Constants.BROWSER_TYPE);
		
		LaunchPage launchPage = new LaunchPage(driver,etest);
		
		PageFactory.initElements(driver, launchPage);
		
		boolean loginStatus = launchPage.goToLoginPage();
		
		if(loginStatus) {
			
			reportPass("login test passed");
			
		}else {
			
			reportFail("login test failed");
		}
		
	}
	
	/*@AfterTest
	public void testClosure() {
		
		if(ereport!=null) {
			
			ereport.endTest(etest);
			ereport.flush();
			
		}
		
		if(driver!=null) {
			
			driver.quit();
		}
		
	}*/
	
	
	

}
