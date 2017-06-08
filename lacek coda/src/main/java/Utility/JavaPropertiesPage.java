
package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class JavaPropertiesPage {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {

		Properties elementslocator=new Properties();
		elementslocator.load(new FileInputStream("elementslocator.properties"));

		String input=elementslocator.getProperty("camp_add_client");
		System.out.println("******* locator is: "+ input+" **********");

		String input2=elementslocator.getProperty("camp_add_client_search_field");
		System.out.println("******* locator is: "+ input2+" **********");


	}

	
}
