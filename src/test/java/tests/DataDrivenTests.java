package tests;

import org.testng.annotations.DataProvider;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import base.BaseTest;
import client.CartClient;

public class DataDrivenTests extends BaseTest{
	
	CartClient cartClient = new CartClient();

    @DataProvider(name = "products")
    public Object[][] data() {
        return new Object[][] {
            {1}, {2}, {3}
        };
    }

    @Test(dataProvider = "products")
    public void testMultipleProducts(int productId) {

    	String body = String.format("{\n" +
    	        "  \"userId\": 5,\n" +
    	        "  \"date\": \"2026-05-08\",\n" +
    	        "  \"products\": [\n" +
    	        "    {\n" +
    	        "      \"productId\": %d,\n" +
    	        "      \"quantity\": 1\n" +
    	        "    }\n" +
    	        "  ]\n" +
    	        "}", productId);

        cartClient.createCart(body)
            .then()
            .statusCode(201)
            .body("products[0].productId", equalTo(productId));
    }

}
