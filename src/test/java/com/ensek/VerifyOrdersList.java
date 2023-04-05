package com.ensek;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static com.ensek.resetthedata.ResetTheData.BASEURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class VerifyOrdersList {


    private static String ENDPOINT_ORDERS = "/orders";


    @Test
    public void orderDetailVerify() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASEURI + ENDPOINT_ORDERS);
        response.then().statusCode(200);
        response.then().log().all();



        response.then().body("[3].fuel", equalTo("gas"));
        //[3].fuel).to.eql("gas")


    }
}
