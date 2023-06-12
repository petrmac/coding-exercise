package com.example.codingexercise;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class WeatherForecast {

    private LocalDateTime time;
    private double forecastedTemperature;
}
