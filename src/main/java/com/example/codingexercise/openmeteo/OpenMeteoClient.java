package com.example.codingexercise.openmeteo;

import com.example.codingexercise.MeteoClient;
import com.example.codingexercise.WeatherForecast;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class OpenMeteoClient implements MeteoClient {

    private static final String API_BASE_URL = "https://api.open-meteo.com";
    private final WebClient webClient;

    public OpenMeteoClient(final WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl(API_BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .build();
    }

    @Override
    public Mono<List<WeatherForecast>> getForecast(double latitude, double longitude) {
        final Mono<ForecastResponseDto> response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/forecast")
                        .queryParam("latitude", latitude)
                        .queryParam("longitude", longitude)
                        .queryParam("current_weather", false)
                        .queryParam("hourly", "temperature_2m")
                        .build())
                .retrieve()
                .bodyToMono(ForecastResponseDto.class);

        return response.map(this::mapForecast);

    }

    private List<WeatherForecast> mapForecast(ForecastResponseDto forecast) {

        //TODO: implement me
        return null;
    }
}
