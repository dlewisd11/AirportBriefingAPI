package com.airport.briefing.api.classes;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

@PropertySource("secret.properties")
@RestController
class AirportBriefingController {

	@Value("${api.base.url}")
	private String apiBaseURL;
	
	@Value("${api.key}")
	private String apiKey;
	
    private static final String AIRPORT_IDENTIFIER_REGEX = "^[A-Za-z0-9]{3,4}$";

    @GetMapping("/AirportBriefing")
    public AirportBriefing airportBriefing(@RequestParam(value = "identifiers") String identifiers) {

    	AirportBriefing airportBriefing = new AirportBriefing();

        String[] identifiersArray = identifiers.split(",");

        for (String identifier : identifiersArray) {
            identifier = identifier.trim();
            identifier = identifier.toUpperCase();
            if (Pattern.matches(AIRPORT_IDENTIFIER_REGEX, identifier)) {

                AirportInfo airportInfo = getAirportInfo(identifier);

                WeatherReport weatherReport = getWeatherReport(identifier);
                airportInfo.setCurrentWeatherReport(weatherReport.getReport().getConditions());

                Forecast forecastWeatherReport = weatherReport.getReport().getForecast();
                forecastWeatherReport.updateForecastConditionsWithCurrentPeriodStartDate();
                airportInfo.setForecastWeatherReport(forecastWeatherReport);

                airportBriefing.addAirportInfo(airportInfo);
            }
        }

        return airportBriefing;
    }

    private AirportInfo getAirportInfo(String identifier) {    	
        String airportsURI = String.format(apiBaseURL + "/airports/%s", identifier);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(apiKey);
        headers.set("ff-coding-exercise", "1");
        HttpEntity<Object> request = new HttpEntity<Object>(headers);
        AirportInfo airportInfo = null;

        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(airportsURI, HttpMethod.GET, request, String.class);
            ObjectMapper mapper = new ObjectMapper();
            airportInfo = mapper.readerFor(AirportInfo.class).readValue(responseEntity.getBody());
            airportInfo.setIdentifier(identifier);
        }
        catch(Exception e) {
            System.out.println(e);
        }

        return airportInfo;
    }

    private WeatherReport getWeatherReport(String identifier) {
        String weatherURI = String.format(apiBaseURL + "/weather/report/%s", identifier);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(apiKey);
        headers.set("ff-coding-exercise", "1");
        HttpEntity<Object> request = new HttpEntity<Object>(headers);
        WeatherReport weatherReport = null;

        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(weatherURI, HttpMethod.GET, request, String.class);
            ObjectMapper mapper = new ObjectMapper();
            weatherReport = mapper.readerFor(WeatherReport.class).readValue(responseEntity.getBody());
        }
        catch(Exception e) {
            System.out.println(e);
        }

        return weatherReport;
    }

    @GetMapping("/error")
    @ExceptionHandler({ Exception.class })
    public AirportBriefingException handleException(Exception ex, WebRequest request, HttpServletResponse response) {
        response.setStatus(500);
        AirportBriefingException airportBriefingException = new AirportBriefingException(500, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return airportBriefingException;
    }
}



