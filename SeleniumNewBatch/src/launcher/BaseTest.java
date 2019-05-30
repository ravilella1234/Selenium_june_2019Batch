package launcher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
			driver=new FirefoxDriver();
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
