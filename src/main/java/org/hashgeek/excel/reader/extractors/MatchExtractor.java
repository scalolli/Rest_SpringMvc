package org.hashgeek.excel.reader.extractors;

import org.apache.poi.ss.usermodel.Row;
import org.hashgeek.model.Match;
import org.hashgeek.model.MatchBuilder;
import org.joda.time.LocalDateTime;

import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: Basu
 * Date: 3/25/12
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class MatchExtractor {
    private static int MATCH_DATE = 0;
    private static int MATCH_TIME = 1;
    private static int TEAMS = 2;
    private static int VENUE = 3;

    public static Match match(Row row) {
        LocalDateTime date = new LocalDateTime(row.getCell(MATCH_DATE).getDateCellValue());
        Double time = row.getCell(MATCH_TIME).getNumericCellValue() * 24 * 60 * 60;
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        time = Double.valueOf(twoDForm.format(time));
        date = date.plusSeconds(time.intValue());

        String teams = row.getCell(TEAMS).getStringCellValue();
        String venue = row.getCell(VENUE).getStringCellValue();
        return new MatchBuilder().setHomeTeam(homeTeam(teams)).setAwayTeam(awayTeam(teams)).setLocalDateTimeString(date.toString("EE,d MMMM-Ka")).
                setVenue(venue).createMatch();
    }

    private static String homeTeam(String teams) {
        return teams.isEmpty() ? "" : teams.split("vs")[0];
    }

    private static String awayTeam(String teams) {
        if (!teams.isEmpty()) {
            String awayTeam = teams.isEmpty() ? "" : teams.split("vs")[1];
            return awayTeam.substring(0, awayTeam.indexOf(","));
        }
        return "";
    }

}
