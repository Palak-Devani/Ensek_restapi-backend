package com.ensek.buyenergy;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static com.ensek.resetthedata.ResetTheData.BASEURI;
import static io.restassured.RestAssured.given;

public class BuyNuclear {
    public static String ENDPOINT_BUY = "/buy";


    @Test
    public void buyNuclearEnergy(){
        Response response = given()
                .contentType(ContentType.JSON)
                .pathParams("id", "3", "quantity", "100")
                .when()
                .put(BASEURI + ENDPOINT_BUY + "/{id}/{quantity}");
        response.then().statusCode(200);

    }
}
