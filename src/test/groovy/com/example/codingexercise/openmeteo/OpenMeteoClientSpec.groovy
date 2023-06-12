package com.example.codingexercise.openmeteo

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
class OpenMeteoClientSpec extends Specification {

    @Autowired
    OpenMeteoClient client

    def "should get forecast"() {
        when:
        def result = client.getForecast(52.25, 14.41)

        then:
        result
    }
}
