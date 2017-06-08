package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LocatorsProperties {

	public static void main(String[] args) {
		Properties elementlocators=new Properties();
		try {
			elementlocators.load(new FileInputStream("C:\\Users\\prince.kabuika\\Desktop\\repositories\\mms\\MMS\\MMS webelements\\elementslocator.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String input=elementlocators.getProperty("camp_add_client");
		System.out.println("******* locator is: "+ input+" **********");

		String input2=elementlocators.getProperty("camp_add_client_search_field");
		System.out.println("******* locator is : "+ input2+" **********");

	}

}
