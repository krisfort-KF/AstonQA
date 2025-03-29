package org.example;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PostmanEchoTest {

    private static final String BASE_URL = "https://postman-echo.com";

    static RequestSpecification requestSpecification;

    @BeforeAll
    static void setUp() {

        requestSpecification = RestAssured.given()
                .baseUri(BASE_URL);
    }

    @Test
    public void testGetRequest() {

        given()
                .spec(requestSpecification)
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void testPostRequestWithFormData() {

        given()
                .spec(requestSpecification)
                .contentType("application/x-www-form-urlencoded;charset=UTF-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    void testPostRequestWithRawText() {
        String requestBody = "post test body";

        given()
                .spec(requestSpecification)
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    void testPutRequest() {
        String requestBody = "put test body";

        given()
                .spec(requestSpecification)
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    void testPatchRequest() {
        String requestBody = "patch test body";

        given()
                .spec(requestSpecification)
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    void testDeleteRequest() {
        String requestBody = "delete test body";

        given()
                .spec(requestSpecification)
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                .log().ifValidationFails()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}