package com.airport.briefing.api.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class Forecast {
    private Period period;
    private List<ForecastConditions> conditions;

    public Forecast() { super(); }

    public void setPeriod(Period period) { this.period = period; }

    public void setConditions(List<ForecastConditions> conditions) {
        this.conditions = conditions;
        abbreviatePeriods();
    }

    public List<ForecastConditions> getConditions() {
        return conditions;
    }

    public void updateForecastConditionsWithCurrentPeriodStartDate() {
        for (ForecastConditions forecastConditions: conditions) {
            forecastConditions.setCurrentPeriodStartDate(period.getDateStart());
        }
    }

    private void abbreviatePeriods() {
        if(conditions.size()>=3) {
            this.conditions = conditions.subList(1, 3);
        }
    }
}
