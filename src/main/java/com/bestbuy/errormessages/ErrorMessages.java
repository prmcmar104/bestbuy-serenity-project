package com.bestbuy.errormessages;

import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Jay
 */
public class ErrorMessages {

    public static void verifyNotFoundMessage(ValidatableResponse response) {
        response.log().ifValidationFails();
        try {
            response.body("name", equalTo("NotFound"),
                    "message", equalTo("Page not found"),
                    "code", equalTo(404),
                    "className", equalTo("not-found"));
        } catch (AssertionError e) {
            throw new Error(e);
        }
    }
}
