package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Named;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @InjectMock
    @Named("english")
    SayHello sayHelloInEnglish;

    @InjectMock
    @Named("french")
    SayHello sayHelloInFrench;

    @BeforeEach
    public void setup() {
        Mockito.doReturn("helloMocked").when(sayHelloInEnglish).hello();
        Mockito.doReturn("bonjourMocked").when(sayHelloInFrench).hello();
    }

    @Test
    public void testSayHelloInEnglishEndpoint() {
        given()
          .when().get("/hello/english")
          .then()
             .statusCode(200)
             .body(is("helloMocked"));
    }

    @Test
    public void testSayHelloInFrenchEndpoint() {
        given()
                .when().get("/hello/french")
                .then()
                .statusCode(200)
                .body(is("bonjourMocked"));
    }

}