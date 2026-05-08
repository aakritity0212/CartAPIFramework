package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class AuthTests extends BaseTest{
	
	@Test
    public void validLoginTest() {

        String body = "{\n" +
                "  \"username\": \"john_doe\",\n" +
                "  \"password\": \"pass123\"\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/auth/login");

        response.then().statusCode(200);

        String token = response.jsonPath().getString("token");

        System.out.println("Generated Token: " + token);

        Assert.assertNotNull(token);
    }

    @Test
    public void invalidLoginTest() {

        String body = "{\n" +
                "  \"username\": \"wrong_user\",\n" +
                "  \"password\": \"wrong_pass\"\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/auth/login");

        System.out.println(response.asPrettyString());

        Assert.assertTrue(
                response.statusCode() == 401 ||
                response.statusCode() == 400
        );
    }

}
