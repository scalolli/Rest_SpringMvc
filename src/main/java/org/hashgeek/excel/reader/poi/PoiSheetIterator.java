package org.hashgeek.excel.reader.poi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: Basu
 * Date: 3/25/12
 * Time: 4:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class PoiSheetIterator implements Iterator<Row>, Closeable {
    private Workbook poiWorkbook;
    private Sheet sheet;
    private Integer firstRowNum;
    private Integer currentRow;

    private PoiSheetIterator(String workBookPath, String sheetName, int numberOfRowsToSkip) {
        try {
            poiWorkbook = WorkbookFactory.create(new FileInputStream(new File(workBookPath)));
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException("Unable to open workbook: " + workBookPath);
        }
        sheet = poiWorkbook.getSheet(sheetName);
        firstRowNum = sheet.getFirstRowNum();
        currentRow = firstRowNum + numberOfRowsToSkip;
    }

    public static PoiSheetIterator sheetIterator(String workBookPath, String sheetName, int numberOfRowsToSkip) {
        return new PoiSheetIterator(workBookPath, sheetName, numberOfRowsToSkip);
    }

    @Override
    public boolean hasNext() {
        return sheet.getRow(currentRow) != null;
    }

    @Override
    public Row next() {
        return sheet.getRow(currentRow++);
    }

    @Override
    public void remove() {
        throw new IllegalArgumentException("Unsupported operation exception");
    }

    @Override
    public void close() throws IOException {
        poiWorkbook = null;
        sheet = null;
        firstRowNum = null;
        currentRow = null;
    }
}
