package base;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class BaseApi {

    protected RequestSpecification request() {
        return given()
                .baseUri("https://restful-booker.herokuapp.com")
                .contentType(JSON);
    }
}
