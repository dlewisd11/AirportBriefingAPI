package com.airport.briefing.api.classes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class Utilities {

    static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    static String dateDiff(Date d1, Date d2) {
        long d1Millis = d1.getTime();
        long d2Millis = d2.getTime();
        long diffMillis = d1Millis>d2Millis?d1.getTime() - d2.getTime():0;

        String hhmm = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toHours(diffMillis),
                TimeUnit.MILLISECONDS.toMinutes(diffMillis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(diffMillis)));
        return hhmm;
    }
}
