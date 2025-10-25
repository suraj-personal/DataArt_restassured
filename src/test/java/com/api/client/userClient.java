package com.api.client;


import com.api.models.userDetails;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class userClient {public Response createUser(userDetails user) {
    return RestAssured.given()
            .header("Content-Type","application/json")
            .body(user)
            .post("/user");
}

public Response getUser(String username) {
    return RestAssured.given().get("/user/" + username);
}

public Response updateUser(String username,userDetails  user) {
    return RestAssured.given()
            .header("Content-Type","application/json")
            .body(user)
            .put("/user/" + username);
}

public Response deleteUser(String username) {
    return RestAssured.given().delete("/user/" + username);
}
}
