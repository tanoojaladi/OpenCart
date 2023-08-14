package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass {

	//because this logindata ane data provider  ni mana different package lo create chesamu kabbati.
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void test_loginDataDrivenTest(String email, String pwd ,String expected) {
		try {
		logger.info("*************TC_003_LoginDataDrivenTest Started*****************");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on MyAccount");
		hp.clickLogin();
		logger.info("clicked on Login");
		LoginPage lp=new LoginPage(driver);
		lp.setemailAddress(email);
		logger.info("Entered Email");
		lp.setPassword(pwd);
		logger.info("Entered Password");
		lp.clickLogin();
		logger.info("clicked on  login");
		
		MyAccountPage ap=new MyAccountPage(driver);
		
		boolean targetPage=ap.isMyAccountPageExists();
		
		if(expected.equalsIgnoreCase("valid")) {
			
			if(targetPage==true) {
				
				Assert.assertTrue(true);
				ap.clickLogout();
				
			}else {
				Assert.fail();
				//Assert.assertTrue(false);
			}
			
			
		}if(expected.equalsIgnoreCase("invalid")) {
			if(targetPage==true) {
				ap.clickLogout();
				Assert.fail();
				
			}else {
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			logger.info("Entered into catch block Test failed");
			Assert.fail();
		}
		logger.info("*************TC_003_LoginDataDrivenTest Ended*****************");
		
	}	
}
