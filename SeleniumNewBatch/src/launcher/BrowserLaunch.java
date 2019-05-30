package launcher;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserLaunch 
{

	public static void main(String[] args) 
	{
		WebDriver driver;
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.flipkart.com");
		
		//System.setProperty("webdriver.ie.driver","C:\\Users\\DELL\\Desktop\\Drivers\\IEDriverServer.exe" );
		driver=new InternetExplorerDriver();
		driver.get("https://www.snapdeal.com");
		
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\MicrosoftWebDriver.exe");
		driver=new EdgeDriver();
		driver.get("https://www.bestbuy.com");
	}

}
