package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import client.CartClient;
import io.restassured.response.Response;

public class Negativetests {
	
	CartClient cartClient = new CartClient();

    @Test
    public void getInvalidCartTest() {

        Response response = cartClient.getCart(99999);

        Assert.assertTrue(
                response.statusCode() == 404 ||
                response.statusCode() == 400
        );
    }

}
