package utils;

import io.restassured.RestAssured;

public class BaseAPI {
	
	public static void setup() {
        RestAssured.baseURI = "https://fakestoreapi.com";
    }

}
