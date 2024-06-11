package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	static XSSFWorkbook wb;
	public static Object[][] getDataFromSheet(String sheetName)
	{
		try {
			wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/testdata/data.xlsx")));
		} catch (FileNotFoundException e) {
			System.out.println("File not Found" +e.getMessage());
		} catch (IOException e) {
			System.out.println("Coul not Load the file" +e.getMessage());
		}
		XSSFSheet sheet= wb.getSheet(sheetName);
		int rows= sheet.getPhysicalNumberOfRows();
		int columns=sheet.getRow(0).getPhysicalNumberOfCells();
		
		Object[][] arr= new Object[rows-1][columns];
		
		for(int i=1;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				arr[i-1][j]=getStringData(sheetName,i,j);
			}
		}
		return arr;
	}
	
	public static String getStringData(String sheet, int row, int cell)
	{
		XSSFSheet sheet1= wb.getSheet(sheet);
		String value="";
		XSSFCell col= sheet1.getRow(row).getCell(cell);
		
		if(col.getCellType()==CellType.NUMERIC)
		{
			value=String.valueOf(col.getNumericCellValue());
		}
		else if(col.getCellType()==CellType.STRING)
		{
			value=col.getStringCellValue();
		}
		else if(col.getCellType()==CellType.BLANK)
		{
			value="";
		}
		else if(col.getCellType()==CellType.BOOLEAN)
		{
			value=String.valueOf(col.getBooleanCellValue());
		}
		return value;
	}
}
