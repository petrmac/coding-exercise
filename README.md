# JLL interview coding exercise

This is a coding exercise project. 
The goal is to demonstrate applicants understanding of the current code and ability to improve it.

The example application provides the weather forecast for given `latitude` and `longitude`.
Current implementation uses weather API at https://open-meteo.com/. You can see the API description on the page.

The application is unfinished, there are some errors and some tests are wrong.
There is a simple endpoint serving the hourly forecast in a map indexed by time. 
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
  "forecast": {
    "2023-06-16T10:00": {
      "time": "2023-06-16T10:00:00",
      "forecastedTemperature": 32.29999923706055
    },
    "2023-06-17T10:00": {
      "time": "2023-06-17T10:00:00",
      "forecastedTemperature": 29.299999237060547
    },
    "2023-06-18T10:00": {
      "time": "2023-06-18T10:00:00",
      "forecastedTemperature": 29.399999618530273
    },
    
    ...
  }

```


## Assignments:
- Implement missing code, fix coding error and test
- Add a `relative humidity` measure to the result
- What is wrong with the `OpenMeteoClientSpec`?
- What is wrong with the `WeatherController`?
- (optional, if time allows) Implement simple semaphore based on the current weather temperature (< 20: green, < 30: orange, > 40: red) and controller method for it

## Acceptance criteria
- The project should compile, all tests should pass and coverage should be > 95%
- Each hourly forecast should have `relativeHumidity` information
```json
{
  "latitude": 51.1,
  "longitude": 14.1,
  "forecast": {
    "2023-06-16T10:00": {
      "time": "2023-06-16T10:00:00",
      "forecastedTemperature": 32.29999923706055,
      "relativeHumidity": 50
    }
    //... shortened
  }
}
```
- Add endpoint `/weather/semaphore` showing the colours based on current weather. 

## Prerequisites
- have Java JDK 17 available on the computer