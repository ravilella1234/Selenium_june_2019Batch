package launcher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
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
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

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
			
			option.addArguments("--proxy-server=http://192.168.90.84:1234");
			
			
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
			
			//proxy servers
			profile.setPreference("network.proxy.type", 1);
			profile.setPreference("network.proxy.socks", "192.168.90.54");
			profile.setPreference("network.proxy.socks_port", 1744);
			
			option.setProfile(profile);
			
			
			driver=new FirefoxDriver(option);
			
		}
		else if(p.getProperty(browser).equalsIgnoreCase("ie")) 
		{
			//logs
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "D:\\IE.log");
			
			InternetExplorerOptions option=new InternetExplorerOptions();
			
			//proxy servers
			DesiredCapabilities cap=new DesiredCapabilities();
			
			String proxy="80.200.90.81:4444";
			Proxy p =new Proxy();
			p.setAutodetect(false);
			p.setProxyType(p.getProxyType());
			p.setSocksProxy(proxy);
			cap.setCapability(CapabilityType.PROXY, p);
			option.merge(cap);
			
			driver=new InternetExplorerDriver(option);
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
