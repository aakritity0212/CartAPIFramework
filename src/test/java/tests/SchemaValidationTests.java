package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import client.CartClient;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidationTests extends BaseTest{
	
	CartClient cartClient = new CartClient();

    @Test
    public void schemaValidationTest() {

        cartClient.getCart(1)
            .then()
            .statusCode(200)
            .body(matchesJsonSchemaInClasspath("schemas/cart-schema.json"));
    }

}
