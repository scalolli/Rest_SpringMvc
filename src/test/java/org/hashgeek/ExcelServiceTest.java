package org.hashgeek;

import org.hashgeek.excel.reader.IplExcelService;
import org.hashgeek.excel.reader.Workbook;
import org.hashgeek.model.Match;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Basu
 * Date: 3/25/12
 * Time: 5:24 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/test-context.xml")
public class ExcelServiceTest {
    @Autowired
    private IplExcelService iplExcelService;

    public static final String SHEET_NAME = "IPL 2011";
    private String excelFilePath = this.getClass().getResource("/IPL2011.properties").getFile();

    @Test
    public void testReadOneRow() throws Exception {
        String fileName = excelFilePath.substring(1, excelFilePath.length());
        List<Match> matches = iplExcelService.matches(new Workbook(fileName, SHEET_NAME));
        System.out.println("Matches are: " + matches);
    }
}
