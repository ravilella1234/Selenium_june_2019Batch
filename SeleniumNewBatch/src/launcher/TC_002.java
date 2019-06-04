package launcher;

public class TC_002 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		loadData();
		
		launch("firefoxbrowser");
		
		navigateUrl("iciciurl");

	}

}
