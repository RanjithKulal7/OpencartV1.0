package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_AddProductToCart extends BaseClass {
	@Test (groups= {"Sanity","Master"})
	public void addProductToCart() {
		HomePage hp= new HomePage(driver);
		hp.enterInSearchBox("Iphone");
		hp.clickSearch();
		SearchPage sp= new SearchPage (driver);
		sp.getAllSearchResults();
		sp.addToCart();
		
	}

}
