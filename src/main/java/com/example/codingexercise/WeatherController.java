package com.example.codingexercise;

import com.example.codingexercise.openmeteo.OpenMeteoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final OpenMeteoClient meteoClient;

    @GetMapping(value = {"/forecast"})
    public Mono<WeatherForecastResponse> getForecast(@RequestParam(value = "latitude") double latitude,
                                                     @RequestParam(value = "latitude") double longitude) {
        return meteoClient.getForecast(latitude, longitude)
                .map(response -> new WeatherForecastResponse(latitude, longitude, response));
    }

}
