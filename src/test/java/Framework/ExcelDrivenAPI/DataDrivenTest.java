package Framework.ExcelDrivenAPI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTest {
	
	 
	
	//Identify TestCases column by scanning the entire first row
	//Once column is identified then scan entire testcases column to identify purchase testcase
	//after you grab purchase test case row, pul all the data of tha row and fed into test
	
	public ArrayList<String> getData(String testCaseName) throws IOException
	{
		ArrayList<String> list = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("D:\\ITCINFOTECH\\TestData.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int count = wb.getNumberOfSheets();
		for(int i = 0 ; i<count;i++)
		{
			if(wb.getSheetName(i).equalsIgnoreCase("testdata")) 
			{
			   XSSFSheet sh = wb.getSheetAt(i);
			//Identify TestCases column by scanning the entire first row
			   
			  
			   
			   Iterator<Row> rows = sh.iterator();              //sheet is collection of rows
			   Row firstRow = rows.next();
			   Iterator<Cell> cell =  firstRow.cellIterator(); //row is collection of cells
			   int k = 0;
			   int column = 0;
			   while(cell.hasNext())
			   {
				   Cell value = cell.next();
				   if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
				   {
					   //desired column
					   column = k;
					   
				   }
				   k++;
			   }
			  
			   System.out.println(column);
			   
			  //Once TestCases column is identified , scan entire column to identify Purchase row
		
			   
		       while(rows.hasNext())
			   {
				   Row r = rows.next();
				  if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName))
				  {
					Iterator<Cell> c = r.cellIterator(); 
					while(c.hasNext())
					{
						//System.out.println(c.next().getStringCellValue());
						DataFormatter df = new DataFormatter();
						//list.add(c.next().getStringCellValue());
						list.add(df.formatCellValue(c.next()));
						
					}
					  
				  }
			   }
			   
			}
		}
		
		return list;
	}

}
