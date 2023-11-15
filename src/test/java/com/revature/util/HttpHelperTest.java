package com.revature.util;

import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HttpHelperTest {
     @Test
    public void testEmptyUrl() {
        Map<String, String> queryParams = HttpHelper.parseQueryParams("");
        assertEquals(0, queryParams.size());
    }

    @Test
    public void testNoQueryParams() {
        Map<String, String> queryParams = HttpHelper.parseQueryParams("http://example.com");
        assertEquals(0, queryParams.size());
    }

    @Test
    public void testSingleQueryParam() {
        Map<String, String> queryParams = HttpHelper.parseQueryParams("http://example.com?name=John");
        assertEquals(1, queryParams.size());
        assertEquals("John", queryParams.get("name"));
    }

    @Test
    public void testMultipleQueryParams() {
        Map<String, String> queryParams = HttpHelper.parseQueryParams("http://example.com?name=John&age=30&city=NewYork");
        assertEquals(3, queryParams.size());
        assertEquals("John", queryParams.get("name"));
        assertEquals("30", queryParams.get("age"));
        assertEquals("NewYork", queryParams.get("city"));
    }

    @Test
    public void testInvalidQueryParam() {
        Map<String, String> queryParams = HttpHelper.parseQueryParams("http://example.com?name=John&age=");
        assertEquals(2, queryParams.size());
        assertEquals("John", queryParams.get("name"));
        assertEquals("", queryParams.get("age"));
    }

    @Test
    public void testDuplicateQueryParam() {
        Map<String, String> queryParams = HttpHelper.parseQueryParams("http://example.com?name=John&name=Smith");
        assertEquals(1, queryParams.size());
        assertEquals("Smith", queryParams.get("name"));
    }
}
