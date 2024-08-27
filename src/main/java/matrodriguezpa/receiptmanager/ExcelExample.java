package matrodriguezpa.receiptmanager;


import java.io.IOException;
import matrodriguezpa.receiptmanager.view.ExcelUtility;

public class ExcelExample {
    public static void main(String[] args) {
        ExcelUtility excelUtility = new ExcelUtility();
        
        // Define the filename for the Excel file
        String filename = "simple_workbook.xls";
        
        try {
            // Create an Excel file with a sheet and cells
            excelUtility.createCells(filename);
            System.out.println("Excel file created successfully: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while creating the Excel file.");
        }
    }
}
