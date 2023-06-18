package com.airport.briefing.api.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
class Period {
    private Date dateStart;
    private Date dateEnd;

    public Period() { super(); }

    public Date getDateStart() { return dateStart; }

    public Date getDateEnd() { return dateEnd; }
}
