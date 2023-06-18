package com.airport.briefing.api.classes;

import static com.airport.briefing.api.classes.Utilities.round;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class CurrentConditions {
    private String text;
    private double tempC;
    private double tempF;
    private double relativeHumidity;
    private Wind wind;

    public CurrentConditions() {
        super();
    }

    public void setTempC(double tempC) {
        this.tempC = tempC;
        this.tempF = round(((this.tempC * (double)(9.0/5.0)) + 32), 1);
    }

    public String getText() { return text; }

    public double getTempF() { return tempF; }

    public double getRelativeHumidity() { return relativeHumidity; }

    public Wind getWind() { return wind; }
}
