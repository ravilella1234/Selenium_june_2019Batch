package launcher;

import org.apache.log4j.Logger;

public class TC_003 extends BaseTest
{
	private static final Logger log=Logger.getLogger(TC_003.class.getName());

	public static void main(String[] args) throws Exception 
	{
		
		loadData();
		
		launch("chromebrowser");
		log.info("Opened the Browser :- " +p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to site :- " + p.getProperty("amazonurl"));
		
		selectItem("amazonsearchdropdown_id","amazonvalue");
		log.info("Selected the item :- "+ or.getProperty("amazonvalue") + "by using locator :- " + or.get("amazonsearchdropdown_id"));
		
		type("amazonsearchtextbox_id","amazontext");
		log.info("Entered the value :- " + or.getProperty("amazontext") + "by using locator :- "+ or.getProperty("amazonsearchtextbox_id"));
		
		click("amazonsearchbutton_xpath");
		log.info("Clicked on Amozon search Button by using the locator :- " + or.getProperty("amazonsearchbutton_xpath"));
	}
	
}
