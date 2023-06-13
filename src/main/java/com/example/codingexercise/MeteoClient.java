package com.example.codingexercise;

import reactor.core.publisher.Mono;

import java.util.List;

public interface MeteoClient {
    Mono<List<WeatherForecast>> getForecast(double latitude, double longitude);
}
