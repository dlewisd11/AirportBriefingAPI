package com.airport.briefing.api.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
class ForecastConditions {
    private Date dateIssued;
    private Date currentPeriodStartDate;
    private String periodOffset;
    private Wind wind;

    public ForecastConditions() { super(); }

    public void setDateIssued(Date dateIssued) {
        this.dateIssued = dateIssued;
    }

    public void setCurrentPeriodStartDate(Date currentPeriodStartDate) {
        this.currentPeriodStartDate = currentPeriodStartDate;
        this.periodOffset = Utilities.dateDiff(dateIssued, this.currentPeriodStartDate);
    }

    public String getPeriodOffset() {
        return periodOffset;
    }

    public Wind getWind() { return wind; }

}
