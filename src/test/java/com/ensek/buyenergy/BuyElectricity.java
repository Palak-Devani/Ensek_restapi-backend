package com.ensek.buyenergy;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static com.ensek.resetthedata.ResetTheData.BASEURI;
import static io.restassured.RestAssured.given;

public class BuyElectricity {

    public static String ENDPOINT_BUY = "/buy";


    @Test
    public void buyElectricityEnergy(){
        Response response = given()
                .contentType(ContentType.JSON)
                .pathParams("id", "3", "quantity", "4322")
                .when()
                .put(BASEURI + ENDPOINT_BUY + "/{id}/{quantity}");
        response.then().statusCode(200);

    }
}
