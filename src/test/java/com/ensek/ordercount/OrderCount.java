package com.ensek.ordercount;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static io.restassured.RestAssured.given;

public class OrderCount {


        @Test
        public void confirmOrder() throws JsonProcessingException {
            Response response = given()
                    .when()
                    .get("https://qacandidatetest.ensek.io/ENSEK/orders");
            response.then().statusCode(200);
            System.out.println(countOrdersBeforeCurrentDate(response));
        }


        public int countOrdersBeforeCurrentDate(Response response) {
            int count = 0;
            List<Object> orders = response.jsonPath().getList("");
            SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
            String currentDateStr = formatter.format(new Date());
            Date currentDate;
            try {
                currentDate = formatter.parse(currentDateStr);
            } catch (ParseException e) {
                System.err.println("Error parsing current date: " + e.getMessage());
                return count;
            }
            for (Object order : orders) {
                if (order instanceof java.util.LinkedHashMap) {
                    java.util.LinkedHashMap<String, Object> map = (java.util.LinkedHashMap<String, Object>) order;
                    String timeStr = (String) map.get("time");
                    Date time;
                    try {
                        time = formatter.parse(timeStr);
                    } catch (ParseException e) {
                        System.err.println("Error parsing time string: " + timeStr + " - " + e.getMessage());
                        continue;
                    }
                    if (time.before(currentDate)) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

