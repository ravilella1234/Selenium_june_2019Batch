package launcher;

public class TC_003 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		
		loadData();
		
		launch("chromebrowser");
		
		navigateUrl("amazonurl");
		
		selectItem("amazonsearchdropdown_id","amazonvalue");
		
		type("amazonsearchtextbox_name","amazontext");
		
		click("amazonsearchbutton_xpath");
				
			
		//driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
		
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("harry potter");
		
		//driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")).click();
		
	}

	
}
