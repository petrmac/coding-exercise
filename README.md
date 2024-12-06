# JLL interview coding exercise

This is a coding exercise project. 
The goal is to demonstrate applicants understanding of the current code and ability to improve it.

The example REST application provides the weather forecast for given `latitude` and `longitude`.
Current implementation uses weather API at https://open-meteo.com/. You can see the API description on the page.

The example Spring Boot application is unfinished, there are some errors and some tests are wrong.
There is a simple endpoint serving the hourly forecast. 
The expected output looks as follows:
```shell

GET http://localhost:8080/weather/forecast?latitude=51.1&longitude=14.1

HTTP/1.1 200 
Content-Type: application/json
Transfer-Encoding: chunked
Date: Tue, 13 Jun 2023 05:42:01 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
  "latitude": 51.1,
  "longitude": 14.1,
  "forecast": [
    {
      "time": "2023-06-13T00:00:00",
      "forecastedTemperature": 16.100000381469727
    },
    {
      "time": "2023-06-13T01:00:00",
      "forecastedTemperature": 15.800000190734863
    },
    {
      "time": "2023-06-13T02:00:00",
      "forecastedTemperature": 16.100000381469727
    },
    {
      "time": "2023-06-13T03:00:00",
      "forecastedTemperature": 17.399999618530273
    },
    ...
    ]
}

```
## How to build locally
```shell
./gradlew clean build
```

## How to run locally
```shell
./gradlew bootRun
```


## Assignments:
- Implement missing code, fix coding error and test
- Improve coverage to fulfill 95% coverage
- Add a `relative humidity` measure to the result
- What is wrong with the `OpenMeteoClientSpec`?
- What is wrong with the `WeatherController`?
- Implement simple semaphore based on the current weather temperature (< 20: green, < 30: orange, > 40: red) and controller method for it

## Acceptance criteria
- The project should compile, build must pass (`./gradlew clean build`), all tests should pass and coverage should be > 95%
- Each hourly forecast should have `relativeHumidity` information
```json
{
  "latitude": 51.1,
  "longitude": 14.1,
  "forecast": [
    {
      "time": "2023-06-13T00:00:00",
      "forecastedTemperature": 16.100000381469727,
      "relativeHumidity": 40
    },
    //... shortened
  ]
}
```
- There should be added a new endpoint `/weather/semaphore` showing the colours based on current weather.
Expected response e.g.:
```json
{
  "latitude": 51.1,
  "longitude": 14.1,
  "semaphore": "GREEN"
}
```

## Prerequisites
- have Java JDK 21 available on the computer