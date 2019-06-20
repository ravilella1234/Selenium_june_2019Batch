package verifications;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import launcher.BaseTest;

public class TC_005 extends BaseTest
{
	private static final Logger log=Logger.getLogger(TC_005.class.getName());

	public static void main(String[] args) throws Exception 
	{
		
		loadData();
		
		launch("chromebrowser");
		log.info("Opened the Browser :- " +p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to site :- " + p.getProperty("amazonurl"));
		
		String actualtitle = driver.getTitle();
		String expectedtitle="online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
		/*//if(actualtitle.equals(expectedtitle))
		//if(actualtitle.equalsIgnoreCase(expectedtitle))
		//if(actualtitle.contains(expectedtitle))
		if(actualtitle.contentEquals(expectedtitle))
			System.out.println("Both titles are equal...");
		else
			System.out.println("Both titles are not equal...");*/
		
		
		//Assert.assertEquals(actualtitle, expectedtitle);
		
		//Assert.assertTrue(actualtitle.equals(expectedtitle));
		
		//Assert.assertTrue(actualtitle.equals(expectedtitle), "Both titles are not equal...");
		
		SoftAssert s=new SoftAssert();
		//s.assertEquals(actualtitle, expectedtitle);
		
		s.assertTrue(actualtitle.equals(expectedtitle), "Both titles are not equal...");
		
		s.assertTrue(false, "error1");
		
		s.assertTrue(false, "error2");
		
		s.assertTrue(true, "error3");
		
		s.assertTrue(false, "error4");
		
		
		String actuallink = driver.findElement(By.linkText("AmazonBasics")).getAttribute("innerHTML");
		System.out.println("Actual Links :" + actuallink );
		String expectedlink="amazonBasics";
		System.out.println("Expected Links :" + expectedlink );
		
		if(actuallink.equals(expectedlink))
			System.out.println("Both links are equal...");
		else
			System.out.println("Both links are not equal...");
		
		
		selectItem("amazonsearchdropdown_id","amazonvalue");
		log.info("Selected the item :- "+ or.getProperty("amazonvalue") + "by using locator :- " + or.get("amazonsearchdropdown_id"));
		
		type("amazonsearchtextbox_id","amazontext");
		log.info("Entered the value :- " + or.getProperty("amazontext") + "by using locator :- "+ or.getProperty("amazonsearchtextbox_id"));
		
		
		String actualtext = driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");
		System.out.println("Actual Text : " + actualtext);
		
		click("amazonsearchbutton_xpath");
		log.info("Clicked on Amozon search Button by using the locator :- " + or.getProperty("amazonsearchbutton_xpath"));
		
		
		s.assertAll();
	}
	
}
