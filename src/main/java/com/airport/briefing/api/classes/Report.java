package com.airport.briefing.api.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class Report {
    private CurrentConditions conditions;
    private Forecast forecast;

    public Report() { super(); }

    public CurrentConditions getConditions() { return conditions; }
    public Forecast getForecast() { return forecast; }
}
