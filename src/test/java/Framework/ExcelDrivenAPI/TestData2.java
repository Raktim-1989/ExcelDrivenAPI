package Framework.ExcelDrivenAPI;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("D:\\ITCINFOTECH\\TestData.xlsx");
		@SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int count = wb.getNumberOfSheets();
		for(int i = 0 ; i<count;i++)
		{
			if(wb.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sh = wb.getSheetAt(i);
				Iterator<Row> rows = sh.iterator();
				Row row = rows.next();
				Iterator<Cell> cell  = row.cellIterator();
				int column = 0;
				int k = 0 ;
				while(cell.hasNext())
				{
					if(cell.next().getStringCellValue().equalsIgnoreCase("Data2"))
					{
						column = k;
						
					}
					k++;
				}
				
				System.out.println("column value is " + column);
				
				//scan the column "Data2" 
				
				while(rows.hasNext())
				{
					
					Row r = rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Add Profile"))
					{
						Iterator<Cell> c = r.cellIterator();
						while(c.hasNext())
						{
							System.out.println(c.next().getStringCellValue());
							
						}
						
					}
					
				}
				
			}
			
			
		}

	}

}
