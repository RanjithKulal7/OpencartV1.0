package loginDP;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDPTest {
	
	//Note: This test is only included in LoginDPTest.xml file
	
	WebDriver driver;
	@BeforeClass
	void setUp()
	{
		driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test (dataProvider="logindp1")
	void dpLogin(String email,String pwd) throws InterruptedException
	{
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(5000);
		boolean status =driver.findElement(By.xpath("//div[@id='content']/h2[text()='My Account']")).isDisplayed();
		if (status== true)
		{
			driver.findElement(By.xpath("//div[@class='list-group']/a[text()='Logout']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='list-group']/a[text()='Login']")).click();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider (name="logindp1",indices= {0,1,2,4,5,6})
	Object[][] loginData()
	{
		Object data[][]= {
				{"abc@gmail.com","test123"},
				{"xyz2@gmail.com","test023"},
				{"rkk@gmail.com","testtt123"},
				{"john3@gmail.com","test1233"},
				{"rohitrkautotest@gmail.com","rohitrkautotest@123"},
				{"manu7@gmail.com","test11233"}
				
	};
		return data;
	}
	
}
