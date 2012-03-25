package org.hashgeek.model;

import org.joda.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 * User: Basu
 * Date: 3/25/12
 * Time: 6:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Match {
    private String homeTeam;
    private String awayTeam;
    private String localDateTimeString;
    private String venue;

    public Match(String homeTeam, String awayTeam, String localDateTimeString, String venue) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.localDateTimeString = localDateTimeString;
        this.venue = venue;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getLocalDateTimeString() {
        return localDateTimeString;
    }

    public String getVenue() {
        return venue;
    }

    @Override
    public String toString() {
        return homeTeam + " vs " + awayTeam + " at " + localDateTimeString;
    }
}
