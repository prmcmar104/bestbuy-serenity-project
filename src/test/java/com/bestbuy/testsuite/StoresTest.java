package com.bestbuy.testsuite;

import com.bestbuy.errormessages.ErrorMessages;
import com.bestbuy.steps.StoresSteps;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.annotations.WithTag;
import net.serenitybdd.annotations.WithTags;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.bestbuy.utils.TestUtils.getRandomValue;
import static com.bestbuy.utils.TestUtils.getRandomValueInt;

@RunWith(SerenityRunner.class)
public class StoresTest extends TestBase {

    String name = "Square" + getRandomValue();
    String type = "One Stop Shop";
    String address = "Three petrol pump";
    String address2 = "Thane(W)";
    String city = "Mumbai";
    String state = "Maharastra";
    String zip = "400602";
    String lat = "2.22" + getRandomValueInt();
    String lng = "9.99" + getRandomValueInt();
    String hours = "Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8";

    @Steps
    StoresSteps steps;

    @WithTags({
            @WithTag("storeFeature:Smoke"),
            @WithTag("storeFeature:Regression")
    })
    @Title("This test will get all stores")
    @Test
    public void getAllStores() {
        steps.getAllStores().statusCode(200);
    }

    @WithTags({
            @WithTag("storeFeature:Sanity"),
            @WithTag("storeFeature:Regression")
    })
    @Title("This test will get a specific product by Id")
    @Test
    public void getStoreById() {
        int storeId = steps.getAllStores().statusCode(200).extract().path("data[0].id");
        steps.getStoreById(storeId).statusCode(200);
    }

    @WithTags({
            @WithTag("storeFeature:Positive"),
            @WithTag("storeFeature:Regression")
    })
    @Title("This test will create a new product")
    @Test
    public void createAStore() {
        steps.createStore(name, type, address, address2, city, state, zip, lat, lng, hours).statusCode(201);
    }

    @WithTags({
            @WithTag("storeFeature:Positive"),
            @WithTag("storeFeature:Regression")
    })
    @Title("This test will update a name of an existing store")
    @Test
    public void UpdateAnStoreProduct() {
        int storeId = steps.getAllStores().statusCode(200).extract().path("data[1].id");
        steps.updateStore(storeId, name, null, null, null, null, null, null,
                null, null, null).statusCode(200);
    }

    @WithTags({
            @WithTag("storeFeature:Negative"),
            @WithTag("storeFeature:Regression")
    })
    @Title("This test will delete the store using storeId")
    @Test
    public void deleteAStoreUsingId() {
        int storeId = steps.getAllStores().statusCode(200).extract().path("data[1].id");
        steps.deleteStore(storeId).statusCode(200);
        steps.getStoreById(storeId).statusCode(404);
    }

    @WithTags({
            @WithTag("productFeature:Negative"),
            @WithTag("productFeature:Regression")
    })
    @Title("Verify 'Not found' error message with invalid endpoint")
    @Test
    public void verifyNotFoundErrorMessage() {
        ValidatableResponse response = steps.sendRequestToInvalidEndpoint();
        ErrorMessages.verifyNotFoundMessage(response);
    }

}
