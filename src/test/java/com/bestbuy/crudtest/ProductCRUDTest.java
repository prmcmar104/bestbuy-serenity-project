package com.bestbuy.crudtest;

import com.bestbuy.steps.ProductSteps;
import com.bestbuy.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.annotations.WithTag;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static com.bestbuy.utils.TestUtils.getRandomValue;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductCRUDTest extends TestBase {

    static String name = "McVities Biscuits" + getRandomValue();
    static String type = "Biscuits & Crackers";
    static String upc = "12345" + getRandomValue();
    static double price = 2.98;
    static String description = "This is a placeholder request for creating a new product";
    static String model = "xyz" + getRandomValue();
    static int productId;

    @Steps
    ProductSteps productSteps;

    @WithTag("ProductCrudTest")
    @Title("This test will create a new product")
    @Test
    public void test001() {
        ValidatableResponse response = productSteps.createProduct(name, type, upc, price, description, model);
        response.statusCode(201);
        productId = response.extract().path("id");
    }

    @WithTag("ProductCrudTest")
    @Title("Update the price of product and verify the updated information")
    @Test
    public void test002() {
        price = price + 7;

         productSteps.updateProduct(productId, null, null, null,
                price, null, null).statusCode(200);

        ValidatableResponse response1 = productSteps.getProductById(productId);
        assertThat(response1.extract().path("price"), equalTo((float)price));
    }

    @WithTag("ProductCrudTest")
    @Title("Delete the product and verify if the product is deleted")
    @Test
    public void test003() {
        productSteps.deleteProduct(productId).statusCode(200);
        productSteps.getProductById(productId).statusCode(404);
    }

}
