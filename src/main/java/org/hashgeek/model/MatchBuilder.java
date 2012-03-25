package org.hashgeek.model;

import org.joda.time.LocalDateTime;

public class MatchBuilder {
    private String homeTeam;
    private String awayTeam;
    private String localDateTimeString;
    private String venue;

    public MatchBuilder setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
        return this;
    }

    public MatchBuilder setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
        return this;
    }

    public MatchBuilder setLocalDateTimeString(String localDateTimeString) {
        this.localDateTimeString = localDateTimeString;
        return this;
    }

    public MatchBuilder setVenue(String venue) {
        this.venue = venue;
        return this;
    }

    public Match createMatch() {
        return new Match(homeTeam, awayTeam, localDateTimeString, venue);
    }
}