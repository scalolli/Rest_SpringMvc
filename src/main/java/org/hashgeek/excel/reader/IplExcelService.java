package org.hashgeek.excel.reader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.hashgeek.excel.reader.extractors.MatchExtractor;
import org.hashgeek.excel.reader.poi.PoiSheetIterator;
import org.hashgeek.model.Match;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Basu
 * Date: 3/25/12
 * Time: 4:28 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class IplExcelService  {

    public List<Match> matches(Workbook workbook) {
        PoiSheetIterator poiSheetIterator = PoiSheetIterator.sheetIterator(workbook.getWorkBookPath(),
                workbook.getSheetName(), workbook.isSkipHeader() ? 1 : 0);

        List<Match> matches = new ArrayList<>();

        while (poiSheetIterator.hasNext()) {
            Row row = poiSheetIterator.next();
            matches.add(MatchExtractor.match(row));
        }

        return matches;
    }
}
