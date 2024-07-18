package com.bestbuy.model;

/**
 * Created by Jay
 */
public class ProductAPIRequest {

    public static ProductPojo getAPIProductRequest(String name, String type, String upc, double price,
                                            String description, String model){
        ProductPojo productPojo = new ProductPojo();
        if (name != null) {
            productPojo.setName(name);
        }
        if (type != null) {
            productPojo.setType(type);
        }
        if (upc != null) {
            productPojo.setUpc(upc);
        }
        if (price > 0) {
            productPojo.setPrice(price);
        }
        if (description != null) {
            productPojo.setDescription(description);
        }
        if (model != null) {
            productPojo.setModel(model);
        }
        return productPojo;
    }
}
