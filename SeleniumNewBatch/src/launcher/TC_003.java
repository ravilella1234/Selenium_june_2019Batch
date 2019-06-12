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
		
		type("amazonsearchtextbox_id","amazontext");
		
		click("amazonsearchbutton_xpath");
						
	}
	
}
