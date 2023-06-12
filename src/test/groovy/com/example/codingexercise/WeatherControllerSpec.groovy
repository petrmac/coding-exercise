package com.example.codingexercise

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpHeaders
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.support.AnnotationConfigContextLoader
import org.springframework.test.web.reactive.server.WebTestClient
import spock.lang.Specification

@ActiveProfiles("test")
@EnableAutoConfiguration
@ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class, loader = AnnotationConfigContextLoader.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class WeatherControllerSpec extends Specification {

    WebTestClient webTestClient
    @Autowired
    WeatherController weatherController

    def setup() {
        webTestClient = WebTestClient.bindToController(weatherController).build()
    }

    def "should get weather forecast"() {
        when:
        def response = webTestClient.get()
                .uri("/weather/forecast?latitude=15.11&longitude=44.14")
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("latitude").isEqualTo(15.11)
                .jsonPath("longitude").isEqualTo(15.11)
                .jsonPath("forecast").isNotEmpty()

        then:
        response
    }
}
