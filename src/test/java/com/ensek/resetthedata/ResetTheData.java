package com.ensek.resetthedata;

import com.ensek.LoginPojo;
import com.ensek.OrderPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.given;

public class ResetTheData {
    public static String BASEURI = "https://qacandidatetest.ensek.io/ENSEK";

    private static String ENDPOINT_RESET = "/reset";
    public static String token;


    @Test
    public void accessToke() {
        LoginPojo loginPojo = new LoginPojo();
        loginPojo.setUserName("test");
        loginPojo.setPasword("testing");

        Response response = given()
                .body(loginPojo)
                .when()
                .post(BASEURI + "/login");
        token = response.jsonPath().get("access_token");
    }


    @Test
    public void resetTheData() {
        Response response = given()
                .contentType(ContentType.JSON)
                .pathParam("access_token", token)
                .when()
                .post(BASEURI + ENDPOINT_RESET);
        response.then().statusCode(401);
        response.then().body("message", equalTo("Unauthorized"));

// for assertion I have used   Hamcrest library.
    }

}
