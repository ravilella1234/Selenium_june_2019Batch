package launcher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

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
			driver=new ChromeDriver();
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
			driver=new InternetExplorerDriver();
		}
		else if(p.getProperty(browser).equalsIgnoreCase("edge")) 
		{
			driver=new EdgeDriver();
		}
		
	}
	
	public static void navigateUrl(String url)
	{
		driver.get(p.getProperty(url));
	}
}
