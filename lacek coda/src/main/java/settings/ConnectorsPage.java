package settings;

import java.security.InvalidParameterException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Utility.PageBase;
import library.MessagesAddPage;
import library.VariablesAddPage;



public class ConnectorsPage extends PageBase{


	public ConnectorsPage(WebDriver driver) 
	{
		super(driver);
	}

	//reload workflow page
	public ConnectorsPage reloadPage()
	{
		driver.findElement(By.id("reload")).click();

		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("CODA - Connectors"));
		//return workflow page
		return new ConnectorsPage(driver);
	}

	//clear the filter textbox in workflow page
	public ConnectorsPage clearFilter()
	{
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.ENTER);

		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath("//input[@type='search']")).getText().isEmpty());
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("MMS - Connectors"));

		//return workflow page
		return new ConnectorsPage(driver);
	}

	//add a filter criteria in workflow page 
	public ConnectorsPage setFilter(String filtercriteria)
	{
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(filtercriteria);

		System.out.println(driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[1]")).getText());

		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("MMS - Connectors"));
		//return workflow page
		return new ConnectorsPage(driver);
	}

	//open workflow archive page
	public ConnectorsArchivePage clickArchiveButton()
	{
		driver.findElement(By.cssSelector("a[href*='/series/archive']")).click();

		//assert and verify
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("MMS - Connectors - Archive"));
		//return workflow archive page
		return new ConnectorsArchivePage(driver);
	}

	//click print & view
	public ConnectorsPage clickViewPrintView()
	{
		driver.findElement(By.id("ToolTables_datatable_1")).click();

		//assert and verify
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='datatable_wrapper']/div[3]")).isDisplayed());
		//return workflow page
		return new ConnectorsPage(driver);
	}

	//display all
	public ConnectorsPage displayAll()

	{
		driver.findElement(By.xpath(".//*[@id='s2id_autogen1']/a/span[2]/b")).click();
		sleep();
		driver.findElement(By.xpath("//input[@id='s2id_autogen2_search']")).sendKeys("All");
		driver.findElement(By.xpath("//input[@id='s2id_autogen2_search']")).sendKeys(Keys.ENTER);
		sleep();

		//return connector page
		return new ConnectorsPage(driver);
	}

	//display 10,25,50,100
	//	public ConnectorsPage display(int number )
	//	{	
	//		int[] numbers = new int[4];
	//		numbers[0]=10;
	//		numbers[1]=25;
	//		numbers[2]=50;
	//		numbers[3]=100;
	//
	//		{
	//			driver.findElement(By.xpath(".//*[@id='s2id_autogen1']/a/span[2]/b")).click();
	//			sleep();
	//			driver.findElement(By.xpath("//input[@id='s2id_autogen2_search']")).sendKeys(String.valueOf(number));
	//			driver.findElement(By.xpath("//input[@id='s2id_autogen2_search']")).sendKeys(Keys.ENTER);
	//			sleep();
	//
	//			if (number!=numbers[0] || number!=numbers[1] || number!=numbers[2] || number!=numbers[3]) 
	//			{
	//				throw new InvalidParameterException
	//				("you cannot display "+number +" number should be 10, 25, 50, 100 or All .");
	//			}
	//		}
	//		//return connector page
	//		return new ConnectorsPage(driver);
	//	}

	//edit a workflow
	public ConnectorsEditPage editConnector(String connectorname)
	{
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(connectorname);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		switch(connectorname)
		{
		case "arjun_connector":
		{
			driver.findElement(By.xpath("//i[@class='fa fa-pencil-square-o']")).click();
			break;
		}
		case "edit_conn_test_1":
		{
			driver.findElement(By.xpath("//i[@class='fa fa-pencil-square-o']")).click();
			sleep();

			break;
		}	
		case "edit_conn_test_010":
		{
			driver.findElement(By.xpath("//i[@class='fa fa-pencil-square-o']")).click();
			sleep();

			break;
		}
		case "Exact Target (Dev) - Draft":
		{
			driver.findElement(By.cssSelector("a[href*='/connector/edit/8']")).click();
			sleep();

			break;
		}
		default: 
		{
			throw new InvalidParameterException
			("connector "+connectorname +" cannot be edited, ref automation doc connector page.");

		}

		}
		return new ConnectorsEditPage(driver);
	}

	//verify and validate brands
	public ConnectorsPage validateBrand(String connectorname, int numberofbrands)

	{		
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(connectorname);
		sleep();

		int iCount = 0;
		iCount = driver.findElements(By.xpath("//table[@id='datatable']/tbody/tr/td[2]/span")).size();
		System.out.println(iCount);

		for (int total = 0; total < iCount; total++) 
		{
			//driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[2]/span")).getText();
		}

		//assert and verify
		Assert.assertEquals(numberofbrands, iCount);

		return new ConnectorsPage(driver);
	}


	//verify and validate program
	public ConnectorsPage validateProgram(String connectorname,int numberofprograms)

	{		
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(connectorname);
		sleep();

		int iCount = 0;
		iCount = driver.findElements(By.xpath(".//*[@id='datatable']/tbody/tr/td[3]/span")).size();
		System.out.println(iCount);                   

		for (int total = 0; total < iCount; total++) 
		{
			//driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[2]")).getText();
		}

		//assert and verify
		Assert.assertEquals(numberofprograms, iCount);

		return new ConnectorsPage(driver);
	}

	//verify and validate connector updates (connector edit page)
	public ConnectorsPage validateConnectorUpdate(String field, String expectedresult, String connectorname)
	{
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		sleep();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(connectorname);
		sleep();

		switch (field)
		{
		case "name":
		{
			String i=driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[5]")).getText();
			System.out.println(i);
			sleep();

			//assert and verify
			Assert.assertEquals(i, expectedresult);

			break;
		}
		case "client":
		{
			String i=driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[1]")).getText();
			System.out.println(i);
			sleep();

			//assert and verify
			Assert.assertEquals(i, expectedresult);

			break;
		}
		case "status":
		{
			String i=driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[5]/span")).getText();
			System.out.println(i);
			sleep();

			//assert and verify
			Assert.assertEquals(i, expectedresult);
			break;
		}
		case "Workflow Association":
		{
			String i=driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[6]/span")).getText();
			System.out.println(i);
			sleep();

			//assert and verify
			Assert.assertEquals(i, expectedresult);
			break;
		}

		default: 
		{
			throw new InvalidParameterException
			("field "+field +" is not supported, please verify your parameters.");
		}

		}
		return new ConnectorsPage(driver);
	}

	//this method will be updated,(to permanent archive method)
	public ConnectorsPage archiveRole(String connectorname)
	{
		driver.findElement(By.xpath("//input[@type='search']")).clear();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(connectorname);
		sleep();
		//select all check boxes
		java.util.List<WebElement> els = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for ( WebElement el : els ) 
		{
			if ( !el.isSelected()) 
			{
				el.click();
			}
			Assert.assertTrue(el.isSelected());
		}
		driver.findElement(By.xpath(".//*[@id='datatable']/tbody/tr/td[7]/div/div/div/a[2]")).click();
		//switching to class="modal-dialog" 
		driver.switchTo().activeElement();
		sleep();
		// find the button which contains text "yes" 
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();

		return new ConnectorsPage(driver);			
	}

	public ConnectorsPage addConnectors() {
		// TODO Auto-generated method stub
		readconfig();
		try{
			driver.findElement(By.xpath("//a[contains(@href,'/connector/add')]")).click();
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ConnectorsPage(driver);
	}

	//add client
	public ConnectorsPage addClientName(String clientname)
	{
		readconfig();
		driver.findElement(By.id(library.getProperty("var_add_client"))).click();
		driver.findElement(By.id(library.getProperty("var_add_client_search_field"))).sendKeys(clientname);
		driver.findElement(By.id(library.getProperty("var_add_client_search_field"))).sendKeys(Keys.ENTER);
		sleep();
		//assert and verify
		Assert.assertTrue(driver.findElement(By.id(library.getProperty("var_add_client"))).getText().equalsIgnoreCase(clientname));
		//return connectors add page
		return new ConnectorsPage(driver);
	}
	
	//select a brand
		public ConnectorsPage addBrand(String brandname)
		{
			readconfig();
			driver.findElement(By.xpath(".//*[@id='s2id_autogen7']")).sendKeys(brandname);
			driver.findElement(By.xpath(".//*[@id='s2id_autogen7']")).sendKeys(Keys.ENTER);
			//assert and verify
		//	Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("var_add_brand"))).isEnabled());
			//return connectors add page
			return new ConnectorsPage(driver);
		}
		//select a program
		public ConnectorsPage addProgram(String programname)
		{
			readconfig();
			driver.findElement(By.xpath(".//*[@id='s2id_autogen8']")).sendKeys(programname);
			driver.findElement(By.xpath(".//*[@id='s2id_autogen8']")).sendKeys(Keys.ENTER);
			//assert and verify
		//	Assert.assertTrue(driver.findElement(By.xpath(library.getProperty("mes_add_program"))).isEnabled());
		//	Assert.assertEquals(driver.getTitle(),library.getProperty("mess_add_page_title"));
			//return messages add page
			return new ConnectorsPage(driver);
		}
		//enter message name in name field
		public ConnectorsPage addConnectorName(String connectorname)
		{
			readconfig();
			driver.findElement(By.xpath(".//*[@id='Connector_Name']")).clear();
			driver.findElement(By.xpath(".//*[@id='Connector_Name']")).sendKeys(connectorname);
		//	Assert.assertEquals(driver.getTitle(),library.getProperty("mess_add_page_title"));
			//return messages add page
			return new ConnectorsPage(driver);
		}

		public ConnectorsPage addAttributeNameValue(String attributename, String attributevalue) {
			// TODO Auto-generated method stub
			readconfig();
			driver.findElement(By.xpath(".//*[@id='connector-form']/div[1]/div[5]/div/div/div[2]/div[1]/a/i")).click();
			driver.findElement(By.xpath(".//*[@id='attribute_0']/td[2]/input")).clear();
			driver.findElement(By.xpath(".//*[@id='attribute_0']/td[2]/input")).sendKeys(attributename);
			driver.findElement(By.xpath(".//*[@id='attribute_0']/td[3]/input")).clear();
			driver.findElement(By.xpath(".//*[@id='attribute_0']/td[3]/input")).sendKeys(attributevalue);

			return new ConnectorsPage(driver);
 
		}

		public ConnectorsPage addWorkflow(String workflowname) {
			// TODO Auto-generated method stub
			readconfig();
			//driver.findElement(By.xpath(".//*[@id='select2-chosen-2']")).click();
			driver.findElement(By.xpath(".//*[@id='select2-chosen-2']")).sendKeys(workflowname);
			driver.findElement(By.xpath(".//*[@id='select2-chosen-2']")).sendKeys(Keys.ENTER);
			return new ConnectorsPage(driver);

		}

		public ConnectorsPage saveConnector() {
			// TODO Auto-generated method stub
			try{
			//driver.findElement(By.xpath(".//*[@id='text_105']/div/div[1]/input")).clear();
			//driver.findElement(By.xpath(".//*[@id='text_105']/div/div[1]/input")).sendKeys("0");
			driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
			}catch(Exception e){
				e.printStackTrace();
			}
			return new ConnectorsPage(driver);

		}

}
