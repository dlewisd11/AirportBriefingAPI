package com.airport.briefing.api.classes;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

class AirportBriefingException {
    private LocalDateTime time = LocalDateTime.now();

    private int statusCode;

    private HttpStatus status;

    private String message;

    public AirportBriefingException(int statusCode, HttpStatus status, String message) {
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
