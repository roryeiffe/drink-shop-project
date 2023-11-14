package com.revature.util;

import java.util.Map;
import java.util.HashMap;

// TODO: Document the purpose & describe what this class does using JavaDocs
public class HttpHelper {

    // TODO: Document the purpose & describe what this method does using JavaDocs
    // TODO: Add unit tests for this method
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