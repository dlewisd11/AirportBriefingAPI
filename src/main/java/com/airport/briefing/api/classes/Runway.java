package com.airport.briefing.api.classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class Runway {
    private String ident;
    private int length;
    private int width;
    private String surfaceType;
    private String surfaceQuality;

    public Runway() {
        super();
    }

    public String getIdent() { return ident; }

    public int getLength() { return length; }

    public int getWidth() { return width; }

    public String getSurfaceType() { return surfaceType; }

    public String getSurfaceQuality() { return surfaceQuality; }
}
