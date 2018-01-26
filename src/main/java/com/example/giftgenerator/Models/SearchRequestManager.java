package com.example.giftgenerator.Models;

import java.util.HashMap;
import java.util.Map;

public class SearchRequestManager {


    /*
     * Access Key ID, as taken from Account page.
     */
    private static final String ACCESS_KEY_ID = "";

    /*
     * Secret Key corresponding to the above ID
     */
    private static final String SECRET_KEY = "";

    /*
     * End-point according to the region you are interested in.
     */
    private static final String ENDPOINT = "webservices.amazon.com";

    /**
     * Creates a URL request string based on user input
     * @param searchRequest the user input object
     * @return the string url
     */
    public static String getSearchResults(SearchRequest searchRequest) {

        /*
         * Set up the signed requests helper.
         */
        SignedRequestsHelper helper;

        try {
            helper = SignedRequestsHelper.getInstance(ENDPOINT, ACCESS_KEY_ID, SECRET_KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return ("Error" + e);
        }

        String requestUrl = null;

        String price = searchRequest.getPrice();
        String gender = searchRequest.getGender();
        String hobby = searchRequest.getHobby();

        if(hobby.equals("Fashion")){
            if(gender.equals("girl")){
                hobby = "FashionGirls";
            }
            if(gender.equals("boy")){
                hobby = "FashionBoys";
            }
            if(gender.equals("woman")){
                hobby = "FashionWomen";
            }
            if(gender.equals("man")){
                hobby = "FashionMen";
            }
        }

        Map<String, String> params = new HashMap<String, String>();

        params.put("Service", "AWSECommerceService");
        params.put("Operation", "ItemSearch");
        params.put("AWSAccessKeyId", "");
        params.put("AssociateTag", "giftgenerat0e-20");
        params.put("Availability", "Available");
        params.put("MaximumPrice", price);
        params.put("MinimumPrice", "999");
        params.put("ResponseGroup", "Images,ItemAttributes,Offers");

        if(!hobby.equals("All")){
            if(hobby.contains("Fashion")){
                params.put("Sort","popularity-rank");
            }
        }

        if(!hobby.equals("cooking")){
            params.put("SearchIndex", hobby);
            params.put("Keywords", "gifts for " + gender);
        }
        else{
            params.put("SearchIndex", "All");
            params.put("Keywords", "cooking gifts for " + gender);
        }

        requestUrl = helper.sign(params);

        return requestUrl;
    }
}






