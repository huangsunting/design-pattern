package com.bravo.pattern.builder.stepbuilder.httprequest;

public class Client {
    public static void main(String[] args) {
        HttpRequest request = HttpRequest.builder()
                .withUrl("https://api.example.com")
                .withMethod(HttpRequest.HttpMethod.POST)
                .withHeader("Content-Type", "application/json")
                .withParameter("key1", "value1")
                .withParameter("key2", "value2")
                .withBody("key1", "value1")
                .withBody("key2", "value2")
                .build();

        System.out.println("Url: " + request.getUrl());
        System.out.println("Method: " + request.getMethod());
        System.out.println("Headers: " + request.getHeaders());
        System.out.println("Parameters: " + request.getParameters());
        System.out.println("Body: " + request.getBody());
    }
}