package settings;

import Utility.TestBase;
import org.testng.annotations.Test;

public class WorkflowRestore_testcases extends TestBase{

	@Test(priority=0)
	public void test_is_empty()
	{
		login.loginAs("automation.admin","Monday#223")
		.isSuccessfulLogin("automation admin")
		.getTitle();
	}
}
