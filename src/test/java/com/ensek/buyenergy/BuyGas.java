package com.ensek.buyenergy;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static com.ensek.resetthedata.ResetTheData.BASEURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BuyGas {

    public static String ENDPOINT_BUY = "/buy";


    @Test
    public void buyGasEnergy(){
        Response response = given()
                .contentType(ContentType.JSON)
                .pathParams("id", "1", "quantity", "3000")
                .when()
                .put(BASEURI + ENDPOINT_BUY + "/{id}/{quantity}");
        response.then().statusCode(200);

    }
}
