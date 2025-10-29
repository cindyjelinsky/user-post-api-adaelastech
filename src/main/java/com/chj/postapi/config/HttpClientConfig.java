package com.chj.postapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

@Configuration
public class HttpClientConfig {

    @Bean
    public HttpClient httpClient(){
        return HttpClient.newBuilder()
                .build();
    }


}


