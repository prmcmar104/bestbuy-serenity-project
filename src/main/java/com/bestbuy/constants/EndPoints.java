package com.bestbuy.constants;

public class EndPoints {

    /**
     * Products Endpoints
     */
    public static final String GET_ALL_PRODUCTS = "/products";
    public static final String CREATE_PRODUCT = "/products";
    public static final String GET_PRODUCT_BY_ID = "/products/{productId}";
    public static final String UPDATE_PRODUCT_BY_ID = "/products/{productId}";
    public static final String DELETE_PRODUCT_BY_ID = "/products/{productId}";
    public static final String INVALID_ENDPOINT_PRODUCT = "/products123";



    /**
     * Stores Endpoints
      */
    public static final String GET_ALL_STORES = "/stores";
    public static final String CREATE_STORE = "/stores";
    public static final String GET_STORE_BY_ID = "/stores/{storeId}";
    public static final String UPDATE_STORE_BY_ID = "/stores/{storeId}";
    public static final String DELETE_STORE_BY_ID = "/stores/{storeId}";
    public static final String INVALID_ENDPOINT_STORE = "/store123";

}


