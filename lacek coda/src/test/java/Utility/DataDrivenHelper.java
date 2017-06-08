package Utility;

/*data driven helper class to get the test data sets from excelfile*/
/*data driven helper class inherits from ExcelHelperClass to reuse all code in ExcelHelper class*/
//
public class DataDrivenHelper extends ExcelHelperClass{
	/*specify test name column*/
	/*using variable for test name column so that if column changes in future*/
	public final static int testNameColumn = 1;
	/*specify test data column*/
	/*using variable for test name column so that if column changes in future*/
	public final static int testDataStartColumn = 2;
	/*datadrivenhelper constructor which takes excel file path and then passes to super*/
	public DataDrivenHelper(String filePath)
	{
		super(filePath);
	}

	/*returns 2 dimensional object array representing testdata*/
	public Object[][] getTestDataSets(String sheetname, String testname)
	{
		/*get test case row number and test data start row number*/
		int testRowNumber=getRowNumber(sheetname, testNameColumn, testname);
		int testDataStartRow=testRowNumber +1;
		/*calculate test data row count*/
		int testDataRows=0;
		for(int i =testDataStartRow;getCellData(sheetname,testNameColumn, i).equals(testname);i++);
		{
			testDataRows ++;
		}
		/*calculate test data column count*/
		int testDataCols=getColumnNumber(sheetname, testRowNumber, testname) - testDataStartColumn +1;
		/*Define 2 dimensional object array to hold test datasets*/
		Object[][] testCaseDataSets= new String [testDataRows][testDataCols];
		/*read testdata cells from excel file and assign into object[][]*/
		for (int i=0; i<testDataRows; i++)
		{
			for(int j=0;j<testDataCols; j++)
			{
				testCaseDataSets[i][j] = ExcelHelperClass.getCellData(sheetname, testDataStartColumn, testDataStartColumn +1);
			}
		}
		return testCaseDataSets;            
	}
}
