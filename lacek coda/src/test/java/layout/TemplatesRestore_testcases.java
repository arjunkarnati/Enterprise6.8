package layout;

import Utility.TestBase;
import org.testng.annotations.Test;

public class TemplatesRestore_testcases extends TestBase{

	@Test(priority=0)
	public void validate_template_page()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.clickTemplates()
		.getTitle()
		.logout();		
	}

}

