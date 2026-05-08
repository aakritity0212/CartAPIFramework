package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import client.CartClient;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;

public class ContractTests extends BaseTest{
	
	 @Test
	    public void contractTest() {
		 
		 CartClient cartClient = new CartClient();
		 
	     cartClient.getCart(1)
	            .then()
	            .statusCode(200)
	            .body("id", instanceOf(Integer.class))
	            .body("userId", instanceOf(Integer.class))
	            .body("products", notNullValue());
	    }

}
