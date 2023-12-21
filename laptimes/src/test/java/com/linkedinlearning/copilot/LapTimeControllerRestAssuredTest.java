package com.linkedinlearning.copilot;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LapTimeControllerRestAssuredTest {

    @LocalServerPort
    private int port;

    @Test
    public void getAllLapTimes_returnsCorrectData() {
        given()
                .baseUri("http://localhost")
                .port(port)
                .when()
                .get("/api/laptimes")
                .then()
                .statusCode(200)
                .body("$", hasSize(8)) // Assuming there are 8 records in the test data
                .body("[0].driver", equalTo("Lewis Hamilton"))
                .body("[0].car", equalTo("Mercedes"))
                .body("[0].track", equalTo("Silverstone"));
        // Add more assertions as needed
    }
}
