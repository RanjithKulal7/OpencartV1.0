package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC003_Search extends BaseClass{
	
	@Test (groups= {"Sanity","Master"})
	public void getAllSearchResults() {
		HomePage hp= new HomePage(driver);
		hp.enterInSearchBox("I");
		hp.clickSearch();
		SearchPage sp= new SearchPage (driver);
		sp.getAllSearchResults();
		
	}

	
}
