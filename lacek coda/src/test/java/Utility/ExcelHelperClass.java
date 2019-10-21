package Utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

/*Reusable excel helper class to work with read and write from excel file*/
public class ExcelHelperClass {

	/*File path of the excel files*/
	private String filePath;
	/*File input stream to read data based on excel file*/
	private FileInputStream fis;
	/*Excel workbook variable to work with excel file*/
	private static Workbook workbook;
	/*Excel constructor which takes file path and initializes member variables*/
	public ExcelHelperClass(String filePath) 
	{
		this.filePath= (filePath);
		try 
		{
			fis=new FileInputStream(filePath);

			/*create an Apache POI workbook object for the excel file path provided*/
			workbook=WorkbookFactory.create(fis);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	public ExcelHelperClass() {
	}
	public String getFilePath()
	{
		return filePath;
	}
	/*get total number of rows for a given excel sheet*/
	public int getRowCount(String sheetname)
	{
		try
		{
			return workbook.getSheet(sheetname).getPhysicalNumberOfRows();
		}
		catch(NullPointerException e)
		{
			return 0;
		}
	}
	/*getcell data when excel sheet, row number and column number are provided*/
	/*return " " (empty string) when specified cell does not exist*/ 
	public static String getCellData(String sheetname, int rownumber,int columnnumber)
	{
		try
		{		
			return workbook.getSheet(sheetname).getRow(rownumber -1).getCell(columnnumber -1).toString();	
		}
		/*catch nullpointerexcption and return blank string when specified cell does not exist*/
		catch(NullPointerException e)
		{
			return "";
		}
	}
	public void setCellData(String sheetname, int columnnumber, String cellvalue,int rownumber)
	{
		Cell cell= null;
		Row row= null;
		try
		{
			cell= workbook.getSheet(sheetname).getRow(rownumber -1).createCell(columnnumber -1);
		}
		catch(NullPointerException e)
		{
			row= workbook.getSheet(sheetname).createRow(rownumber -1);
		}
		{
			cell= row.createCell(columnnumber -1);
		}
		{
			cell.setCellValue(cellvalue);
		}
		try
		{
			FileOutputStream fso= new FileOutputStream(filePath);
			workbook.write(fso);
			fso.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/*get row number based on cell value in specified column*/
	/*return -1 if there is no row with that value in specified column*/
	public int getRowNumber(String sheetname, int columnnumber, String cellvalue)
	{
		Iterator <Row> itr= workbook.getSheet(sheetname).rowIterator();
		while(itr.hasNext())
		{
			Row row= itr.next();
			try
			{
				if(row.getCell(columnnumber -1).toString().equals(cellvalue))
				{
					return(row.getRowNum() +1);
				}
			}
			catch(NullPointerException e)
			{
				continue;
			}
		}
		return -1;
	}
	/*get column number based on cell value in specified row*/
	/*return -1 if there is no row with that value in specified row*/
	public int getColumnNumber(String sheetname, int rownumber, String cellvalue)
	{
		try
		{
			Row row=workbook.getSheet(sheetname).getRow(rownumber -1);
			Iterator <Cell> itr= row.cellIterator();
			while(itr.hasNext())
			{
				Cell cell=itr.next();

				if(cell.toString().equals(cellvalue))
				{
					return(cell.getColumnIndex() +1);
				}
			}
			return -1;					               				
		}
		catch(NullPointerException e)
		{
			return -1;
		}
	}
}