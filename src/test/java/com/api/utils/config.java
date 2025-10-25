package com.api.utils;

import io.restassured.RestAssured;

public class config {
	
	public static void setupBaseURI() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

}
