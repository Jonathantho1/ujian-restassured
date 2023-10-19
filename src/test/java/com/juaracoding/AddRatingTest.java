package com.juaracoding;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRatingTest {

    @Test
    public void addRatingTest(){
        RestAssured.baseURI = "https://api.themoviedb.org";
        RequestSpecification request = RestAssured.given();

        JSONObject requestBody = new JSONObject();

        requestBody.put("value",9.5);
        request.header("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5NmZlOGU0MWY3MmVjZjBkMmM5NzdiODE2N2VkNmViNyIsInN1YiI6IjY1MmZjMWI3Y2FlZjJkMDBjNTI3ZTgwNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.QsHBvse25im0OaRreVm-0B_2oAsfDfR1sX6ixDYX-oM");
        request.header("Content-Type","application/json");
        request.body(requestBody.toJSONString());

        Response response = request.post("/3/movie/575264/rating");
        Assert.assertEquals(response.getStatusCode(), 201);
    }
}
