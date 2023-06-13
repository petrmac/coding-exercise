package com.example.codingexercise;

import java.util.List;

public record WeatherForecastResponse(double latitude, double longitude, List<WeatherForecast> forecast) {
}
