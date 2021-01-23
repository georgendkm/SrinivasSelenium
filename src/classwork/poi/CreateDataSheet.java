package classwork.poi;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateDataSheet {

	public static void main(String[] args) throws Exception {
		
		
		String[][] dataArr = { { "user1", "pwd1"},
							   { "user2", "pwd2"},
							   { "user3", "pwd3"},
							   { "user4", "pwd4"},
							   { "user5", "pwd5"},
				
		};
		
		XSSFWorkbook workBook = new XSSFWorkbook();
		XSSFSheet sheet = workBook.createSheet("TestData");
		for(int i = 0; i < dataArr.length; i++) {
			System.out.println("creating row : " + i);
			XSSFRow row = sheet.createRow(i);
			for(int j =0; j < dataArr[i].length; j++) {
				System.out.println("Creating cell : " + j + " for row : " + i);
				XSSFCell cell = row.createCell(j);
				cell.setCellValue(dataArr[i][j]);
			}
		}
		
		FileOutputStream fout = new FileOutputStream("DataExcel.xlsx");
		workBook.write(fout);
		
		fout.close();
		workBook.close();
		System.out.println("Excel created");
	}

}
