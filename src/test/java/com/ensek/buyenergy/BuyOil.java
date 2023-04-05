package com.ensek.buyenergy;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static com.ensek.resetthedata.ResetTheData.BASEURI;
import static io.restassured.RestAssured.given;

public class BuyOil {

    private static String ENDPOINT_BUY = "/buy";


    @Test
    public void buyOilEnergy(){
        Response response = given()
                .contentType(ContentType.JSON)
                .pathParams("id", "4", "quantity", "20")
                .when()
                .put(BASEURI + ENDPOINT_BUY + "/{id}/{quantity}");
        response.then().statusCode(200);

    }
}
