package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.api.client.userClient;
import com.api.models.userDetails;
import com.api.utils.config;
import io.restassured.response.Response;

public class userTest {

    private userClient client;

    @BeforeClass
    public void setup() {
        config.setupBaseURI();  
        client = new userClient();  
    }

    @Test
    public void testCRUD() {
        userDetails user = new userDetails();
        user.setId(101);
        user.setUsername("rono");
        user.setFirstName("cristiano");
        user.setLastName("ronaldo");
        user.setEmail("rono@example.com");
        user.setPassword("12345");
        user.setPhone("7301234567");
        user.setUserStatus(0);

        // Create
        Response createResponse = client.createUser(user);
        System.out.println("CREATE Response:");
        System.out.println(createResponse.asPrettyString());
        
        Assert.assertEquals(createResponse.getStatusCode(), 200);
       // System.out.println(createResponse);

        // Read
        Response getResponse = client.getUser("rono");
        System.out.println("READ Response:");
        System.out.println(getResponse.asPrettyString());
        
        Assert.assertEquals(getResponse.getStatusCode(), 200);

        // Update
        user.setPassword("98765");
        user.setEmail("ronaldo7@gmail.com");
        Response updateResponse = client.updateUser("rono", user);
        System.out.println("UPDATE Response:");
        System.out.println(updateResponse.asPrettyString());
        Assert.assertEquals(updateResponse.getStatusCode(), 200);

        // Delete
        Response deleteResponse = client.deleteUser("rono");
        System.out.println("DELETE Response:");
        System.out.println(deleteResponse.asPrettyString());
        
        Assert.assertEquals(deleteResponse.getStatusCode(), 200);
    }
    
}
