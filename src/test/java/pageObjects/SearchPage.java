package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
	
	//String productname;
	public String expectedproduct;
	
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

@FindBy(xpath = "//div[contains(@class,'alert-success')]")
WebElement successMessage;

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

public void addToCart() throws InterruptedException
{
 expectedproduct = getSearchString();
	for (WebElement searchResult:searchResults)
	{
		String productavailable =searchResult.getText();
		
		if (productavailable.equalsIgnoreCase(expectedproduct))
		{
			btnAddToCart.click();
			Thread.sleep(10000);
			//System.out.println("Product has been added to the cart successfully");
		}
		
		else
		{
			System.out.println ("Product Not Available");
		}
	}
	
}

public String getSuccessMessage()
{
    return successMessage.getText().trim();
}

public String successMsgverification()
{
	String message = getSuccessMessage();
	return message;
//    System.out.println("Extracted Message: " + message);
//
//    // Validating the message
//    if (message.contains("Success: You have added " + expectedproduct + " to your shopping cart!")) {
//        System.out.println("Product added to the cart successfully");
//    } else {
//        System.out.println("Product not added to the cart");
//    }
}

}
