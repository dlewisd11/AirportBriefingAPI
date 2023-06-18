package com.airport.briefing.api.classes;

import java.util.ArrayList;
import java.util.List;

class AirportBriefing {

    private List<AirportInfo> airportBriefings;

    public AirportBriefing() {
        this.airportBriefings = new ArrayList<>();
    }

    public void addAirportInfo(AirportInfo airportInfo) {
        this.airportBriefings.add(airportInfo);
    }

    public List<AirportInfo> getAirportBriefings() {
        return airportBriefings;
    }
}
