package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_AddProductToCart extends BaseClass {
	@Test (groups= {"Sanity","Master"})
	public void addProductToCart() throws InterruptedException {
		try {
		String productrequired="iPhone";
		HomePage hp= new HomePage(driver);
		hp.enterInSearchBox(productrequired);
		hp.clickSearch();
		SearchPage sp= new SearchPage (driver);
		sp.getAllSearchResults();
		sp.addToCart();
		String currentSuccessMsg=sp.successMsgverification();
		String expectedSuccessMsg= "Success: You have added " + productrequired + " to your shopping cart!";
		//String expectedSuccessMsg= "Successsss: You have added " + productrequired + " to your shopping cart!";
		//Assert.assertEquals(currentSuccessMsg, expectedSuccessMsg);
		Assert.assertTrue(currentSuccessMsg.contains(expectedSuccessMsg));
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}

}
