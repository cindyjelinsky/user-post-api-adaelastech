package com.chj.postapi.httpservice;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class HttpService {

    private final HttpClient httpClient;

    public HttpService(HttpClient httpClient) {
        this.httpClient = httpClient;
    }


    public String httpGetSingle() {


        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://dummyjson.com/posts/1"))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {

            throw new RuntimeException("HttpRequest failed:" + e.getMessage());

        }


    }


    public String httpGetMultiple() {


        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://dummyjson.com/posts"))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {

            throw new RuntimeException("HttpRequest failed:" + e.getMessage());

        }
    }


    public String httpGetMultipleUsers() {


        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://dummyjson.com/users"))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {

            throw new RuntimeException("HttpRequest failed:" + e.getMessage());

        }
    }


}
