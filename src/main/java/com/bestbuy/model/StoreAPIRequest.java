package com.bestbuy.model;

/**
 * Created by Jay
 */
public class StoreAPIRequest {

    public static StoresPojo getAPIStoreRequest(String name, String type, String address, String address2, String city,
                                         String state, String zip, String lat, String lng, String hours) {
        StoresPojo storesPojo = new StoresPojo();
        if (name != null) {
            storesPojo.setName(name);
        }
        if (type != null) {
            storesPojo.setType(type);
        }
        if (address != null) {
            storesPojo.setAddress(address);
        }
        if (address2 != null) {
            storesPojo.setAddress2(address2);
        }
        if (city != null) {
            storesPojo.setCity(city);
        }
        if (state != null) {
            storesPojo.setState(state);
        }
        if (zip != null) {
            storesPojo.setZip(zip);
        }
        if (lat != null) {
            storesPojo.setLat(Float.parseFloat(lat));
        }
        if (lng != null) {
            storesPojo.setLng(Float.parseFloat(lng));
        }
        if (hours != null) {
            storesPojo.setHours(hours);
        }
        return storesPojo;
    }
}
