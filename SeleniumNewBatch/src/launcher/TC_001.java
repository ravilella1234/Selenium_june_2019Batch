package launcher;

import org.openqa.selenium.By;

public class TC_001 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		loadData();
		
		launch("chromebrowser");
		
		navigateUrl("hdfcurl");
		
		driver.manage().window().maximize();
		
		/*String title = driver.getTitle();
		System.out.println(title);
		
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		driver.manage().deleteAllCookies();
		
		driver.navigate().back();
		
		Thread.sleep(3000);
		
		driver.navigate().forward();
		
		Thread.sleep(3000);
		
		driver.navigate().refresh();*/
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[@class='popupCloseButton']")).click();
		
		driver.findElement(By.id("loginsubmit")).click();
		
		driver.close();
		
		//driver.quit();


	}

}
