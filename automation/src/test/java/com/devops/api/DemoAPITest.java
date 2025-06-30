package com.devops.api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.equalTo;


public class DemoAPITest {

    @Test
    public void testAPI() {
        RestAssured
            .given()
            .when()
            .get("https://jsonplaceholder.typicode.com/posts/1")
            .then()
            .statusCode(200)
            .body("id", equalTo(1));
    }
}
