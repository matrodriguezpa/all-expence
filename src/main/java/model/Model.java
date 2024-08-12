package model;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Model {

    public void setEgresos(String fileNamexls) {
        
        try (FileInputStream fileInputStream = new FileInputStream(fileNamexls)) {
            HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);

            for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                HSSFRow row = sheet.getRow(rowIndex);
                if (row != null) {
                    for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
                        HSSFCell cell = row.getCell(cellIndex);
                        if (cell != null) {
                            switch (cell.getCellType()) {
                                case STRING:
                                    System.out.print(cell.getStringCellValue() + "  -   ");
                                    break;
                                case NUMERIC:
                                    System.out.print(cell.getNumericCellValue() + "  -   ");
                                    break;
                                case BOOLEAN:
                                    System.out.print(cell.getBooleanCellValue() + "  -   ");
                                    break;
                                default:
                                    System.out.print("Unknown Cell Type\t");
                                    break;
                            }
                        }
                    }
                    System.out.println();
                }
            }
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Object[] getEgresos() {
        Object[] datos = {"HOALSDAS", "dsadsa", 1231231, "afdsads", "frgfsdhdf", "ghfsdf"};
        return datos;
    }

}
