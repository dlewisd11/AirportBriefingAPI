package com.airport.briefing.api.classes;

import static com.airport.briefing.api.classes.Utilities.round;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class Wind {

    private static final String[] CARDINAL_DIRECTIONS = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};

    private double speedKts = -1;

    private double speedMph = -1;

    private int direction = -1;

    private String cardinalDirection = "";

    public Wind() {
        super();
    }

    public void setSpeedKts(double speedKts) {
        this.speedKts = speedKts;
        this.speedMph = round(this.speedKts * 1.51, 2);
    }

    public void setDirection(int direction) {
        this.direction = direction;
        this.cardinalDirection = getCardinalDirection(direction);
    }

    public int getDirection() { return direction; }

    public String getCardinalDirection() {
        return cardinalDirection;
    }

    public double getSpeedMph() { return speedMph; }

    private static String getCardinalDirection(int direction) {
        double doubleDirection = (double)direction;
        String cardinalDirection = "";

        if (doubleDirection > 360.0 || doubleDirection < 0) {
            cardinalDirection = "";
        }
        else if (doubleDirection >= 337.5 || doubleDirection < 22.5) {
            cardinalDirection = CARDINAL_DIRECTIONS[0];
        }
        else if (doubleDirection >= 22.5 && doubleDirection < 67.5) {
            cardinalDirection = CARDINAL_DIRECTIONS[1];
        }
        else if (doubleDirection >= 67.5 && doubleDirection < 112.5) {
            cardinalDirection = CARDINAL_DIRECTIONS[2];
        }
        else if (doubleDirection >= 112.5 && doubleDirection < 157.5) {
            cardinalDirection = CARDINAL_DIRECTIONS[3];
        }
        else if (doubleDirection >= 157.5 && doubleDirection < 202.5) {
            cardinalDirection = CARDINAL_DIRECTIONS[4];
        }
        else if (doubleDirection >= 202.5 && doubleDirection < 247.5) {
            cardinalDirection = CARDINAL_DIRECTIONS[5];
        }
        else if (doubleDirection >= 247.5 && doubleDirection < 292.5) {
            cardinalDirection = CARDINAL_DIRECTIONS[6];
        }
        else if (doubleDirection >= 292.5 && doubleDirection < 337.5) {
            cardinalDirection = CARDINAL_DIRECTIONS[7];
        }

        return cardinalDirection;
    }
}
