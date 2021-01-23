package classwork.poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadDataSheet {

	
	@DataProvider(name="paramData")
	public String[][] readData() throws Exception {
		
		FileInputStream fin = new FileInputStream("DataExcel.xlsx");
		String[][] dataArray;
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet sheet = workbook.getSheet("TestData");
		//XSSFSheet sheet = workbook.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int cellCount = row.getPhysicalNumberOfCells();
		dataArray = new String[rows][cellCount];
		//System.out.println("Rows : " + rows);
		for(int r=0; r < rows; r++) {
			row = sheet.getRow(r);
			int cells = row.getPhysicalNumberOfCells();
			//System.out.println("row cells : " + cells);
			for(int c = 0; c < cells; c++) {
				XSSFCell cell = row.getCell(c);
				System.out.print(cell.toString() + "\t\t");
				dataArray[r][c] =  cell.toString();
			}
			System.out.println();
		}
		
		workbook.close();
		fin.close();
		return dataArray;
		
	}

}
