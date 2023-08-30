package week6.day1.classroom;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
    public static void main(String[] args) throws IOException {
        readExcel();
    }

    private static String[][] readExcel() throws IOException {
        XSSFWorkbook book=new XSSFWorkbook("./excelData/Lead.xlsx");
        // XSSFWorkbook book = new XSSFWorkbook("./excelData/Lead.xlsx");
        XSSFSheet sheet = book.getSheetAt(0);
        XSSFRow row = sheet.getRow(2);
        int rowCount = sheet.getLastRowNum();
        int colCount = row.getLastCellNum();
        String[][] data = new String[rowCount][colCount];
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                String cellValues = sheet.getRow(i).getCell(j).getStringCellValue();
                data[i - 1][j] = cellValues;
            }

        }
        book.close();
        return data;
    }
}
