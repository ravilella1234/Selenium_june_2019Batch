package verifications;

import com.relevantcodes.extentreports.LogStatus;

import launcher.BaseTest;

public class TC_006 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		test=report.startTest("TC_006");
		
		loadData();
		test.log(LogStatus.INFO, "loading the cofig files....");
		
		launch("chromebrowser");
		test.log(LogStatus.INFO, "Opened the Browser :- " +p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to site :- " + p.getProperty("amazonurl"));
		
		
		 if(!verifyTitle("amazontitle"))
			reportFail("Both the titles are not equal...");
		 else
			 reportPass("Both the titles are  equal...");
		 
		 
		 if(!verifyText("amazonbasics_linktext","amazonbasics"))
			 reportFail("Both the links are not equal...");
		 else
			 reportPass("Both the links are  equal...");
		 
		
		
		
		report.endTest(test);
		report.flush();

	}

	

	

	

}
