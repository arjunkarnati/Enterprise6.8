package Utility;

import java.util.ArrayList;
import org.testng.TestNG;

public class fails extends TestBase {

	public fails() {

		// Create object of TestNG Class
		TestNG runner=new TestNG();
		// Create a list of String 
		ArrayList<String> suitefiles=new ArrayList<String>();		
		// Add xml file which you have to execute	
		suitefiles.add("H:\\VM.projects\\project4.13\\lacek coda\\test-output\\testng-failed.xml");
		//set xml file for execution
		runner.setTestSuites(suitefiles);		
		// finally execute the runner using run method
		runner.run();
	}
}


