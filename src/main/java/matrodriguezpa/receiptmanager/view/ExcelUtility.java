
package matrodriguezpa.receiptmanager.view;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.WorkbookUtil;


import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;

public class ExcelUtility {

    // Method to create an HSSFWorkbook and save it as an .xls file
    public void createHSSFWorkbook(String filename) throws IOException {
        Workbook wb = new HSSFWorkbook();
        try (OutputStream fileOut = new FileOutputStream(filename)) {
            wb.write(fileOut);
        }
    }

    // Method to create an XSSFWorkbook and save it as an .xlsx file
    public void createXSSFWorkbook(String filename) throws IOException {
        Workbook wb = new HSSFWorkbook();
        try (OutputStream fileOut = new FileOutputStream(filename)) {
            wb.write(fileOut);
        }
    }

    // Method to create sheets in a workbook
    public void createSheets(String filename) throws IOException {
        Workbook wb = new HSSFWorkbook();  // or new XSSFWorkbook();
        Sheet sheet1 = wb.createSheet("new sheet");
        Sheet sheet2 = wb.createSheet("second sheet");

        // Create a sheet with a safe name
        String safeName = WorkbookUtil.createSafeSheetName("[O'Brien's sales*?]");
        Sheet sheet3 = wb.createSheet(safeName);

        try (OutputStream fileOut = new FileOutputStream(filename)) {
            wb.write(fileOut);
        }
    }

    // Method to create cells in a sheet
    public void createCells(String filename) throws IOException {
        Workbook wb = new HSSFWorkbook();  // or new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");

        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow(0);

        // Create cells with different types of values
        Cell cell = row.createCell(0);
        cell.setCellValue(1);
        row.createCell(1).setCellValue(1.2);
        row.createCell(2).setCellValue(createHelper.createRichTextString("This is a string"));
        row.createCell(3).setCellValue(true);

        // Write the output to a file
        try (OutputStream fileOut = new FileOutputStream(filename)) {
            wb.write(fileOut);
        }
    }
}
