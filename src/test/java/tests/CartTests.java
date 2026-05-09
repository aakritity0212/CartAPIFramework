package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import client.CartClient;
import io.restassured.response.Response;

public class CartTests extends BaseTest{
	
	CartClient cartClient = new CartClient();

    @Test
    public void createCartTest() {

    	String body = "{\n" +
    	        "  \"userId\": 5,\n" +
    	        "  \"date\": \"2026-05-08\",\n" +
    	        "  \"products\": [\n" +
    	        "    {\n" +
    	        "      \"productId\": 1,\n" +
    	        "      \"quantity\": 2\n" +
    	        "    }\n" +
    	        "  ]\n" +
    	        "}";

        Response res = cartClient.createCart(body);

        Assert.assertEquals(res.statusCode(), 201);
        Assert.assertNotNull(res.jsonPath().getInt("id"));
    }
    
    @Test
    public void updateCartTest() {

        String body = "{\n" +
                "  \"userId\": 5,\n" +
                "  \"products\": [\n" +
                "    {\n" +
                "      \"productId\": 2,\n" +
                "      \"quantity\": 5\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Response response = cartClient.updateCart(1, body);

        Assert.assertEquals(response.statusCode(), 200);
    }
    
    @Test
    public void deleteCartTest() {

        Response response = cartClient.deleteCart(1);

        Assert.assertEquals(response.statusCode(), 200);
    }

}
