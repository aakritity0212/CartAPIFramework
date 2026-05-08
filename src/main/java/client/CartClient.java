package client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CartClient {
	public Response createCart(String body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .post("/carts");
    }

    public Response getCart(int id) {
        return given()
                .get("/carts/" + id);
    }

    public Response updateCart(int id, String body) {
        return given()
                .header("Content-Type", "application/json")
                .body(body)
                .put("/carts/" + id);
    }

    public Response deleteCart(int id) {
        return given()
                .delete("/carts/" + id);
    }
}
