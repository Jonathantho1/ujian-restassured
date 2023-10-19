package com.juaracoding;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class NowPlayingTest {

    String endpoint = "https://api.themoviedb.org/3/movie/now_playing";

    @Test
    public void nowPlayingTest(){
        given().header("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5NmZlOGU0MWY3MmVjZjBkMmM5NzdiODE2N2VkNmViNyIsInN1YiI6IjY1MmZjMWI3Y2FlZjJkMDBjNTI3ZTgwNSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.QsHBvse25im0OaRreVm-0B_2oAsfDfR1sX6ixDYX-oM")
                .get(endpoint)
                .then()
                .statusCode(200)
                .body("results[1].id",equalTo(926393));
    }
}
