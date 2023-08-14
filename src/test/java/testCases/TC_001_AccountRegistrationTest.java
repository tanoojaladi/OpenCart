package testCases;
import pageObjects.*;


import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Sanity","Regression"})
	public void tes_account_registraion() {
		logger.debug("************Application Logs**********");  //debug logs return client server communication logs.Developers can understand.
		//manam test case fail avvataniki root cause yento teliyakapothe debug logs prnit chesthamu. Otherwise not recommended debug.
		logger.info("********** Started TC_001_AccountRegistrationTest***********");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked On MyAccount Link");
		hp.clickRegister();
		logger.info("Clicked On Register Link");
		AccountRegistrationPage ar=new AccountRegistrationPage(driver);
		
        ar.setFirstname(randomString());
        ar.setLasttname(randomString());
        ar.setEmail(randomString()+"@gmail.com");
       //ar.setEmail("tanuLovely@gmail.com");
        ar.setPassword("tanuLovely");
        logger.info("Entered Firstname,lastname,email,password");
		 ar.clickPolicy();
		 logger.info("Clicked On policy button");
         ar.clickContinue();
         logger.info("Clicked On continue button");
        
        
      Assert.assertEquals(ar.getConfirmationMsg(), "Your Account Has Been Created!");
      logger.info("Validate expected Message");
		}catch(Exception e) {
			logger.error(" Entered Into Catch Block Test Failed");
			Assert.fail();
		}
		
		logger.info("********** Finished TC_001_AccountRegistrationTest***********");
	}
	
	
}
