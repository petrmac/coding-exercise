package com.example.codingexercise;

import java.time.LocalDateTime;
import java.util.Map;

public record WeatherForecastResponse(double latitude, double longitude, Map<LocalDateTime, WeatherForecast> forecast) {
}
