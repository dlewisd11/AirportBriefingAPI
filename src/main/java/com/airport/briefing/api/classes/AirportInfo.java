package com.airport.briefing.api.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class AirportInfo {
    private String identifier;
    private String name;
    private double latitude;
    private double longitude;
    private List<Runway> runways;

    private CurrentConditions currentWeatherReport;

    private Forecast forecastWeatherReport;

    public AirportInfo() {
        super();
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setCurrentWeatherReport(CurrentConditions currentWeatherReport) {
        this.currentWeatherReport = currentWeatherReport;
    }

    public void setForecastWeatherReport(Forecast forecastWeatherReport) {
        this.forecastWeatherReport = forecastWeatherReport;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public List<Runway> getRunways() {
        return runways;
    }

    public CurrentConditions getCurrentWeatherReport() {
        return currentWeatherReport;
    }

    public Forecast getForecastWeatherReport() {
        return forecastWeatherReport;
    }
}
