package com.example.codingexercise;

import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Map;

public interface MeteoClient {
    Mono<Map<LocalDateTime, WeatherForecast>> getForecast(double latitude, double longitude);
}
