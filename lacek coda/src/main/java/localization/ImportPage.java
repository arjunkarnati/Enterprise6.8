package localization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Utility.PageBase;

public class ImportPage extends PageBase {

	public ImportPage(WebDriver driver) 
	{
		super(driver);
	}
	//add a file
	public ImportPage clickBrowse(String filename,String format)
	{	
		readconfig();
		driver.findElement(By.name(elementslocator.getProperty("import_browse"))).click();
		switch(filename)
		{
		case"image":
		{
			if(format.equalsIgnoreCase("xml"))
			{
				driver.findElement(By.xpath(elementslocator.getProperty("import_search_field"))).sendKeys("C:\\Users\\prince.kabuika\\Desktop\\Test\\Test Data\\images\\ford.xml");
				Assert.assertTrue(driver.findElement(By.xpath(elementslocator.getProperty("import_import"))).isDisplayed(),"cannot load the file, verify localization import, browse");
			}
		}
		}
		return new ImportPage(driver);
	}

}
