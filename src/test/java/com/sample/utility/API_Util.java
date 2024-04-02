package com.sample.utility;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class API_Util {


    /**
     * Return TOKEN as String by using provided username from /token endpoint
     * @param userType
     * @return
     */
    public static String getToken(String userType){


        String email=ConfigurationReader.getProperty(userType+"_username");
        String password="userpass";



        return getToken(email,password);


    }

    public static String getToken(String email,String password){


        return given()
                .contentType(ContentType.URLENC)
                .formParam("email" , email)
                .formParam("password" , password).
                when()
                .post(ConfigurationReader.getProperty("baseUri")+"/login")
                .prettyPeek()
                .then().statusCode(200)
                .extract().jsonPath().getString("token");



    }



}
