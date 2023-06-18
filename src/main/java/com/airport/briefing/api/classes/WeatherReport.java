package com.airport.briefing.api.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class WeatherReport {

    private Report report;

    public WeatherReport() { super(); }

    public Report getReport() { return report; }
}
