package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
	
	String productname;
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy (xpath="//input[@name='search']")
WebElement searchstring;
		
@FindBy (xpath="//div[@class='product-thumb']//following::div[@class='caption']/h4/a")
List <WebElement> searchResults;

@FindBy (xpath="//div[@class='product-thumb']//following::div[@class='button-group']//button[1]")
WebElement btnAddToCart;

public String getSearchString()
{
	String SearchString =searchstring.getDomProperty("value");
	return SearchString;
}

public void getAllSearchResults()
{
	for (WebElement searchResult:searchResults)
	{
		System.out.println(searchResult.getText());
	}
}

public void addToCart()
{
	String expectedproduct = getSearchString();
	for (WebElement searchResult:searchResults)
	{
		String productavailable =searchResult.getText();
		
		if (productavailable.equalsIgnoreCase(expectedproduct))
		{
			btnAddToCart.click();
			System.out.println("Product has been added to the cart successfully");
		}
		
		else
		{
			System.out.println ("Product Not Available");
		}
	}
	
}

}
