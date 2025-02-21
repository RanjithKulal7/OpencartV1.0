package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
//import org.apache.logging.log4j.LogManager;  //log4j
import org.apache.logging.log4j.Logger;      //log4j

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger; //Log4j
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException
	{
		FileReader file= new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		logger= LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		case "chrome": driver =new ChromeDriver(); break;
		case "edge": driver =new EdgeDriver(); break;
		case "firefox": driver =new FirefoxDriver(); break;
		default : System.out.println("Invalid browser name"); return;
		
		}
		
		//System.setProperty("webdriver.chrome.driver", "C://Chrome Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("AppURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public String randomString()
	{
		String generatedString= RandomStringUtils.randomAlphabetic(6);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String generatednumber=RandomStringUtils.randomAlphanumeric(10);
		return generatednumber;
	}
	
	public String randomAlphaNumeric()
	{
		String generatedString= RandomStringUtils.randomAlphabetic(6);
		String generatednumber=RandomStringUtils.randomAlphanumeric(10);
		return(generatedString+generatednumber);
	}

}
