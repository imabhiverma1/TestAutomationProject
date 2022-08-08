package utilities;

import java.io.*;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSdata {

	@DataProvider(name = "bvtdata")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {

		String excelSheetName = m.getName();
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetname = wb.getSheet(excelSheetName);

		int totalRows = sheetname.getLastRowNum();
		// System.out.println(totalRows);
		Row rowCells = sheetname.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		// System.out.println(totalCols);

		DataFormatter format = new DataFormatter(); // to formate the data into string or object type

		String testData[][] = new String[totalRows][totalCols];
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCols; j++) {
				testData[i - 1][j] = format.formatCellValue(sheetname.getRow(i).getCell(j));
				// System.out.println(testData[i - 1][j]);
			}
		}
		return testData;
	}
}
