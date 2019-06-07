package launcher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

public class BaseTest 
{
	public static WebDriver driver;
	//public static String configPath="./config.properties";
	public static String configPath=System.getProperty("user.dir")+"//config.properties";
	public static Properties p;
	
	
	public static void loadData() throws Exception
	{
		FileInputStream fis=new FileInputStream(configPath);
		p=new Properties();
		p.load(fis);
	}
	
	
	public static void launch(String browser)
	{
		if(p.getProperty(browser).equalsIgnoreCase("CHROME"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Drivers\\chromedriver.exe");
			
			//logs
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
			
			ChromeOptions option=new ChromeOptions();
			
			//PageLoad Strategy
			option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			
			//user defined profile
			option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
			
			//Browser Notifications
			option.addArguments("--disable-notifications");
			option.addArguments("--disable-infobars");
			option.addArguments("--start-maximized");
			
			
			driver=new ChromeDriver(option);
		}
		else if(p.getProperty(browser).equalsIgnoreCase("firefox")) 
		{
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "d://abcd.txt");
			
			
			FirefoxOptions option=new FirefoxOptions();
			option.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			
			
			ProfilesIni p=new ProfilesIni();
			FirefoxProfile profile = p.getProfile("morningprofile1");
			
			
			//notifications
			profile.setPreference("dom.webnotifications.enabled", false);
			
			option.setProfile(profile);
			
	
			driver=new FirefoxDriver(option);
			
		}
		else if(p.getProperty(browser).equalsIgnoreCase("ie")) 
		{
			//logs
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "D:\\IE.log");
			
			driver=new InternetExplorerDriver();
		}
		else if(p.getProperty(browser).equalsIgnoreCase("edge")) 
		{
			//logs
			System.setProperty(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY, "null");
			
			driver=new EdgeDriver();
		}
		
	}
	
	public static void navigateUrl(String url)
	{
		driver.get(p.getProperty(url));
	}
}
