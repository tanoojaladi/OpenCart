package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	
@Test(groups= {"Sanity"})
public void test_login() {
	try {
	logger.info("************TC_002_LoginTest started***********");
	
	HomePage hp=new HomePage(driver);
	hp.clickMyAccount();
	logger.info("clicked on MyAccount");
	hp.clickLogin();
	logger.info("clicked on Login");
	
	LoginPage lp=new LoginPage(driver);
	lp.setemailAddress(rb.getString("email"));
	logger.info("Entered Email");
	lp.setPassword(rb.getString("password"));
	logger.info("Entered Password");
	lp.clickLogin();
	logger.info("clicked on  login");
	MyAccountPage ap=new MyAccountPage(driver);
	logger.info("validating My account page exists or not");
	
	Assert.assertEquals(ap.isMyAccountPageExists(), true);
	logger.info("validated and Test passed");
	
	}catch(Exception e) {
		logger.info("test failed and entered into catch block");
		System.out.println(e.getMessage());
		Assert.fail();
	}
	logger.info("************TC_002_LoginTest Ended***********");
}
}
