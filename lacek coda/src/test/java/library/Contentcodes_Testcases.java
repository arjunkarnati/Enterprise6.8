package library;

import Utility.TestBase;
import org.testng.annotations.Test;

public class Contentcodes_Testcases extends TestBase {

	
	@Test(priority=0)
	public void crerate_content_code()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickonContentcodes()
		.clickAddcontentbutton()
		.selectClient("Enterprise Holdings Inc.")
		.selectType("HTML Source Code")
		.addCode("ARJUN-CONTENT")
		.addDescription("Automation_test")
		.clicksubmitbuttom()
		.getTitle()
		.logout();
		
	}
	
	
	
	
	
}
