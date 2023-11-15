package com.revature.util;

import java.util.Map;
import java.util.HashMap;

/**
 * The HttpHelper class is a utility class that provides helper methods for handling HTTP-related tasks.
 * In the current context, it provides a method to parse the query parameters from a given URL.
 */
public class HttpHelper {

    /**
     * Parses the query parameters from the given URL.
     * This method takes a URL string as an argument, checks if there is a query string in the URL (the part after the "?"),
     * and if so, it splits the query string into key-value pairs and stores them in a Map.
     * Each key-value pair represents a query parameter and its value.
     * @param url the URL string to parse the query parameters from.
     * @return a Map of query parameters where the key is the parameter name and the value is the parameter value.
     */
    public static Map<String, String> parseQueryParams(String url) {
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