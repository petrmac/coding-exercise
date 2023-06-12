package com.example.codingexercise

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.support.AnnotationConfigContextLoader
import spock.lang.Specification

@ActiveProfiles("test")
@EnableAutoConfiguration()
@SpringBootTest
@ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class, loader = AnnotationConfigContextLoader.class)
class CodingExerciseApplicationTest extends Specification {


    @Autowired (required = false)
    private WeatherController weatherController

    def "when context is loaded then all expected beans are created"() {
        expect: "the WeatherController is created"
        weatherController
    }
}
