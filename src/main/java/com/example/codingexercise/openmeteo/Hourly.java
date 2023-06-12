package com.example.codingexercise.openmeteo;

import java.time.LocalDateTime;

public record Hourly(LocalDateTime[] time, float[] temperature_2m) {
}
