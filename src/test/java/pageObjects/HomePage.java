package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath="//a[@title='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement lnkLogin;
	
	@FindBy (xpath="//input[@name='search']")
	WebElement searchBox;
	
	@FindBy (xpath="//button[@type='button' and @class='btn btn-default btn-lg']")
	WebElement btnSearch;
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
	public void enterInSearchBox(String productname)
	{
		searchBox.sendKeys(productname);
	}
	
	public void clickSearch()
	{
		btnSearch.click();
	}
	
}

