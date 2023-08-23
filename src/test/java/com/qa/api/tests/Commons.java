package com.qa.api.tests;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;

public class Commons {
    Playwright playwright;
    APIRequest request;
    APIRequestContext requestContext;

    public void setup() {
        playwright = Playwright.create();
        request = playwright.request();
        requestContext = request.newContext();
    }

    public void tearDown() {
        playwright.close();
    }

    public APIResponse getUrl(){
        return requestContext.get("https://restful-booker.herokuapp.com/booking/5");
    }
}
