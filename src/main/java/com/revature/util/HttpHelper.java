package com.revature.util;

import java.util.Map;
import java.util.HashMap;

public class HttpHelper {

    public static Map<String, String> parseQueryParams(String url) {
        Map<String, String> queryParams = new HashMap<>();
        int idx = url.indexOf("?");
        if (idx != -1) {
            String query = url.substring(idx + 1);
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                // The code checks to see if there is in fact a value on the right side of
                // the equals sign and otherwise places an empty string as the map value
                try {
                    queryParams.put(keyValue[0], keyValue[1]);
                } catch (IndexOutOfBoundsException e) {
                    queryParams.put(keyValue[0], "");
                }
            }
        }
        return queryParams;
    }

}