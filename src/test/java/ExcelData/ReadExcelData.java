package ExcelData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new  FileInputStream("c://users//P7109842//TestData.xlsx");
		
		ArrayList<String> list= new ArrayList<String>();
		
		XSSFWorkbook workBook= new XSSFWorkbook(fis);
		int countOfSheets=workBook.getNumberOfSheets();
		
		for (int i=0 ; i<countOfSheets; i++)
		{
			if (workBook.getSheetName(i).equalsIgnoreCase("Test1"))
			{
		
		     XSSFSheet sheet= workBook.getSheetAt(i);//Collection of rows
		     Iterator<Row> rows= sheet.rowIterator();
		     Row firstRow= rows.next(); 
		     Iterator<Cell> cell=firstRow.cellIterator(); //Collection of cells
		     int k=0;
		     int column=0;
		     while(cell.hasNext())
		     {
		    	 Cell value=cell.next();
		    	 if (value.getStringCellValue().equalsIgnoreCase("TestCase"))
		    	 {
		    		 column=k;
		    	 }
		    	 k++;
		     }
		     System.out.println(column);
		     
		     while(rows.hasNext())
		     {
		    	 Row r= rows.next();
		    	 if (r.getCell(column).getStringCellValue().equalsIgnoreCase("Login"))

		    			 {
		    		 Iterator<Cell> cell1= r.cellIterator();
		    		 while(cell1.hasNext())
		    		 {
		    			 Cell content=cell1.next();
		    			 if(content.getCellType()==CellType.STRING)
		    			 {
		    			 list.add(content.getStringCellValue());
		    			 }
		    			 else
		    			 {
		    				double val=content.getNumericCellValue();
		    				list.add(NumberToTextConverter.toText(val));
		    				
		    			 }
		    			 
		    		 }
		    		 
		    			 }
		     }
			}
		}
	}

}
