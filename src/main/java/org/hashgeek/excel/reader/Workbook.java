package org.hashgeek.excel.reader;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: Basu
 * Date: 3/25/12
 * Time: 4:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Workbook {
    private String workBookPath;
    private String sheetName;
    private boolean skipHeader;

    public Workbook(String workBookPath, String sheetName) {
        this.skipHeader = true;
        if(!(new File(workBookPath).exists()))
            throw new RuntimeException("Excel workbook: " + workBookPath + " not found.");
        this.workBookPath = workBookPath;
        this.sheetName = sheetName;
    }

    public String getWorkBookPath() {
        return workBookPath;
    }

    public String getSheetName() {
        return sheetName;
    }

    public boolean isSkipHeader() {
        return skipHeader;
    }
}
