package launcher;

public class TC_001 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		loadData();
		
		launch("chromebrowser");
		
		navigateUrl("bestbuyurl");

	}

}
