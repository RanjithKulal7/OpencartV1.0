package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	

	@Test (groups= {"Regression","Master"})
	public void verify_account_registration()
	{
		try {
		logger.info("Starting verify_account_registration");
		HomePage HomePage= new HomePage(driver);
		HomePage.clickMyAccount();
		logger.info("Clicked on My Account Link");
		HomePage.clickRegister();
		logger.info("Clicked on Register Link");
		AccountRegistrationPage accreg= new AccountRegistrationPage(driver);
		logger.info("Providing customer details");
		accreg.setFirstName(randomString());
		accreg.setLastName(randomString());
		accreg.setEmail(randomAlphaNumeric()+"@rkautotest7.com");
		accreg.setTelePhone(randomNumber());
		String password= randomAlphaNumeric();
		accreg.setPassword(password);
		accreg.setConfirmPassword(password);
		accreg.checkAgree();
		accreg.clickContinue();
		logger.info("Validating expected message");
		String confmsg=accreg.getConfirmationMsg();
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
	}

}
