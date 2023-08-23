package com.qa.api.tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIResponse;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Map;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GetApiCallTest extends Commons {

    @BeforeTest
    public void setUpBeforeTest() {
        setup();
    }

    @Test
    public void  getUsersApiTest() throws IOException {
        APIResponse apiResponse = getUrl();
        assertEquals(apiResponse.status(), 200);
        assertTrue(apiResponse.ok());

        Map<String, String> headersMap = apiResponse.headers();
        assertEquals(headersMap.get("content-type"), "application/json; charset=utf-8");

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(apiResponse.text());
        System.out.println(jsonNode.toPrettyString());
        assertEquals(jsonNode.get("additionalneeds").asText(), "Breakfast");
    }

    @AfterTest
    public void tearDownAfterTest() {
        tearDown();
    }
}