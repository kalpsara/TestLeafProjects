package week6.day2.assignments;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ReadExcelFile {
    static String sheetData;
    public static Object[][] readExcel(String fileName) throws IOException {
        System.out.println("Inside readExcel");
        XSSFWorkbook book = new XSSFWorkbook("./excelData/"+fileName);
        XSSFSheet sheet = book.getSheetAt(0);
      //  XSSFSheet sheet2=book.getSheetAt(1);
        XSSFRow row = sheet.getRow(0);
        int rowCount = sheet.getLastRowNum();
        int colCount = row.getLastCellNum();
        Object[][] data = new String[rowCount][colCount];
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                //Object cellValues = sheet.getRow(i).getCell(j).getRawValue();
                Cell cell = sheet.getRow(i).getCell(j);
                DataFormatter dataFormatter = new DataFormatter();
                String formattedCellStr = dataFormatter.formatCellValue(cell);
                data[i - 1][j] = formattedCellStr;
            }
        }

        book.close();
        return data;
    }

    public static Object[][] readExcelFromSheet(String fileName,String sheetName) throws IOException {
        System.out.println("Inside readExcel");
        XSSFWorkbook book = new XSSFWorkbook("./excelData/"+fileName);
        sheetData=sheetName;
        XSSFSheet sheet = book.getSheet(sheetData);
        //  XSSFSheet sheet2=book.getSheetAt(1);
        XSSFRow row = sheet.getRow(0);
        int rowCount = sheet.getLastRowNum();
        int colCount = row.getLastCellNum();
        Object[][] data = new String[rowCount][colCount];
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < colCount; j++) {

                Cell cell = sheet.getRow(i).getCell(j);
                DataFormatter dataFormatter = new DataFormatter();
                String formattedCellStr = dataFormatter.formatCellValue(cell);
                data[i - 1][j] = formattedCellStr;
            }
        }

        book.close();
        return data;
    }
}
