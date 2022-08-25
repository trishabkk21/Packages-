package edu.virginia.cs.nbateams;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class SSWorkbookFactory {
    public Workbook getWorkbook(String filename) {
        if (filename.endsWith(".xlsx")) {
            return new XSSFWorkbook();
        } else if (filename.endsWith(".xls")) {
            return new HSSFWorkbook();
        } else {
            throw new IllegalArgumentException(getIllegalFilenameError(filename));
        }
    }

    private String getIllegalFilenameError(String filename) {
        return "Error: illegal excel filename: " + filename + "\n" +
                "\tFilename must end with .xlsx or .xls";
    }
}
