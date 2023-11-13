package com.revature.util;

import java.util.Map;
import java.util.HashMap;

// create a class that has helper methods for HTTP methods

public class HttpHelper {
	
	// Given a URL, parse out the query parameters and return as a map:
    public static Map<String, String> parseQueryParams(String url) {
        // parse out the query params and return the map:
        Map<String, String> queryParams = new HashMap<>();
        int idx = url.indexOf("?");
        if (idx != -1) {
            String query = url.substring(idx + 1);
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                queryParams.put(keyValue[0], keyValue[1]);
            }
        }
        return queryParams;
    }

}